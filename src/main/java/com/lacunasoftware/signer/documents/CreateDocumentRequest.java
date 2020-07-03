/*
 * Dropsigner (HML)
 * <!--------------------------------------------------------------------------------------------------------------------->    <h2>Authentication</h2>    <p>   In order to call this APIs, you will need an <strong>API key</strong>. Set the API key in the header <span class=\"code\">X-Api-Key</span>:  </p>    <pre>X-Api-Key: your-app|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</pre>    <!--------------------------------------------------------------------------------------------------------------------->  <br />    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response is as defined in <a href=\"#model-ErrorModel\">ErrorModel</a></td>    </tr>   </tbody>  </table>    <br />    <h3>Error Codes</h3>    <p>Some of the error codes returned in a 422 response are provided bellow*:</p>    <ul>   <li>CertificateNotFound</li>   <li>DocumentNotFound</li>   <li>FolderNotFound</li>   <li>CpfMismatch</li>   <li>CpfNotExpected</li>   <li>InvalidFlowAction</li>   <li>DocumentInvalidKey</li>  </ul>    <p style=\"font-size: 0.9em\">   *The codes shown above are the main error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <!--------------------------------------------------------------------------------------------------------------------->    <br />    <h2>Webhooks</h2>    <p>   It is recomended to subscribe to Webhook events <strong>instead</strong> of polling APIs. To do so, enable webhooks and register an URL that will receive a POST request   whenever one of the events bellow occur.  </p>  <p>   All requests have the format described in <a href=\"#model-Webhooks.WebhookModel\">Webhooks.WebhookModel</a>.   The data field varies according to the webhook event type:  </p>      <table>   <thead>    <tr>     <th>Event type</th>     <th>Description</th>     <th>Payload</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">DocumentConcluded</strong></td>     <td>Triggered when the flow of a document is concluded.</td>     <td><a href=\"#model-Webhooks.DocumentConcludedModel\">Webhooks.DocumentConcludedModel</a></td>    </tr>   </tbody>  </table>    <p>   To register your application URL and enable Webhooks, access the integrations section in your <a href=\"/private/organizations\" target=\"_blank\">organization's details page</a>.  </p>  
 *
 * OpenAPI spec version: 1.7.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.lacunasoftware.signer.documents;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.lacunasoftware.signer.FileUploadModel;
import com.lacunasoftware.signer.flowactions.FlowActionCreateModel;
import com.lacunasoftware.signer.observers.ObserverCreateModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * CreateDocumentRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-07-03T19:34:04.293-03:00[America/Sao_Paulo]")
public class CreateDocumentRequest {
  @SerializedName("files")
  private List<FileUploadModel> files = new ArrayList<FileUploadModel>();

  @SerializedName("folderId")
  private UUID folderId = null;

  @SerializedName("flowActions")
  private List<FlowActionCreateModel> flowActions = new ArrayList<FlowActionCreateModel>();

  @SerializedName("observers")
  private List<ObserverCreateModel> observers = null;

  @SerializedName("disablePendingActionNotifications")
  private Boolean disablePendingActionNotifications = null;

  @SerializedName("newFolderName")
  private String newFolderName = null;

  @SerializedName("forceCadesSignature")
  private Boolean forceCadesSignature = null;

  public CreateDocumentRequest files(List<FileUploadModel> files) {
    this.files = files;
    return this;
  }

  public CreateDocumentRequest addFilesItem(FileUploadModel filesItem) {
    this.files.add(filesItem);
    return this;
  }

   /**
   * The files to submit. Each file will create a document.
   * @return files
  **/
  @Schema(required = true, description = "The files to submit. Each file will create a document.")
  public List<FileUploadModel> getFiles() {
    return files;
  }

  public void setFiles(List<FileUploadModel> files) {
    this.files = files;
  }

  public CreateDocumentRequest folderId(UUID folderId) {
    this.folderId = folderId;
    return this;
  }

   /**
   * The id of the folder in which the document should be placed or null if it should not be placed in any specific folder.
   * @return folderId
  **/
  @Schema(description = "The id of the folder in which the document should be placed or null if it should not be placed in any specific folder.")
  public UUID getFolderId() {
    return folderId;
  }

  public void setFolderId(UUID folderId) {
    this.folderId = folderId;
  }

  public CreateDocumentRequest flowActions(List<FlowActionCreateModel> flowActions) {
    this.flowActions = flowActions;
    return this;
  }

  public CreateDocumentRequest addFlowActionsItem(FlowActionCreateModel flowActionsItem) {
    this.flowActions.add(flowActionsItem);
    return this;
  }

   /**
   * The list of actions (signers and approvers) that will be in the document.
   * @return flowActions
  **/
  @Schema(required = true, description = "The list of actions (signers and approvers) that will be in the document.")
  public List<FlowActionCreateModel> getFlowActions() {
    return flowActions;
  }

  public void setFlowActions(List<FlowActionCreateModel> flowActions) {
    this.flowActions = flowActions;
  }

  public CreateDocumentRequest observers(List<ObserverCreateModel> observers) {
    this.observers = observers;
    return this;
  }

  public CreateDocumentRequest addObserversItem(ObserverCreateModel observersItem) {
    if (this.observers == null) {
      this.observers = new ArrayList<ObserverCreateModel>();
    }
    this.observers.add(observersItem);
    return this;
  }

   /**
   * Get observers
   * @return observers
  **/
  @Schema(description = "")
  public List<ObserverCreateModel> getObservers() {
    return observers;
  }

  public void setObservers(List<ObserverCreateModel> observers) {
    this.observers = observers;
  }

  public CreateDocumentRequest disablePendingActionNotifications(Boolean disablePendingActionNotifications) {
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

  public CreateDocumentRequest newFolderName(String newFolderName) {
    this.newFolderName = newFolderName;
    return this;
  }

   /**
   * The name of a new folder to be created and associated to the document. If you do not wish to create a new folder you may set this as null.
   * @return newFolderName
  **/
  @Schema(description = "The name of a new folder to be created and associated to the document. If you do not wish to create a new folder you may set this as null.")
  public String getNewFolderName() {
    return newFolderName;
  }

  public void setNewFolderName(String newFolderName) {
    this.newFolderName = newFolderName;
  }

  public CreateDocumentRequest forceCadesSignature(Boolean forceCadesSignature) {
    this.forceCadesSignature = forceCadesSignature;
    return this;
  }

   /**
   * If this property is set to true, then the document will be signed using the CAdES format.
   * @return forceCadesSignature
  **/
  @Schema(description = "If this property is set to true, then the document will be signed using the CAdES format.")
  public Boolean isForceCadesSignature() {
    return forceCadesSignature;
  }

  public void setForceCadesSignature(Boolean forceCadesSignature) {
    this.forceCadesSignature = forceCadesSignature;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDocumentRequest documentsCreateDocumentRequest = (CreateDocumentRequest) o;
    return Objects.equals(this.files, documentsCreateDocumentRequest.files) &&
        Objects.equals(this.folderId, documentsCreateDocumentRequest.folderId) &&
        Objects.equals(this.flowActions, documentsCreateDocumentRequest.flowActions) &&
        Objects.equals(this.observers, documentsCreateDocumentRequest.observers) &&
        Objects.equals(this.disablePendingActionNotifications, documentsCreateDocumentRequest.disablePendingActionNotifications) &&
        Objects.equals(this.newFolderName, documentsCreateDocumentRequest.newFolderName) &&
        Objects.equals(this.forceCadesSignature, documentsCreateDocumentRequest.forceCadesSignature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(files, folderId, flowActions, observers, disablePendingActionNotifications, newFolderName, forceCadesSignature);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDocumentRequest {\n");
    
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    flowActions: ").append(toIndentedString(flowActions)).append("\n");
    sb.append("    observers: ").append(toIndentedString(observers)).append("\n");
    sb.append("    disablePendingActionNotifications: ").append(toIndentedString(disablePendingActionNotifications)).append("\n");
    sb.append("    newFolderName: ").append(toIndentedString(newFolderName)).append("\n");
    sb.append("    forceCadesSignature: ").append(toIndentedString(forceCadesSignature)).append("\n");
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