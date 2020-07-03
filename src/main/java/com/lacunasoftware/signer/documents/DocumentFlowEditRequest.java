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
import com.lacunasoftware.signer.flowactions.FlowActionCreateModel;
import com.lacunasoftware.signer.flowactions.FlowActionEditModel;
import com.lacunasoftware.signer.observers.ObserverCreateModel;
import com.lacunasoftware.signer.observers.ObserverEditModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * DocumentFlowEditRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-07-03T19:34:04.293-03:00[America/Sao_Paulo]")
public class DocumentFlowEditRequest {
  @SerializedName("addedFlowActions")
  private List<FlowActionCreateModel> addedFlowActions = null;

  @SerializedName("editedFlowActions")
  private List<FlowActionEditModel> editedFlowActions = null;

  @SerializedName("deletedFlowActionIds")
  private List<UUID> deletedFlowActionIds = null;

  @SerializedName("addedObservers")
  private List<ObserverCreateModel> addedObservers = null;

  @SerializedName("editedObservers")
  private List<ObserverEditModel> editedObservers = null;

  @SerializedName("deletedObserverIds")
  private List<UUID> deletedObserverIds = null;

  public DocumentFlowEditRequest addedFlowActions(List<FlowActionCreateModel> addedFlowActions) {
    this.addedFlowActions = addedFlowActions;
    return this;
  }

  public DocumentFlowEditRequest addAddedFlowActionsItem(FlowActionCreateModel addedFlowActionsItem) {
    if (this.addedFlowActions == null) {
      this.addedFlowActions = new ArrayList<FlowActionCreateModel>();
    }
    this.addedFlowActions.add(addedFlowActionsItem);
    return this;
  }

   /**
   * The actions to be added to the flow.  The Lacuna.Signer.Api.FlowActions.FlowActionCreateModel.Step must be greater or equal to the current pending step.
   * @return addedFlowActions
  **/
  @Schema(description = "The actions to be added to the flow.  The Lacuna.Signer.Api.FlowActions.FlowActionCreateModel.Step must be greater or equal to the current pending step.")
  public List<FlowActionCreateModel> getAddedFlowActions() {
    return addedFlowActions;
  }

  public void setAddedFlowActions(List<FlowActionCreateModel> addedFlowActions) {
    this.addedFlowActions = addedFlowActions;
  }

  public DocumentFlowEditRequest editedFlowActions(List<FlowActionEditModel> editedFlowActions) {
    this.editedFlowActions = editedFlowActions;
    return this;
  }

  public DocumentFlowEditRequest addEditedFlowActionsItem(FlowActionEditModel editedFlowActionsItem) {
    if (this.editedFlowActions == null) {
      this.editedFlowActions = new ArrayList<FlowActionEditModel>();
    }
    this.editedFlowActions.add(editedFlowActionsItem);
    return this;
  }

   /**
   * The existing actions to be modified.  Flow actions that have already been completed or are partially completed cannot be edited.
   * @return editedFlowActions
  **/
  @Schema(description = "The existing actions to be modified.  Flow actions that have already been completed or are partially completed cannot be edited.")
  public List<FlowActionEditModel> getEditedFlowActions() {
    return editedFlowActions;
  }

  public void setEditedFlowActions(List<FlowActionEditModel> editedFlowActions) {
    this.editedFlowActions = editedFlowActions;
  }

  public DocumentFlowEditRequest deletedFlowActionIds(List<UUID> deletedFlowActionIds) {
    this.deletedFlowActionIds = deletedFlowActionIds;
    return this;
  }

  public DocumentFlowEditRequest addDeletedFlowActionIdsItem(UUID deletedFlowActionIdsItem) {
    if (this.deletedFlowActionIds == null) {
      this.deletedFlowActionIds = new ArrayList<UUID>();
    }
    this.deletedFlowActionIds.add(deletedFlowActionIdsItem);
    return this;
  }

   /**
   * The Ids of flow actions to be deleted.  Flow actions that have already been completed or are partially completed cannot be deleted.
   * @return deletedFlowActionIds
  **/
  @Schema(description = "The Ids of flow actions to be deleted.  Flow actions that have already been completed or are partially completed cannot be deleted.")
  public List<UUID> getDeletedFlowActionIds() {
    return deletedFlowActionIds;
  }

  public void setDeletedFlowActionIds(List<UUID> deletedFlowActionIds) {
    this.deletedFlowActionIds = deletedFlowActionIds;
  }

  public DocumentFlowEditRequest addedObservers(List<ObserverCreateModel> addedObservers) {
    this.addedObservers = addedObservers;
    return this;
  }

  public DocumentFlowEditRequest addAddedObserversItem(ObserverCreateModel addedObserversItem) {
    if (this.addedObservers == null) {
      this.addedObservers = new ArrayList<ObserverCreateModel>();
    }
    this.addedObservers.add(addedObserversItem);
    return this;
  }

   /**
   * The observers to be added to the document.
   * @return addedObservers
  **/
  @Schema(description = "The observers to be added to the document.")
  public List<ObserverCreateModel> getAddedObservers() {
    return addedObservers;
  }

  public void setAddedObservers(List<ObserverCreateModel> addedObservers) {
    this.addedObservers = addedObservers;
  }

  public DocumentFlowEditRequest editedObservers(List<ObserverEditModel> editedObservers) {
    this.editedObservers = editedObservers;
    return this;
  }

  public DocumentFlowEditRequest addEditedObserversItem(ObserverEditModel editedObserversItem) {
    if (this.editedObservers == null) {
      this.editedObservers = new ArrayList<ObserverEditModel>();
    }
    this.editedObservers.add(editedObserversItem);
    return this;
  }

   /**
   * The existing observers to be modified.
   * @return editedObservers
  **/
  @Schema(description = "The existing observers to be modified.")
  public List<ObserverEditModel> getEditedObservers() {
    return editedObservers;
  }

  public void setEditedObservers(List<ObserverEditModel> editedObservers) {
    this.editedObservers = editedObservers;
  }

  public DocumentFlowEditRequest deletedObserverIds(List<UUID> deletedObserverIds) {
    this.deletedObserverIds = deletedObserverIds;
    return this;
  }

  public DocumentFlowEditRequest addDeletedObserverIdsItem(UUID deletedObserverIdsItem) {
    if (this.deletedObserverIds == null) {
      this.deletedObserverIds = new ArrayList<UUID>();
    }
    this.deletedObserverIds.add(deletedObserverIdsItem);
    return this;
  }

   /**
   * The Ids of observers to be deleted.
   * @return deletedObserverIds
  **/
  @Schema(description = "The Ids of observers to be deleted.")
  public List<UUID> getDeletedObserverIds() {
    return deletedObserverIds;
  }

  public void setDeletedObserverIds(List<UUID> deletedObserverIds) {
    this.deletedObserverIds = deletedObserverIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFlowEditRequest documentsDocumentFlowEditRequest = (DocumentFlowEditRequest) o;
    return Objects.equals(this.addedFlowActions, documentsDocumentFlowEditRequest.addedFlowActions) &&
        Objects.equals(this.editedFlowActions, documentsDocumentFlowEditRequest.editedFlowActions) &&
        Objects.equals(this.deletedFlowActionIds, documentsDocumentFlowEditRequest.deletedFlowActionIds) &&
        Objects.equals(this.addedObservers, documentsDocumentFlowEditRequest.addedObservers) &&
        Objects.equals(this.editedObservers, documentsDocumentFlowEditRequest.editedObservers) &&
        Objects.equals(this.deletedObserverIds, documentsDocumentFlowEditRequest.deletedObserverIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addedFlowActions, editedFlowActions, deletedFlowActionIds, addedObservers, editedObservers, deletedObserverIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFlowEditRequest {\n");
    
    sb.append("    addedFlowActions: ").append(toIndentedString(addedFlowActions)).append("\n");
    sb.append("    editedFlowActions: ").append(toIndentedString(editedFlowActions)).append("\n");
    sb.append("    deletedFlowActionIds: ").append(toIndentedString(deletedFlowActionIds)).append("\n");
    sb.append("    addedObservers: ").append(toIndentedString(addedObservers)).append("\n");
    sb.append("    editedObservers: ").append(toIndentedString(editedObservers)).append("\n");
    sb.append("    deletedObserverIds: ").append(toIndentedString(deletedObserverIds)).append("\n");
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