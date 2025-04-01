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

package com.lacunasoftware.signer.documentflows;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.flowactions.FlowActionCreateModel;
import com.lacunasoftware.signer.observers.ObserverCreateModel;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * DocumentFlowCreateRequest
 */


public class DocumentFlowCreateRequest {
  @JsonProperty("name")
	@SerializedName("name")
  private String name = null;

  @JsonProperty("areActionsOrdered")
	@SerializedName("areActionsOrdered")
  private Boolean areActionsOrdered = null;

  @JsonProperty("flowActions")
	@SerializedName("flowActions")
  private List<FlowActionCreateModel> flowActions = new ArrayList<FlowActionCreateModel>();

  @JsonProperty("observers")
	@SerializedName("observers")
  private List<ObserverCreateModel> observers = null;

  public DocumentFlowCreateRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(required = true, description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DocumentFlowCreateRequest areActionsOrdered(Boolean areActionsOrdered) {
    this.areActionsOrdered = areActionsOrdered;
    return this;
  }

   /**
   * Get areActionsOrdered
   * @return areActionsOrdered
  **/
  @Schema(description = "")
  public Boolean isAreActionsOrdered() {
    return areActionsOrdered;
  }

  public void setAreActionsOrdered(Boolean areActionsOrdered) {
    this.areActionsOrdered = areActionsOrdered;
  }

  public DocumentFlowCreateRequest flowActions(List<FlowActionCreateModel> flowActions) {
    this.flowActions = flowActions;
    return this;
  }

  public DocumentFlowCreateRequest addFlowActionsItem(FlowActionCreateModel flowActionsItem) {
    this.flowActions.add(flowActionsItem);
    return this;
  }

   /**
   * Get flowActions
   * @return flowActions
  **/
  @Schema(required = true, description = "")
  public List<FlowActionCreateModel> getFlowActions() {
    return flowActions;
  }

  public void setFlowActions(List<FlowActionCreateModel> flowActions) {
    this.flowActions = flowActions;
  }

  public DocumentFlowCreateRequest observers(List<ObserverCreateModel> observers) {
    this.observers = observers;
    return this;
  }

  public DocumentFlowCreateRequest addObserversItem(ObserverCreateModel observersItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFlowCreateRequest documentFlowsDocumentFlowCreateRequest = (DocumentFlowCreateRequest) o;
    return Objects.equals(this.name, documentFlowsDocumentFlowCreateRequest.name) &&
        Objects.equals(this.areActionsOrdered, documentFlowsDocumentFlowCreateRequest.areActionsOrdered) &&
        Objects.equals(this.flowActions, documentFlowsDocumentFlowCreateRequest.flowActions) &&
        Objects.equals(this.observers, documentFlowsDocumentFlowCreateRequest.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, areActionsOrdered, flowActions, observers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFlowCreateRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    areActionsOrdered: ").append(toIndentedString(areActionsOrdered)).append("\n");
    sb.append("    flowActions: ").append(toIndentedString(flowActions)).append("\n");
    sb.append("    observers: ").append(toIndentedString(observers)).append("\n");
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
