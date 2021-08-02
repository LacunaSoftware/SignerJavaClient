/*
 * Dropsigner (HML)
 * <!--------------------------------------------------------------------------------------------------------------------->    <h2>Authentication</h2>    <p>   In order to call this APIs, you will need an <strong>API key</strong>. Set the API key in the header <span class=\"code\">X-Api-Key</span>:  </p>    <pre>X-Api-Key: your-app|xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</pre>    <!--------------------------------------------------------------------------------------------------------------------->  <br />    <h2>HTTP Codes</h2>    <p>   The APIs will return the following HTTP codes:  </p>    <table>   <thead>    <tr>     <th>Code</th>     <th>Description</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">200 (OK)</strong></td>     <td>Request processed successfully. The response is different for each API, please refer to the operation's documentation</td>    </tr>    <tr>     <td><strong class=\"model-title\">400 (Bad Request)</strong></td>     <td>Syntax error. For instance, when a required field was not provided</td>    </tr>    <tr>     <td><strong class=\"model-title\">401 (Unauthorized)</strong></td>     <td>API key not provided or invalid</td>    </tr>    <tr>     <td><strong class=\"model-title\">403 (Forbidden)</strong></td>     <td>API key is valid, but the application has insufficient permissions to complete the requested operation</td>    </tr>    <tr>     <td><strong class=\"model-title\">422 (Unprocessable Entity)</strong></td>     <td>API error. The response is as defined in <a href=\"#model-ErrorModel\">ErrorModel</a></td>    </tr>   </tbody>  </table>    <br />    <h3>Error Codes</h3>    <p>Some of the error codes returned in a 422 response are provided bellow*:</p>    <ul>   <li>CertificateNotFound</li>   <li>DocumentNotFound</li>   <li>FolderNotFound</li>   <li>CpfMismatch</li>   <li>CpfNotExpected</li>   <li>InvalidFlowAction</li>   <li>DocumentInvalidKey</li>  </ul>    <p style=\"font-size: 0.9em\">   *The codes shown above are the main error codes. Nonetheless, this list is not comprehensive. New codes may be added anytime without previous warning.  </p>    <!--------------------------------------------------------------------------------------------------------------------->    <br />    <h2>Webhooks</h2>    <p>   It is recomended to subscribe to Webhook events <strong>instead</strong> of polling APIs. To do so, enable webhooks and register an URL that will receive a POST request   whenever one of the events bellow occur.  </p>  <p>   All requests have the format described in <a href=\"#model-Webhooks.WebhookModel\">Webhooks.WebhookModel</a>.   The data field varies according to the webhook event type:  </p>      <table>   <thead>    <tr>     <th>Event type</th>     <th>Description</th>     <th>Payload</th>    </tr>   </thead>   <tbody>    <tr>     <td><strong class=\"model-title\">DocumentSigned</strong></td>     <td>Triggered when a document is signed.</td>     <td><a href=\"#model-Webhooks.DocumentSignedModel\">Webhooks.DocumentSignedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentApproved</strong></td>     <td>Triggered when a document is approved.</td>     <td><a href=\"#model-Webhooks.DocumentApprovedModel\">Webhooks.DocumentApprovedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentRefused</strong></td>     <td>Triggered when a document is refused.</td>     <td><a href=\"#model-Webhooks.DocumentRefusedModel\">Webhooks.DocumentRefusedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentConcluded</strong></td>     <td>Triggered when the flow of a document is concluded.</td>     <td><a href=\"#model-Webhooks.DocumentConcludedModel\">Webhooks.DocumentConcludedModel</a></td>    </tr>    <tr>     <td><strong class=\"model-title\">DocumentCanceled</strong></td>     <td>Triggered when the document is canceled.</td>     <td><a href=\"#model-Webhooks.DocumentCanceledModel\">Webhooks.DocumentCanceledModel</a></td>    </tr>   </tbody>  </table>    <p>   To register your application URL and enable Webhooks, access the integrations section in your <a href=\"/private/organizations\" target=\"_blank\">organization's details page</a>.  </p>  
 *
 * OpenAPI spec version: 1.33.0
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
import com.lacunasoftware.signer.attachments.AttachmentUploadModel;
import com.lacunasoftware.signer.FileUploadModel;
import com.lacunasoftware.signer.flowactions.FlowActionCreateModel;
import com.lacunasoftware.signer.observers.ObserverCreateModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
/**
 * CreateDocumentRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-29T21:32:02.525811100-03:00[America/Sao_Paulo]")
public class CreateDocumentRequest {
  @JsonProperty("files")
  private List<FileUploadModel> files = new ArrayList<FileUploadModel>();

  @JsonProperty("attachments")
  private List<AttachmentUploadModel> attachments = null;

  @JsonProperty("isEnvelope")
  private Boolean isEnvelope = null;

  @JsonProperty("envelopeName")
  private String envelopeName = null;

  @JsonProperty("folderId")
  private UUID folderId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("flowActions")
  private List<FlowActionCreateModel> flowActions = new ArrayList<FlowActionCreateModel>();

  @JsonProperty("observers")
  private List<ObserverCreateModel> observers = null;

  @JsonProperty("disablePendingActionNotifications")
  private Boolean disablePendingActionNotifications = null;

  @JsonProperty("newFolderName")
  private String newFolderName = null;

  @JsonProperty("forceCadesSignature")
  private Boolean forceCadesSignature = null;

  @JsonProperty("notifiedEmails")
  private List<String> notifiedEmails = null;

  @JsonProperty("expirationDate")
  private OffsetDateTime expirationDate = null;

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

  public CreateDocumentRequest attachments(List<AttachmentUploadModel> attachments) {
    this.attachments = attachments;
    return this;
  }

  public CreateDocumentRequest addAttachmentsItem(AttachmentUploadModel attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<AttachmentUploadModel>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

   /**
   * The attachments to submit. Each document will have the same attachments.
   * @return attachments
  **/
  @Schema(description = "The attachments to submit. Each document will have the same attachments.")
  public List<AttachmentUploadModel> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<AttachmentUploadModel> attachments) {
    this.attachments = attachments;
  }

  public CreateDocumentRequest isEnvelope(Boolean isEnvelope) {
    this.isEnvelope = isEnvelope;
    return this;
  }

   /**
   * If true, groups all files into a single document (the envelope). All files must be in PDF format.
   * @return isEnvelope
  **/
  @Schema(description = "If true, groups all files into a single document (the envelope). All files must be in PDF format.")
  public Boolean isIsEnvelope() {
    return isEnvelope;
  }

  public void setIsEnvelope(Boolean isEnvelope) {
    this.isEnvelope = isEnvelope;
  }

  public CreateDocumentRequest envelopeName(String envelopeName) {
    this.envelopeName = envelopeName;
    return this;
  }

   /**
   * The name of the document if the envelope option is enabled (see \&quot;IsEnvelope\&quot; property).
   * @return envelopeName
  **/
  @Schema(description = "The name of the document if the envelope option is enabled (see \"IsEnvelope\" property).")
  public String getEnvelopeName() {
    return envelopeName;
  }

  public void setEnvelopeName(String envelopeName) {
    this.envelopeName = envelopeName;
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

  public CreateDocumentRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description to be added to the document(s). This will be presented to all participants in the document details screen and   in pending action notifications.
   * @return description
  **/
  @Schema(description = "A description to be added to the document(s). This will be presented to all participants in the document details screen and   in pending action notifications.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public CreateDocumentRequest notifiedEmails(List<String> notifiedEmails) {
    this.notifiedEmails = notifiedEmails;
    return this;
  }

  public CreateDocumentRequest addNotifiedEmailsItem(String notifiedEmailsItem) {
    if (this.notifiedEmails == null) {
      this.notifiedEmails = new ArrayList<String>();
    }
    this.notifiedEmails.add(notifiedEmailsItem);
    return this;
  }

   /**
   * The emails to notify when the document is concluded.
   * @return notifiedEmails
  **/
  @Schema(description = "The emails to notify when the document is concluded.")
  public List<String> getNotifiedEmails() {
    return notifiedEmails;
  }

  public void setNotifiedEmails(List<String> notifiedEmails) {
    this.notifiedEmails = notifiedEmails;
  }

  public CreateDocumentRequest expirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

   /**
   * The expiration date of the document. Any time information will be discarded, as the expiration will be set   to the last time available for the chosen date in the default timezone.
   * @return expirationDate
  **/
  @Schema(description = "The expiration date of the document. Any time information will be discarded, as the expiration will be set   to the last time available for the chosen date in the default timezone.")
  public OffsetDateTime getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
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
        Objects.equals(this.attachments, documentsCreateDocumentRequest.attachments) &&
        Objects.equals(this.isEnvelope, documentsCreateDocumentRequest.isEnvelope) &&
        Objects.equals(this.envelopeName, documentsCreateDocumentRequest.envelopeName) &&
        Objects.equals(this.folderId, documentsCreateDocumentRequest.folderId) &&
        Objects.equals(this.description, documentsCreateDocumentRequest.description) &&
        Objects.equals(this.flowActions, documentsCreateDocumentRequest.flowActions) &&
        Objects.equals(this.observers, documentsCreateDocumentRequest.observers) &&
        Objects.equals(this.disablePendingActionNotifications, documentsCreateDocumentRequest.disablePendingActionNotifications) &&
        Objects.equals(this.newFolderName, documentsCreateDocumentRequest.newFolderName) &&
        Objects.equals(this.forceCadesSignature, documentsCreateDocumentRequest.forceCadesSignature) &&
        Objects.equals(this.notifiedEmails, documentsCreateDocumentRequest.notifiedEmails) &&
        Objects.equals(this.expirationDate, documentsCreateDocumentRequest.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(files, attachments, isEnvelope, envelopeName, folderId, description, flowActions, observers, disablePendingActionNotifications, newFolderName, forceCadesSignature, notifiedEmails, expirationDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDocumentRequest {\n");
    
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    isEnvelope: ").append(toIndentedString(isEnvelope)).append("\n");
    sb.append("    envelopeName: ").append(toIndentedString(envelopeName)).append("\n");
    sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    flowActions: ").append(toIndentedString(flowActions)).append("\n");
    sb.append("    observers: ").append(toIndentedString(observers)).append("\n");
    sb.append("    disablePendingActionNotifications: ").append(toIndentedString(disablePendingActionNotifications)).append("\n");
    sb.append("    newFolderName: ").append(toIndentedString(newFolderName)).append("\n");
    sb.append("    forceCadesSignature: ").append(toIndentedString(forceCadesSignature)).append("\n");
    sb.append("    notifiedEmails: ").append(toIndentedString(notifiedEmails)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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
