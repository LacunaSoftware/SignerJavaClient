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

package com.lacunasoftware.signer.flowactions;

import java.util.Objects;
import java.util.UUID;

import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * SignRuleUserModel
 */


public class SignRuleUserModel {
  @JsonProperty("id")
	@SerializedName("id")
  private UUID id = null;

  @JsonProperty("name")
	@SerializedName("name")
  private String name = null;

  @JsonProperty("identifier")
	@SerializedName("identifier")
  private String identifier = null;

  @JsonProperty("email")
	@SerializedName("email")
  private String email = null;

  @JsonProperty("phone")
	@SerializedName("phone")
  private String phone = null;

  @JsonProperty("signatureDate")
	@SerializedName("signatureDate")
  private OffsetDateTime signatureDate = null;

  @JsonProperty("isElectronic")
	@SerializedName("isElectronic")
  private Boolean isElectronic = null;

  @JsonProperty("refusalDate")
	@SerializedName("refusalDate")
  private OffsetDateTime refusalDate = null;

  @JsonProperty("hasRefused")
	@SerializedName("hasRefused")
  private Boolean hasRefused = null;

  @JsonProperty("refusalReason")
	@SerializedName("refusalReason")
  private String refusalReason = null;

  public SignRuleUserModel id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SignRuleUserModel name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SignRuleUserModel identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * The user identifier (CPF in Brazil or Cédula de Identidad in Ecuador).
   * @return identifier
  **/
  @Schema(description = "The user identifier (CPF in Brazil or Cédula de Identidad in Ecuador).")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public SignRuleUserModel email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @Schema(description = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SignRuleUserModel phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @Schema(description = "")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public SignRuleUserModel signatureDate(OffsetDateTime signatureDate) {
    this.signatureDate = signatureDate;
    return this;
  }

   /**
   * Get signatureDate
   * @return signatureDate
  **/
  @Schema(description = "")
  public OffsetDateTime getSignatureDate() {
    return signatureDate;
  }

  public void setSignatureDate(OffsetDateTime signatureDate) {
    this.signatureDate = signatureDate;
  }

  public SignRuleUserModel isElectronic(Boolean isElectronic) {
    this.isElectronic = isElectronic;
    return this;
  }

   /**
   * Get isElectronic
   * @return isElectronic
  **/
  @Schema(description = "")
  public Boolean isIsElectronic() {
    return isElectronic;
  }

  public void setIsElectronic(Boolean isElectronic) {
    this.isElectronic = isElectronic;
  }

  public SignRuleUserModel refusalDate(OffsetDateTime refusalDate) {
    this.refusalDate = refusalDate;
    return this;
  }

   /**
   * Get refusalDate
   * @return refusalDate
  **/
  @Schema(description = "")
  public OffsetDateTime getRefusalDate() {
    return refusalDate;
  }

  public void setRefusalDate(OffsetDateTime refusalDate) {
    this.refusalDate = refusalDate;
  }

  public SignRuleUserModel hasRefused(Boolean hasRefused) {
    this.hasRefused = hasRefused;
    return this;
  }

   /**
   * Get hasRefused
   * @return hasRefused
  **/
  @Schema(description = "")
  public Boolean isHasRefused() {
    return hasRefused;
  }

  public void setHasRefused(Boolean hasRefused) {
    this.hasRefused = hasRefused;
  }

  public SignRuleUserModel refusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
    return this;
  }

   /**
   * Get refusalReason
   * @return refusalReason
  **/
  @Schema(description = "")
  public String getRefusalReason() {
    return refusalReason;
  }

  public void setRefusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignRuleUserModel flowActionsSignRuleUserModel = (SignRuleUserModel) o;
    return Objects.equals(this.id, flowActionsSignRuleUserModel.id) &&
        Objects.equals(this.name, flowActionsSignRuleUserModel.name) &&
        Objects.equals(this.identifier, flowActionsSignRuleUserModel.identifier) &&
        Objects.equals(this.email, flowActionsSignRuleUserModel.email) &&
        Objects.equals(this.phone, flowActionsSignRuleUserModel.phone) &&
        Objects.equals(this.signatureDate, flowActionsSignRuleUserModel.signatureDate) &&
        Objects.equals(this.isElectronic, flowActionsSignRuleUserModel.isElectronic) &&
        Objects.equals(this.refusalDate, flowActionsSignRuleUserModel.refusalDate) &&
        Objects.equals(this.hasRefused, flowActionsSignRuleUserModel.hasRefused) &&
        Objects.equals(this.refusalReason, flowActionsSignRuleUserModel.refusalReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, identifier, email, phone, signatureDate, isElectronic, refusalDate, hasRefused, refusalReason);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignRuleUserModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    signatureDate: ").append(toIndentedString(signatureDate)).append("\n");
    sb.append("    isElectronic: ").append(toIndentedString(isElectronic)).append("\n");
    sb.append("    refusalDate: ").append(toIndentedString(refusalDate)).append("\n");
    sb.append("    hasRefused: ").append(toIndentedString(hasRefused)).append("\n");
    sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
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
