import requests
import os
import json
import shutil

with requests.Session() as session:
    response = session.get('https://signer-lac.azurewebsites.net/swagger/api/swagger.json')
    response_json = json.loads(response.content)

schemas = response_json['components']['schemas']
schemaNames = list(schemas.keys())

classNames = {}
for name in schemaNames:
    if '.' in name:
        classNamespaceAndName = name.split('.')
        generatedClassName = "".join(classNamespaceAndName)

        if (not generatedClassName in classNames.keys()):
            classNames[generatedClassName] = {}

        classNames[generatedClassName]['namespace'] = classNamespaceAndName[0].lower()
        classNames[generatedClassName]['name'] = classNamespaceAndName[1]

dirname = os.path.dirname(__file__) + '\\src\\main\\java\\com\\lacunasoftware\\signer'
for className in classNames:
    package = dirname + '\\' + classNames[className]['namespace']
    if os.path.exists(package):
        shutil.rmtree(package)

javaFileClassList = os.listdir(dirname)
for javaFileClass in javaFileClassList:
    with open(dirname + '\\' + javaFileClass, 'rb') as file:
        fileData = file.read()

    for className in classNames:

        oldImport = bytes('import com.lacunasoftware.signer.' + className, 'utf-8')
        newImport = bytes('import com.lacunasoftware.signer.' + classNames[className]['namespace'] + '.' + classNames[className]['name'], 'utf-8')
        fileData = fileData.replace(oldImport, newImport)

        oldClassReferences = bytes(className, 'utf-8')
        newClassReferences = bytes(classNames[className]['name'], 'utf-8')
        fileData = fileData.replace(oldClassReferences, newClassReferences)

    javaClass = javaFileClass[:-5] # Removes .java
    if javaClass in classNames.keys():
        oldNamespace = bytes('package com.lacunasoftware.signer', 'utf-8')
        newNamespace = bytes('package com.lacunasoftware.signer.' + classNames[javaClass]['namespace'], 'utf-8')
        fileData = fileData.replace(oldNamespace, newNamespace)


    with open(dirname + '\\' + javaFileClass, 'wb') as file:
            file.write(fileData)

    if javaClass in classNames.keys():
        folder = dirname + '\\' + classNames[javaClass]['namespace']
        if not os.path.exists(folder):
            os.mkdir(folder)

        os.rename(dirname + '\\' + javaFileClass, folder + '\\' + classNames[javaClass]['name'] + '.java')

with open('swagger-discard.json', 'rb') as file:
    discard = json.loads(file.read())

for folderToDiscard in discard['folders']:
    shutil.rmtree(os.path.dirname(__file__) + folderToDiscard)

for fileToDiscard in discard['files']:
    os.remove(os.path.dirname(__file__) + fileToDiscard)

for changeToDiscard in discard['discardChanges']:
    os.system('git checkout ' + os.path.dirname(__file__) + changeToDiscard)