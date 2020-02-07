Signer package for Java
====================================
**Standard version for Java 7 and greater**

This package contains classes that encapsulate the calls to the Signer.

The **PKI Express package** is distributed by [Bintray](https://bintray.com/lacunasoftware/maven/signer-client).

The recommended way to install it is with Gradle:
    
    repositories {
        mavenCentral()
        maven {
            url  "http://dl.bintray.com/lacunasoftware/maven"
        }
    }
    
    dependencies {
        compile("com.lacunasoftware.signer:signer-client:1.0.0")
        ...
    }
        
Or with Maven:
         
    <dependency>
      <groupId>com.lacunasoftware.signer</groupId>
      <artifactId>signer-client</artifactId>
      <version>1.0.0/version>
      <type>pom</type>
    </dependency>
      
    
Samples
-------

Please visit the [PKI Express samples repository](https://github.com/LacunaSoftware/SignerJavaClient/tree/master/Java)
for examples on how to use this package.
