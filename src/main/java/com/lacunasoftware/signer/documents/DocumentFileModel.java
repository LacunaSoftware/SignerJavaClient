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

package com.lacunasoftware.signer.documents;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
/**
 * DocumentFileModel
 */


public class DocumentFileModel {
  @JsonProperty("id")
	@SerializedName("id")
  private UUID id = null;

  @JsonProperty("name")
	@SerializedName("name")
  private String name = null;

  @JsonProperty("isSigned")
	@SerializedName("isSigned")
  private Boolean isSigned = null;

  @JsonProperty("isEnvelopePart")
	@SerializedName("isEnvelopePart")
  private Boolean isEnvelopePart = null;

  @JsonProperty("envelopeStartPage")
	@SerializedName("envelopeStartPage")
  private Integer envelopeStartPage = null;

  @JsonProperty("numberPages")
	@SerializedName("numberPages")
  private Integer numberPages = null;

  @JsonProperty("mimeType")
	@SerializedName("mimeType")
  private String mimeType = null;

  @JsonProperty("filename")
	@SerializedName("filename")
  private String filename = null;

  @JsonProperty("creationDate")
	@SerializedName("creationDate")
  private OffsetDateTime creationDate = null;

  public DocumentFileModel id(UUID id) {
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

  public DocumentFileModel name(String name) {
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

  public DocumentFileModel isSigned(Boolean isSigned) {
    this.isSigned = isSigned;
    return this;
  }

   /**
   * Get isSigned
   * @return isSigned
  **/
  @Schema(description = "")
  public Boolean isIsSigned() {
    return isSigned;
  }

  public void setIsSigned(Boolean isSigned) {
    this.isSigned = isSigned;
  }

  public DocumentFileModel isEnvelopePart(Boolean isEnvelopePart) {
    this.isEnvelopePart = isEnvelopePart;
    return this;
  }

   /**
   * Get isEnvelopePart
   * @return isEnvelopePart
  **/
  @Schema(description = "")
  public Boolean isIsEnvelopePart() {
    return isEnvelopePart;
  }

  public void setIsEnvelopePart(Boolean isEnvelopePart) {
    this.isEnvelopePart = isEnvelopePart;
  }

  public DocumentFileModel envelopeStartPage(Integer envelopeStartPage) {
    this.envelopeStartPage = envelopeStartPage;
    return this;
  }

   /**
   * Get envelopeStartPage
   * @return envelopeStartPage
  **/
  @Schema(description = "")
  public Integer getEnvelopeStartPage() {
    return envelopeStartPage;
  }

  public void setEnvelopeStartPage(Integer envelopeStartPage) {
    this.envelopeStartPage = envelopeStartPage;
  }

  public DocumentFileModel numberPages(Integer numberPages) {
    this.numberPages = numberPages;
    return this;
  }

   /**
   * Get numberPages
   * @return numberPages
  **/
  @Schema(description = "")
  public Integer getNumberPages() {
    return numberPages;
  }

  public void setNumberPages(Integer numberPages) {
    this.numberPages = numberPages;
  }

  public DocumentFileModel mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

   /**
   * Get mimeType
   * @return mimeType
  **/
  @Schema(description = "")
  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public DocumentFileModel filename(String filename) {
    this.filename = filename;
    return this;
  }

   /**
   * Get filename
   * @return filename
  **/
  @Schema(description = "")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public DocumentFileModel creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @Schema(description = "")
  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFileModel documentsDocumentFileModel = (DocumentFileModel) o;
    return Objects.equals(this.id, documentsDocumentFileModel.id) &&
        Objects.equals(this.name, documentsDocumentFileModel.name) &&
        Objects.equals(this.isSigned, documentsDocumentFileModel.isSigned) &&
        Objects.equals(this.isEnvelopePart, documentsDocumentFileModel.isEnvelopePart) &&
        Objects.equals(this.envelopeStartPage, documentsDocumentFileModel.envelopeStartPage) &&
        Objects.equals(this.numberPages, documentsDocumentFileModel.numberPages) &&
        Objects.equals(this.mimeType, documentsDocumentFileModel.mimeType) &&
        Objects.equals(this.filename, documentsDocumentFileModel.filename) &&
        Objects.equals(this.creationDate, documentsDocumentFileModel.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, isSigned, isEnvelopePart, envelopeStartPage, numberPages, mimeType, filename, creationDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFileModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isSigned: ").append(toIndentedString(isSigned)).append("\n");
    sb.append("    isEnvelopePart: ").append(toIndentedString(isEnvelopePart)).append("\n");
    sb.append("    envelopeStartPage: ").append(toIndentedString(envelopeStartPage)).append("\n");
    sb.append("    numberPages: ").append(toIndentedString(numberPages)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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
