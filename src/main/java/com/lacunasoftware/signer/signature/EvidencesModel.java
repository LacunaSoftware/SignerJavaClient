/*
 * Dropsigner (HML)
 * <!--------------------------------------------------------------------------------------------------------------------->    <h2>Authentication</h2>    <p>   In order to call this APIs, you will need an <strong>API key</strong>. Set the API key in the header <span class=\"code\">X-Api-Key</span>:  </p>    <pre>X-Api-Key: your-app|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</pre>    <!--------------------------------------------------------------------------------------------------------------------->  <br />    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response is as defined in <a href=\"#model-ErrorModel\">ErrorModel</a></td>    </tr>   </tbody>  </table>    <br />    <h3>Error Codes</h3>    <p>Some of the error codes returned in a 422 response are provided bellow*:</p>    <ul>   <li>CertificateNotFound</li>   <li>DocumentNotFound</li>   <li>FolderNotFound</li>   <li>CpfMismatch</li>   <li>CpfNotExpected</li>   <li>InvalidFlowAction</li>   <li>DocumentInvalidKey</li>  </ul>    <p style=\"font-size: 0.9em\">   *The codes shown above are the main error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <!--------------------------------------------------------------------------------------------------------------------->    <br />    <h2>Webhooks</h2>    <p>   It is recomended to subscribe to Webhook events <strong>instead</strong> of polling APIs. To do so, enable webhooks and register an URL that will receive a POST request   whenever one of the events bellow occur.  </p>  <p>   All requests have the format described in <a href=\"#model-Webhooks.WebhookModel\">Webhooks.WebhookModel</a>.   The data field varies according to the webhook event type:  </p>      <table>   <thead>    <tr>     <th>Event type</th>     <th>Description</th>     <th>Payload</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">DocumentSigned</strong></td>     <td>Triggered when a document is signed.</td>     <td><a href=\"#model-Webhooks.DocumentSignedModel\">Webhooks.DocumentSignedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentApproved</strong></td>     <td>Triggered when a document is approved.</td>     <td><a href=\"#model-Webhooks.DocumentApprovedModel\">Webhooks.DocumentApprovedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentRefused</strong></td>     <td>Triggered when a document is refused.</td>     <td><a href=\"#model-Webhooks.DocumentRefusedModel\">Webhooks.DocumentRefusedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentConcluded</strong></td>     <td>Triggered when the flow of a document is concluded.</td>     <td><a href=\"#model-Webhooks.DocumentConcludedModel\">Webhooks.DocumentConcludedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentCanceled</strong></td>     <td>Triggered when the document is canceled.</td>     <td><a href=\"#model-Webhooks.DocumentCanceledModel\">Webhooks.DocumentCanceledModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentsCreated (v1.50.0)</strong></td>     <td>Triggered when one or more documents are created.</td>     <td><a href=\"#model-Webhooks.DocumentsCreatedModel\">Webhooks.DocumentsCreatedModel</a></td>    </tr>   </tbody>  </table>    <p>   To register your application URL and enable Webhooks, access the integrations section in your <a href=\"/private/organizations\" target=\"_blank\">organization's details page</a>.  </p>  
 *
 * OpenAPI spec version: 1.55.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.lacunasoftware.signer.signature;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lacunasoftware.signer.applications.ApplicationDisplayModel;
import com.lacunasoftware.signer.AuthenticationTypes;
import com.lacunasoftware.signer.signature.GeolocationModel;
import com.lacunasoftware.signer.signature.PixAuthenticationModel;
import com.lacunasoftware.signer.signature.SelfieModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * EvidencesModel
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-03-15T15:24:02.025-03:00[America/Sao_Paulo]")
public class EvidencesModel {
  @JsonProperty("ipAddress")
  private String ipAddress = null;

  @JsonProperty("authenticationTypes")
  private List<AuthenticationTypes> authenticationTypes = null;

  @JsonProperty("accountVerifiedEmail")
  private String accountVerifiedEmail = null;

  @JsonProperty("authenticatedEmail")
  private String authenticatedEmail = null;

  @JsonProperty("authenticatedPhoneNumberLastDigits")
  private String authenticatedPhoneNumberLastDigits = null;

  @JsonProperty("authenticatedApplication")
  private ApplicationDisplayModel authenticatedApplication = null;

  @JsonProperty("authenticatedSelfie")
  private SelfieModel authenticatedSelfie = null;

  @JsonProperty("authenticatedPix")
  private PixAuthenticationModel authenticatedPix = null;

  @JsonProperty("geolocation")
  private GeolocationModel geolocation = null;

  @JsonProperty("timestamp")
  private OffsetDateTime timestamp = null;

  @JsonProperty("evidencesSha256")
  private String evidencesSha256 = null;

  @JsonProperty("authenticatedPhoneNumber")
  private String authenticatedPhoneNumber = null;

  @JsonProperty("file")
  private byte[] file = null;

  @JsonProperty("fileTicket")
  private String fileTicket = null;

  public EvidencesModel ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * Get ipAddress
   * @return ipAddress
  **/
  @Schema(description = "")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public EvidencesModel authenticationTypes(List<AuthenticationTypes> authenticationTypes) {
    this.authenticationTypes = authenticationTypes;
    return this;
  }

  public EvidencesModel addAuthenticationTypesItem(AuthenticationTypes authenticationTypesItem) {
    if (this.authenticationTypes == null) {
      this.authenticationTypes = new ArrayList<AuthenticationTypes>();
    }
    this.authenticationTypes.add(authenticationTypesItem);
    return this;
  }

   /**
   * A list containing the the authentication types used when signing the document.
   * @return authenticationTypes
  **/
  @Schema(description = "A list containing the the authentication types used when signing the document.")
  public List<AuthenticationTypes> getAuthenticationTypes() {
    return authenticationTypes;
  }

  public void setAuthenticationTypes(List<AuthenticationTypes> authenticationTypes) {
    this.authenticationTypes = authenticationTypes;
  }

  public EvidencesModel accountVerifiedEmail(String accountVerifiedEmail) {
    this.accountVerifiedEmail = accountVerifiedEmail;
    return this;
  }

   /**
   * If the user was logged-in when he signed the document this is the verified email of his account.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn&#x27;t contains Lacuna.Signer.Api.AuthenticationTypes.Login this will be null.
   * @return accountVerifiedEmail
  **/
  @Schema(description = "If the user was logged-in when he signed the document this is the verified email of his account.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn't contains Lacuna.Signer.Api.AuthenticationTypes.Login this will be null.")
  public String getAccountVerifiedEmail() {
    return accountVerifiedEmail;
  }

  public void setAccountVerifiedEmail(String accountVerifiedEmail) {
    this.accountVerifiedEmail = accountVerifiedEmail;
  }

  public EvidencesModel authenticatedEmail(String authenticatedEmail) {
    this.authenticatedEmail = authenticatedEmail;
    return this;
  }

   /**
   * The email to which the notification to sign the document was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn&#x27;t contains Lacuna.Signer.Api.AuthenticationTypes.Email this will be null.
   * @return authenticatedEmail
  **/
  @Schema(description = "The email to which the notification to sign the document was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn't contains Lacuna.Signer.Api.AuthenticationTypes.Email this will be null.")
  public String getAuthenticatedEmail() {
    return authenticatedEmail;
  }

  public void setAuthenticatedEmail(String authenticatedEmail) {
    this.authenticatedEmail = authenticatedEmail;
  }

  public EvidencesModel authenticatedPhoneNumberLastDigits(String authenticatedPhoneNumberLastDigits) {
    this.authenticatedPhoneNumberLastDigits = authenticatedPhoneNumberLastDigits;
    return this;
  }

   /**
   * The last four digits of the phone number to which the SMS confirmation code was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn&#x27;t contains Lacuna.Signer.Api.AuthenticationTypes.SMS this will be null.
   * @return authenticatedPhoneNumberLastDigits
  **/
  @Schema(description = "The last four digits of the phone number to which the SMS confirmation code was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn't contains Lacuna.Signer.Api.AuthenticationTypes.SMS this will be null.")
  public String getAuthenticatedPhoneNumberLastDigits() {
    return authenticatedPhoneNumberLastDigits;
  }

  public void setAuthenticatedPhoneNumberLastDigits(String authenticatedPhoneNumberLastDigits) {
    this.authenticatedPhoneNumberLastDigits = authenticatedPhoneNumberLastDigits;
  }

  public EvidencesModel authenticatedApplication(ApplicationDisplayModel authenticatedApplication) {
    this.authenticatedApplication = authenticatedApplication;
    return this;
  }

   /**
   * Get authenticatedApplication
   * @return authenticatedApplication
  **/
  @Schema(description = "")
  public ApplicationDisplayModel getAuthenticatedApplication() {
    return authenticatedApplication;
  }

  public void setAuthenticatedApplication(ApplicationDisplayModel authenticatedApplication) {
    this.authenticatedApplication = authenticatedApplication;
  }

  public EvidencesModel authenticatedSelfie(SelfieModel authenticatedSelfie) {
    this.authenticatedSelfie = authenticatedSelfie;
    return this;
  }

   /**
   * Get authenticatedSelfie
   * @return authenticatedSelfie
  **/
  @Schema(description = "")
  public SelfieModel getAuthenticatedSelfie() {
    return authenticatedSelfie;
  }

  public void setAuthenticatedSelfie(SelfieModel authenticatedSelfie) {
    this.authenticatedSelfie = authenticatedSelfie;
  }

  public EvidencesModel authenticatedPix(PixAuthenticationModel authenticatedPix) {
    this.authenticatedPix = authenticatedPix;
    return this;
  }

   /**
   * Get authenticatedPix
   * @return authenticatedPix
  **/
  @Schema(description = "")
  public PixAuthenticationModel getAuthenticatedPix() {
    return authenticatedPix;
  }

  public void setAuthenticatedPix(PixAuthenticationModel authenticatedPix) {
    this.authenticatedPix = authenticatedPix;
  }

  public EvidencesModel geolocation(GeolocationModel geolocation) {
    this.geolocation = geolocation;
    return this;
  }

   /**
   * Get geolocation
   * @return geolocation
  **/
  @Schema(description = "")
  public GeolocationModel getGeolocation() {
    return geolocation;
  }

  public void setGeolocation(GeolocationModel geolocation) {
    this.geolocation = geolocation;
  }

  public EvidencesModel timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @Schema(description = "")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public EvidencesModel evidencesSha256(String evidencesSha256) {
    this.evidencesSha256 = evidencesSha256;
    return this;
  }

   /**
   * SHA-256 Hash (Base64 encoded) of the evidences JSON file
   * @return evidencesSha256
  **/
  @Schema(description = "SHA-256 Hash (Base64 encoded) of the evidences JSON file")
  public String getEvidencesSha256() {
    return evidencesSha256;
  }

  public void setEvidencesSha256(String evidencesSha256) {
    this.evidencesSha256 = evidencesSha256;
  }

  public EvidencesModel authenticatedPhoneNumber(String authenticatedPhoneNumber) {
    this.authenticatedPhoneNumber = authenticatedPhoneNumber;
    return this;
  }

   /**
   * The phone number to which the SMS confirmation code was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn&#x27;t contains Lacuna.Signer.Api.AuthenticationTypes.SMS this will be null.
   * @return authenticatedPhoneNumber
  **/
  @Schema(description = "The phone number to which the SMS confirmation code was sent.  If Lacuna.Signer.Api.Signature.EvidencesModel.AuthenticationTypes doesn't contains Lacuna.Signer.Api.AuthenticationTypes.SMS this will be null.")
  public String getAuthenticatedPhoneNumber() {
    return authenticatedPhoneNumber;
  }

  public void setAuthenticatedPhoneNumber(String authenticatedPhoneNumber) {
    this.authenticatedPhoneNumber = authenticatedPhoneNumber;
  }

  public EvidencesModel file(byte[] file) {
    this.file = file;
    return this;
  }

   /**
   * The evidences JSON file in bytes.
   * @return file
  **/
  @Schema(description = "The evidences JSON file in bytes.")
  public byte[] getFile() {
    return file;
  }

  public void setFile(byte[] file) {
    this.file = file;
  }

  public EvidencesModel fileTicket(String fileTicket) {
    this.fileTicket = fileTicket;
    return this;
  }

   /**
   * Ticket to download the evidences JSON file.
   * @return fileTicket
  **/
  @Schema(description = "Ticket to download the evidences JSON file.")
  public String getFileTicket() {
    return fileTicket;
  }

  public void setFileTicket(String fileTicket) {
    this.fileTicket = fileTicket;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvidencesModel signatureEvidencesModel = (EvidencesModel) o;
    return Objects.equals(this.ipAddress, signatureEvidencesModel.ipAddress) &&
        Objects.equals(this.authenticationTypes, signatureEvidencesModel.authenticationTypes) &&
        Objects.equals(this.accountVerifiedEmail, signatureEvidencesModel.accountVerifiedEmail) &&
        Objects.equals(this.authenticatedEmail, signatureEvidencesModel.authenticatedEmail) &&
        Objects.equals(this.authenticatedPhoneNumberLastDigits, signatureEvidencesModel.authenticatedPhoneNumberLastDigits) &&
        Objects.equals(this.authenticatedApplication, signatureEvidencesModel.authenticatedApplication) &&
        Objects.equals(this.authenticatedSelfie, signatureEvidencesModel.authenticatedSelfie) &&
        Objects.equals(this.authenticatedPix, signatureEvidencesModel.authenticatedPix) &&
        Objects.equals(this.geolocation, signatureEvidencesModel.geolocation) &&
        Objects.equals(this.timestamp, signatureEvidencesModel.timestamp) &&
        Objects.equals(this.evidencesSha256, signatureEvidencesModel.evidencesSha256) &&
        Objects.equals(this.authenticatedPhoneNumber, signatureEvidencesModel.authenticatedPhoneNumber) &&
        Arrays.equals(this.file, signatureEvidencesModel.file) &&
        Objects.equals(this.fileTicket, signatureEvidencesModel.fileTicket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddress, authenticationTypes, accountVerifiedEmail, authenticatedEmail, authenticatedPhoneNumberLastDigits, authenticatedApplication, authenticatedSelfie, authenticatedPix, geolocation, timestamp, evidencesSha256, authenticatedPhoneNumber, Arrays.hashCode(file), fileTicket);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvidencesModel {\n");
    
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    authenticationTypes: ").append(toIndentedString(authenticationTypes)).append("\n");
    sb.append("    accountVerifiedEmail: ").append(toIndentedString(accountVerifiedEmail)).append("\n");
    sb.append("    authenticatedEmail: ").append(toIndentedString(authenticatedEmail)).append("\n");
    sb.append("    authenticatedPhoneNumberLastDigits: ").append(toIndentedString(authenticatedPhoneNumberLastDigits)).append("\n");
    sb.append("    authenticatedApplication: ").append(toIndentedString(authenticatedApplication)).append("\n");
    sb.append("    authenticatedSelfie: ").append(toIndentedString(authenticatedSelfie)).append("\n");
    sb.append("    authenticatedPix: ").append(toIndentedString(authenticatedPix)).append("\n");
    sb.append("    geolocation: ").append(toIndentedString(geolocation)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    evidencesSha256: ").append(toIndentedString(evidencesSha256)).append("\n");
    sb.append("    authenticatedPhoneNumber: ").append(toIndentedString(authenticatedPhoneNumber)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    fileTicket: ").append(toIndentedString(fileTicket)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
