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

**Signing key.** GnuPG 2.1 and later keep secret keys in a keybox, not the
`secring.gpg` file that `signing.secretKeyRingFile` reads, so there are two options.

Either export a legacy keyring once and use the original properties:

    gpg --export-secret-keys -o secring.gpg <keyid>

    signing.keyId=<last 8 chars of the key id>
    signing.password=<key passphrase>
    signing.secretKeyRingFile=secring.gpg

Or hand Gradle the armoured key directly, which needs no export:

    gpg --armor --export-secret-keys <keyid>

    signingInMemoryKey=-----BEGIN PGP PRIVATE KEY BLOCK-----\n...\n
    signingInMemoryKeyPassword=<key passphrase>

If no key exists yet, `gpg --full-generate-key` creates one; it must then be
published to a public keyserver (`gpg --keyserver keyserver.ubuntu.com --send-keys
<keyid>`) or the Portal cannot verify the signatures.

**Portal token.** Generate one under Account → Generate User Token on
central.sonatype.com. The `Authorization` header value is the base64 of
`<tokenUsername>:<tokenPassword>`.

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

   Check the bundle before uploading — every artifact needs a matching `.asc`:

        unzip -l build/central/signer-client-2.14.0-bundle.zip

4. Upload the bundle. `USER_MANAGED` holds it for review instead of releasing
   immediately, which is what you want for a first run:

        curl --request POST \
          --header "Authorization: Bearer <base64 of tokenUser:tokenPassword>" \
          --form bundle=@build/central/signer-client-2.14.0-bundle.zip \
          "https://central.sonatype.com/api/v1/publisher/upload?publishingType=USER_MANAGED"

   The response body is a deployment id. Validation status:

        curl --request POST \
          --header "Authorization: Bearer <base64 of tokenUser:tokenPassword>" \
          "https://central.sonatype.com/api/v1/publisher/status?id=<deploymentId>"

5. Open the Portal's Deployments view, confirm the state is `VALIDATED`, then click
   **Publish**. It takes a few minutes to appear in the Central index and up to a
   couple of hours to reach `repo1.maven.org`.

   A release is permanent. Nothing about `2.14.0` can be changed or withdrawn after
   this step, so treat the Publish click as the point of no return.

Verifying
---------

There is no test suite in this repository. Before releasing, at minimum confirm the
sources compile and the jar is well formed:

    gradle clean build

Note that `src/main/java/com/lacunasoftware/signer/**` is largely generated — see
`Generate-ApiCode.ps1`, which reads the production spec at
`https://www.dropsigner.com/swagger/api/swagger.json`. Files under
`javaclient/` are hand-written and are not regenerated.
