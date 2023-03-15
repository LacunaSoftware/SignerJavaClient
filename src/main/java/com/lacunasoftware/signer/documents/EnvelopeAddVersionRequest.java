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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lacunasoftware.signer.documents.DocumentAdditionalInfoData;
import com.lacunasoftware.signer.FileUploadModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * EnvelopeAddVersionRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-03-15T15:24:02.025-03:00[America/Sao_Paulo]")
public class EnvelopeAddVersionRequest {
  @JsonProperty("files")
  private List<FileUploadModel> files = null;

  @JsonProperty("envelopeName")
  private String envelopeName = null;

  @JsonProperty("disablePendingActionNotifications")
  private Boolean disablePendingActionNotifications = null;

  @JsonProperty("additionalInfo")
  private DocumentAdditionalInfoData additionalInfo = null;

  public EnvelopeAddVersionRequest files(List<FileUploadModel> files) {
    this.files = files;
    return this;
  }

  public EnvelopeAddVersionRequest addFilesItem(FileUploadModel filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<FileUploadModel>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @Schema(description = "")
  public List<FileUploadModel> getFiles() {
    return files;
  }

  public void setFiles(List<FileUploadModel> files) {
    this.files = files;
  }

  public EnvelopeAddVersionRequest envelopeName(String envelopeName) {
    this.envelopeName = envelopeName;
    return this;
  }

   /**
   * Get envelopeName
   * @return envelopeName
  **/
  @Schema(description = "")
  public String getEnvelopeName() {
    return envelopeName;
  }

  public void setEnvelopeName(String envelopeName) {
    this.envelopeName = envelopeName;
  }

  public EnvelopeAddVersionRequest disablePendingActionNotifications(Boolean disablePendingActionNotifications) {
    this.disablePendingActionNotifications = disablePendingActionNotifications;
    return this;
  }

   /**
   * If true the notifications of pending actions won&#x27;t be sent to the participants of the first step.
   * @return disablePendingActionNotifications
  **/
  @Schema(description = "If true the notifications of pending actions won't be sent to the participants of the first step.")
  public Boolean isDisablePendingActionNotifications() {
    return disablePendingActionNotifications;
  }

  public void setDisablePendingActionNotifications(Boolean disablePendingActionNotifications) {
    this.disablePendingActionNotifications = disablePendingActionNotifications;
  }

  public EnvelopeAddVersionRequest additionalInfo(DocumentAdditionalInfoData additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Get additionalInfo
   * @return additionalInfo
  **/
  @Schema(description = "")
  public DocumentAdditionalInfoData getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(DocumentAdditionalInfoData additionalInfo) {
    this.additionalInfo = additionalInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvelopeAddVersionRequest documentsEnvelopeAddVersionRequest = (EnvelopeAddVersionRequest) o;
    return Objects.equals(this.files, documentsEnvelopeAddVersionRequest.files) &&
        Objects.equals(this.envelopeName, documentsEnvelopeAddVersionRequest.envelopeName) &&
        Objects.equals(this.disablePendingActionNotifications, documentsEnvelopeAddVersionRequest.disablePendingActionNotifications) &&
        Objects.equals(this.additionalInfo, documentsEnvelopeAddVersionRequest.additionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(files, envelopeName, disablePendingActionNotifications, additionalInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvelopeAddVersionRequest {\n");
    
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    envelopeName: ").append(toIndentedString(envelopeName)).append("\n");
    sb.append("    disablePendingActionNotifications: ").append(toIndentedString(disablePendingActionNotifications)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
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
