Releasing signer-client
=======================

Artifacts are published to Maven Central through the
[Central Portal](https://central.sonatype.com/artifact/com.lacunasoftware.signer/signer-client/overview).

The legacy OSSRH host (`s01.oss.sonatype.org`) that earlier releases used has been
decommissioned, so Gradle no longer uploads directly. Instead the build stages the
artifacts locally, packs them into a single zip, and that bundle is uploaded to the
Portal.

Prerequisites
-------------

Create `gradle.properties` in the project root (it is git-ignored — never commit it).
Use `gradle.properties-template` as the starting point:

    signing.keyId=<last 8 chars of your GPG key id>
    signing.password=<GPG key passphrase>
    signing.secretKeyRingFile=<path to secring.gpg>

A Central Portal **user token** is also needed. Generate it under Account → Generate
User Token, then base64-encode `username:password` for the `Authorization` header.

Steps
-----

1. Bump `version` in `build.gradle` and the two version references in `README.md`.
   Releases are immutable on Maven Central — a version can never be re-published.

2. Commit and tag:

        git tag -a 2.14.0 -m "signer-client 2.14.0"
        git push origin master --tags

3. Build, sign, and pack the bundle:

        gradle clean centralBundle

   This produces `build/central/signer-client-<version>-bundle.zip` containing the
   jar, sources jar, javadoc jar, POM, and a `.asc` signature plus checksums for each.

4. Upload the bundle:

        curl --request POST \
          --header "Authorization: Bearer <base64 of user:token>" \
          --form bundle=@build/central/signer-client-2.14.0-bundle.zip \
          https://central.sonatype.com/api/v1/publisher/upload

5. Open the Portal's Deployments view, confirm validation passed, then click
   **Publish**. It takes a few minutes to appear in the Central index and up to a
   couple of hours to reach `repo1.maven.org`.

Verifying
---------

There is no test suite in this repository. Before releasing, at minimum confirm the
sources compile and the jar is well formed:

    gradle clean build

Note that `src/main/java/com/lacunasoftware/signer/**` is largely generated — see
`Generate-ApiCode.ps1`, which reads the production spec at
`https://www.dropsigner.com/swagger/api/swagger.json`. Files under
`javaclient/` are hand-written and are not regenerated.
