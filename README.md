Signer package for Java
====================================
**Standard version for Java 8 and greater**

This package contains classes that encapsulate the calls to the Signer.

The **Signer package** is distributed by [Bintray](https://bintray.com/lacunasoftware/maven/signer-client).

The recommended way to install it is with Gradle:
    
    repositories {
        mavenCentral()
        maven {
            url  "http://dl.bintray.com/lacunasoftware/maven"
        }
    }
    
    dependencies {
        implementation("com.lacunasoftware.signer:signer-client:2.2.2")
        ...
    }
        
Or with Maven:
         
    <dependency>
        <groupId>com.lacunasoftware.signer</groupId>
        <artifactId>signer-client</artifactId>
        <version>2.2.2</version>
        <type>pom</type>
    </dependency>
      
    
Samples
-------

Please visit the [Signer samples repository](https://github.com/LacunaSoftware/SignerSamples/tree/master/java)
for examples on how to use this package.
