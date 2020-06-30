import requests
import os
import json
    
def join(stringList):
    output = ""
    for string in stringList:
        output += string
    return output

with requests.Session() as session:
    response = session.get('https://signer-lac.azurewebsites.net/swagger/api/swagger.json')
    response_json = json.loads(response.content)

schemas = response_json['components']['schemas']
schemaNames = list(schemas.keys())

classNames = {}
for name in schemaNames:
    if '.' in name:
        classNamespaceAndName = name.split('.')
        generatedClassName = join(classNamespaceAndName)

        if (not generatedClassName in classNames.keys()):
            classNames[generatedClassName] = {}

        classNames[generatedClassName]['namespace'] = classNamespaceAndName[0].lower()
        classNames[generatedClassName]['name'] = classNamespaceAndName[1]

dirname = os.path.dirname(__file__) + '\\src\\main\\java\\com\\lacunasoftware\\signer'
javaClassList = os.listdir(dirname)

for className in classNames:
    fileName = className + '.java'
    if fileName in javaClassList:
        package = dirname + '\\' + classNames[className]['namespace']
        if not os.path.exists(package):
            os.mkdir(package)
        
        with open(dirname + '\\' + fileName, 'rb') as file:
            fileData = file.read()
        
        oldNamespace = bytes('package com.lacunasoftware.signer', 'utf-8')
        newNamespace = bytes('package com.lacunasoftware.signer.' + classNames[className]['namespace'], 'utf-8')
        fileData = fileData.replace(oldNamespace, newNamespace)

        for otherClassName in classNames:
            oldImport = bytes('import com.lacunasoftware.signer.' + otherClassName, 'utf-8')
            newImport = bytes('import com.lacunasoftware.signer.' + classNames[otherClassName]['namespace'] + '.' + classNames[otherClassName]['name'], 'utf-8')
            fileData = fileData.replace(oldImport, newImport)

            oldClassReferences = bytes(otherClassName, 'utf-8')
            newClassReferences = bytes(classNames[otherClassName]['name'], 'utf-8')
            fileData = fileData.replace(oldClassReferences, newClassReferences)

        with open(dirname + '\\' + fileName, 'wb') as file:
            file.write(fileData)
        
        os.rename(dirname + '\\' + fileName, dirname + '\\' + classNames[className]['namespace'] + '\\' + classNames[className]['name'] + '.java')
        

