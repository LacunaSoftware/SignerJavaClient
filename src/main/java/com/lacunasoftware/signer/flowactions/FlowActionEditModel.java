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

package com.lacunasoftware.signer.flowactions;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.lacunasoftware.signer.flowactions.SignRuleUserEditModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * FlowActionEditModel
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-07-03T19:34:04.293-03:00[America/Sao_Paulo]")
public class FlowActionEditModel {
  @SerializedName("flowActionId")
  private UUID flowActionId = null;

  @SerializedName("step")
  private Integer step = null;

  @SerializedName("participantEmailAddress")
  private String participantEmailAddress = null;

  @SerializedName("ruleName")
  private String ruleName = null;

  @SerializedName("signRuleUsers")
  private List<SignRuleUserEditModel> signRuleUsers = null;

  @SerializedName("title")
  private String title = null;

  public FlowActionEditModel flowActionId(UUID flowActionId) {
    this.flowActionId = flowActionId;
    return this;
  }

   /**
   * The Id of the flow action being modified.
   * @return flowActionId
  **/
  @Schema(description = "The Id of the flow action being modified.")
  public UUID getFlowActionId() {
    return flowActionId;
  }

  public void setFlowActionId(UUID flowActionId) {
    this.flowActionId = flowActionId;
  }

  public FlowActionEditModel step(Integer step) {
    this.step = step;
    return this;
  }

   /**
   * The new step of the action.  This must be greater or equal to the current pending step.
   * @return step
  **/
  @Schema(description = "The new step of the action.  This must be greater or equal to the current pending step.")
  public Integer getStep() {
    return step;
  }

  public void setStep(Integer step) {
    this.step = step;
  }

  public FlowActionEditModel participantEmailAddress(String participantEmailAddress) {
    this.participantEmailAddress = participantEmailAddress;
    return this;
  }

   /**
   * The new email address of the action&#x27;s participant (if the type is Lacuna.Signer.Api.FlowActionType.Signer or Lacuna.Signer.Api.FlowActionType.Approver).
   * @return participantEmailAddress
  **/
  @Schema(description = "The new email address of the action's participant (if the type is Lacuna.Signer.Api.FlowActionType.Signer or Lacuna.Signer.Api.FlowActionType.Approver).")
  public String getParticipantEmailAddress() {
    return participantEmailAddress;
  }

  public void setParticipantEmailAddress(String participantEmailAddress) {
    this.participantEmailAddress = participantEmailAddress;
  }

  public FlowActionEditModel ruleName(String ruleName) {
    this.ruleName = ruleName;
    return this;
  }

   /**
   * The new rule name (if the type is Lacuna.Signer.Api.FlowActionType.SignRule).
   * @return ruleName
  **/
  @Schema(description = "The new rule name (if the type is Lacuna.Signer.Api.FlowActionType.SignRule).")
  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public FlowActionEditModel signRuleUsers(List<SignRuleUserEditModel> signRuleUsers) {
    this.signRuleUsers = signRuleUsers;
    return this;
  }

  public FlowActionEditModel addSignRuleUsersItem(SignRuleUserEditModel signRuleUsersItem) {
    if (this.signRuleUsers == null) {
      this.signRuleUsers = new ArrayList<SignRuleUserEditModel>();
    }
    this.signRuleUsers.add(signRuleUsersItem);
    return this;
  }

   /**
   * The rule users to be edited (if the type is Lacuna.Signer.Api.FlowActionType.SignRule).
   * @return signRuleUsers
  **/
  @Schema(description = "The rule users to be edited (if the type is Lacuna.Signer.Api.FlowActionType.SignRule).")
  public List<SignRuleUserEditModel> getSignRuleUsers() {
    return signRuleUsers;
  }

  public void setSignRuleUsers(List<SignRuleUserEditModel> signRuleUsers) {
    this.signRuleUsers = signRuleUsers;
  }

  public FlowActionEditModel title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @Schema(description = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowActionEditModel flowActionsFlowActionEditModel = (FlowActionEditModel) o;
    return Objects.equals(this.flowActionId, flowActionsFlowActionEditModel.flowActionId) &&
        Objects.equals(this.step, flowActionsFlowActionEditModel.step) &&
        Objects.equals(this.participantEmailAddress, flowActionsFlowActionEditModel.participantEmailAddress) &&
        Objects.equals(this.ruleName, flowActionsFlowActionEditModel.ruleName) &&
        Objects.equals(this.signRuleUsers, flowActionsFlowActionEditModel.signRuleUsers) &&
        Objects.equals(this.title, flowActionsFlowActionEditModel.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flowActionId, step, participantEmailAddress, ruleName, signRuleUsers, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowActionEditModel {\n");
    
    sb.append("    flowActionId: ").append(toIndentedString(flowActionId)).append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
    sb.append("    participantEmailAddress: ").append(toIndentedString(participantEmailAddress)).append("\n");
    sb.append("    ruleName: ").append(toIndentedString(ruleName)).append("\n");
    sb.append("    signRuleUsers: ").append(toIndentedString(signRuleUsers)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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