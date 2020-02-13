param([string]$ToolPath)
$ErrorActionPreference = "Stop"

try {

	if ([String]::IsNullOrEmpty($ToolPath)) {
		Write-Host ("Syntax: {0} [-ToolPath] <swagger-codegen path>" -f $MyInvocation.MyCommand.Name)
		exit 1
	}

	Write-Host ">>> Initializing ..."

	$toolJarPath = Resolve-Path ($ToolPath + "\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar")
	$tempDir = ("{0}\{1}" -f $env:TEMP, [Guid]::NewGuid())

	Write-Host ">>> Generating code ..."

	&java -jar $toolJarPath generate -i https://signer-lac.azurewebsites.net/swagger/api/swagger.json -l java -c swagger-codegen-config.json -o $tempDir
	
	Write-Host ">>> Copying classes to project ..."

	Copy-Item ("{0}\*" -f $tempDir) . -Recurse -Force
	
	Write-Host ">>> Doing some housekeeping ..."

	Remove-Item $tempDir -Recurse -Force
	
	Write-Host ">>> Done."

} catch {

	Write-Error ("Error: " + $_)
	exit 2
	
}
