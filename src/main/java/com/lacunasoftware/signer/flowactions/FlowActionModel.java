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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lacunasoftware.signer.ActionStatus;
import com.lacunasoftware.signer.CertificateHolderTypes;
import com.lacunasoftware.signer.CertificateTypes;
import com.lacunasoftware.signer.documentmark.DocumentMarkPositionModel;
import com.lacunasoftware.signer.FlowActionType;
import com.lacunasoftware.signer.flowactions.SignRuleUserModel;
import com.lacunasoftware.signer.SignatureInitialsModes;
import com.lacunasoftware.signer.users.ParticipantUserModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
/**
 * FlowActionModel
 */


public class FlowActionModel {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("pendingDate")
  private OffsetDateTime pendingDate = null;

  @JsonProperty("updateDate")
  private OffsetDateTime updateDate = null;

  @JsonProperty("user")
  private ParticipantUserModel user = null;

  @JsonProperty("numberRequiredSignatures")
  private Integer numberRequiredSignatures = null;

  @JsonProperty("signRuleUsers")
  private List<SignRuleUserModel> signRuleUsers = null;

  @JsonProperty("marks")
  private List<DocumentMarkPositionModel> marks = null;

  @JsonProperty("allowElectronicSignature")
  private Boolean allowElectronicSignature = null;

  @JsonProperty("requireSmsAuthenticationToSignElectronically")
  private Boolean requireSmsAuthenticationToSignElectronically = null;

  @JsonProperty("requireAuthenticatorAppToSignElectronically")
  private Boolean requireAuthenticatorAppToSignElectronically = null;

  @JsonProperty("requireSelfieAuthenticationToSignElectronically")
  private Boolean requireSelfieAuthenticationToSignElectronically = null;

  @JsonProperty("requireDatavalidAuthenticationToSignElectronically")
  private Boolean requireDatavalidAuthenticationToSignElectronically = null;

  @JsonProperty("requirePixAuthenticationToSignElectronically")
  private Boolean requirePixAuthenticationToSignElectronically = null;

  @JsonProperty("requiredCertificateTypeToSign")
  private CertificateTypes requiredCertificateTypeToSign = null;

  @JsonProperty("requireCompanyCertificate")
  private Boolean requireCompanyCertificate = null;

  @JsonProperty("requiredCompanyIdentifier")
  private String requiredCompanyIdentifier = null;

  @JsonProperty("requiredCertificateHolderTypeToSign")
  private CertificateHolderTypes requiredCertificateHolderTypeToSign = null;

  @JsonProperty("refusalReason")
  private String refusalReason = null;

  @JsonProperty("signatureInitialsMode")
  private SignatureInitialsModes signatureInitialsMode = null;

  @JsonProperty("isElectronic")
  private Boolean isElectronic = null;

  @JsonProperty("allowRuleFlowToContinueIfRefused")
  private Boolean allowRuleFlowToContinueIfRefused = null;

  @JsonProperty("type")
  private FlowActionType type = null;

  @JsonProperty("status")
  private ActionStatus status = null;

  @JsonProperty("step")
  private Integer step = null;

  @JsonProperty("ruleName")
  private String ruleName = null;

  @JsonProperty("title")
  private String title = null;

  public FlowActionModel id(UUID id) {
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

  public FlowActionModel creationDate(OffsetDateTime creationDate) {
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

  public FlowActionModel pendingDate(OffsetDateTime pendingDate) {
    this.pendingDate = pendingDate;
    return this;
  }

   /**
   * Get pendingDate
   * @return pendingDate
  **/
  @Schema(description = "")
  public OffsetDateTime getPendingDate() {
    return pendingDate;
  }

  public void setPendingDate(OffsetDateTime pendingDate) {
    this.pendingDate = pendingDate;
  }

  public FlowActionModel updateDate(OffsetDateTime updateDate) {
    this.updateDate = updateDate;
    return this;
  }

   /**
   * Get updateDate
   * @return updateDate
  **/
  @Schema(description = "")
  public OffsetDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(OffsetDateTime updateDate) {
    this.updateDate = updateDate;
  }

  public FlowActionModel user(ParticipantUserModel user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @Schema(description = "")
  public ParticipantUserModel getUser() {
    return user;
  }

  public void setUser(ParticipantUserModel user) {
    this.user = user;
  }

  public FlowActionModel numberRequiredSignatures(Integer numberRequiredSignatures) {
    this.numberRequiredSignatures = numberRequiredSignatures;
    return this;
  }

   /**
   * Number of required signatures if type is SignRule
   * @return numberRequiredSignatures
  **/
  @Schema(description = "Number of required signatures if type is SignRule")
  public Integer getNumberRequiredSignatures() {
    return numberRequiredSignatures;
  }

  public void setNumberRequiredSignatures(Integer numberRequiredSignatures) {
    this.numberRequiredSignatures = numberRequiredSignatures;
  }

  public FlowActionModel signRuleUsers(List<SignRuleUserModel> signRuleUsers) {
    this.signRuleUsers = signRuleUsers;
    return this;
  }

  public FlowActionModel addSignRuleUsersItem(SignRuleUserModel signRuleUsersItem) {
    if (this.signRuleUsers == null) {
      this.signRuleUsers = new ArrayList<SignRuleUserModel>();
    }
    this.signRuleUsers.add(signRuleUsersItem);
    return this;
  }

   /**
   * Users that are allowed to sign if type is SignRule
   * @return signRuleUsers
  **/
  @Schema(description = "Users that are allowed to sign if type is SignRule")
  public List<SignRuleUserModel> getSignRuleUsers() {
    return signRuleUsers;
  }

  public void setSignRuleUsers(List<SignRuleUserModel> signRuleUsers) {
    this.signRuleUsers = signRuleUsers;
  }

  public FlowActionModel marks(List<DocumentMarkPositionModel> marks) {
    this.marks = marks;
    return this;
  }

  public FlowActionModel addMarksItem(DocumentMarkPositionModel marksItem) {
    if (this.marks == null) {
      this.marks = new ArrayList<DocumentMarkPositionModel>();
    }
    this.marks.add(marksItem);
    return this;
  }

   /**
   * Get marks
   * @return marks
  **/
  @Schema(description = "")
  public List<DocumentMarkPositionModel> getMarks() {
    return marks;
  }

  public void setMarks(List<DocumentMarkPositionModel> marks) {
    this.marks = marks;
  }

  public FlowActionModel allowElectronicSignature(Boolean allowElectronicSignature) {
    this.allowElectronicSignature = allowElectronicSignature;
    return this;
  }

   /**
   * True if the electronic signature option is available for this action (only if the type of the action is Signer or SignRule)
   * @return allowElectronicSignature
  **/
  @Schema(description = "True if the electronic signature option is available for this action (only if the type of the action is Signer or SignRule)")
  public Boolean isAllowElectronicSignature() {
    return allowElectronicSignature;
  }

  public void setAllowElectronicSignature(Boolean allowElectronicSignature) {
    this.allowElectronicSignature = allowElectronicSignature;
  }

  public FlowActionModel requireSmsAuthenticationToSignElectronically(Boolean requireSmsAuthenticationToSignElectronically) {
    this.requireSmsAuthenticationToSignElectronically = requireSmsAuthenticationToSignElectronically;
    return this;
  }

   /**
   * Requires the user to confirm a code sent to his phone to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)
   * @return requireSmsAuthenticationToSignElectronically
  **/
  @Schema(description = "Requires the user to confirm a code sent to his phone to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)")
  public Boolean isRequireSmsAuthenticationToSignElectronically() {
    return requireSmsAuthenticationToSignElectronically;
  }

  public void setRequireSmsAuthenticationToSignElectronically(Boolean requireSmsAuthenticationToSignElectronically) {
    this.requireSmsAuthenticationToSignElectronically = requireSmsAuthenticationToSignElectronically;
  }

  public FlowActionModel requireAuthenticatorAppToSignElectronically(Boolean requireAuthenticatorAppToSignElectronically) {
    this.requireAuthenticatorAppToSignElectronically = requireAuthenticatorAppToSignElectronically;
    return this;
  }

   /**
   * Requires the user to enter a one-time password (OTP) to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)
   * @return requireAuthenticatorAppToSignElectronically
  **/
  @Schema(description = "Requires the user to enter a one-time password (OTP) to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)")
  public Boolean isRequireAuthenticatorAppToSignElectronically() {
    return requireAuthenticatorAppToSignElectronically;
  }

  public void setRequireAuthenticatorAppToSignElectronically(Boolean requireAuthenticatorAppToSignElectronically) {
    this.requireAuthenticatorAppToSignElectronically = requireAuthenticatorAppToSignElectronically;
  }

  public FlowActionModel requireSelfieAuthenticationToSignElectronically(Boolean requireSelfieAuthenticationToSignElectronically) {
    this.requireSelfieAuthenticationToSignElectronically = requireSelfieAuthenticationToSignElectronically;
    return this;
  }

   /**
   * Requires the user to take a selfie to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)
   * @return requireSelfieAuthenticationToSignElectronically
  **/
  @Schema(description = "Requires the user to take a selfie to sign electronically. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)")
  public Boolean isRequireSelfieAuthenticationToSignElectronically() {
    return requireSelfieAuthenticationToSignElectronically;
  }

  public void setRequireSelfieAuthenticationToSignElectronically(Boolean requireSelfieAuthenticationToSignElectronically) {
    this.requireSelfieAuthenticationToSignElectronically = requireSelfieAuthenticationToSignElectronically;
  }

  public FlowActionModel requireDatavalidAuthenticationToSignElectronically(Boolean requireDatavalidAuthenticationToSignElectronically) {
    this.requireDatavalidAuthenticationToSignElectronically = requireDatavalidAuthenticationToSignElectronically;
    return this;
  }

   /**
   * Requires the user to take a selfie to sign electronically. This selfie will be validated by SERPRO&#x27;s Datavalid. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)
   * @return requireDatavalidAuthenticationToSignElectronically
  **/
  @Schema(description = "Requires the user to take a selfie to sign electronically. This selfie will be validated by SERPRO's Datavalid. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)")
  public Boolean isRequireDatavalidAuthenticationToSignElectronically() {
    return requireDatavalidAuthenticationToSignElectronically;
  }

  public void setRequireDatavalidAuthenticationToSignElectronically(Boolean requireDatavalidAuthenticationToSignElectronically) {
    this.requireDatavalidAuthenticationToSignElectronically = requireDatavalidAuthenticationToSignElectronically;
  }

  public FlowActionModel requirePixAuthenticationToSignElectronically(Boolean requirePixAuthenticationToSignElectronically) {
    this.requirePixAuthenticationToSignElectronically = requirePixAuthenticationToSignElectronically;
    return this;
  }

   /**
   * Requires the user to pay a Pix to sign electronically. The payer&#x27;s CPF must be the same as that of the user who will be signing. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)
   * @return requirePixAuthenticationToSignElectronically
  **/
  @Schema(description = "Requires the user to pay a Pix to sign electronically. The payer's CPF must be the same as that of the user who will be signing. (If Lacuna.Signer.Api.FlowActions.FlowActionModel.AllowElectronicSignature is true)")
  public Boolean isRequirePixAuthenticationToSignElectronically() {
    return requirePixAuthenticationToSignElectronically;
  }

  public void setRequirePixAuthenticationToSignElectronically(Boolean requirePixAuthenticationToSignElectronically) {
    this.requirePixAuthenticationToSignElectronically = requirePixAuthenticationToSignElectronically;
  }

  public FlowActionModel requiredCertificateTypeToSign(CertificateTypes requiredCertificateTypeToSign) {
    this.requiredCertificateTypeToSign = requiredCertificateTypeToSign;
    return this;
  }

   /**
   * Get requiredCertificateTypeToSign
   * @return requiredCertificateTypeToSign
  **/
  @Schema(description = "")
  public CertificateTypes getRequiredCertificateTypeToSign() {
    return requiredCertificateTypeToSign;
  }

  public void setRequiredCertificateTypeToSign(CertificateTypes requiredCertificateTypeToSign) {
    this.requiredCertificateTypeToSign = requiredCertificateTypeToSign;
  }

  public FlowActionModel requireCompanyCertificate(Boolean requireCompanyCertificate) {
    this.requireCompanyCertificate = requireCompanyCertificate;
    return this;
  }

   /**
   * [DEPRECATED] The user is required to sign the document with a company certificate (e.g. e-CNPJ). Please use Lacuna.Signer.Api.FlowActions.FlowActionModel.RequiredCertificateHolderTypeToSign instead.
   * @return requireCompanyCertificate
  **/
  @Schema(description = "[DEPRECATED] The user is required to sign the document with a company certificate (e.g. e-CNPJ). Please use Lacuna.Signer.Api.FlowActions.FlowActionModel.RequiredCertificateHolderTypeToSign instead.")
  public Boolean isRequireCompanyCertificate() {
    return requireCompanyCertificate;
  }

  public void setRequireCompanyCertificate(Boolean requireCompanyCertificate) {
    this.requireCompanyCertificate = requireCompanyCertificate;
  }

  public FlowActionModel requiredCompanyIdentifier(String requiredCompanyIdentifier) {
    this.requiredCompanyIdentifier = requiredCompanyIdentifier;
    return this;
  }

   /**
   * The user is required to sign the document with a company certificate (e.g. e-CNPJ) that has the provided company identifier.
   * @return requiredCompanyIdentifier
  **/
  @Schema(description = "The user is required to sign the document with a company certificate (e.g. e-CNPJ) that has the provided company identifier.")
  public String getRequiredCompanyIdentifier() {
    return requiredCompanyIdentifier;
  }

  public void setRequiredCompanyIdentifier(String requiredCompanyIdentifier) {
    this.requiredCompanyIdentifier = requiredCompanyIdentifier;
  }

  public FlowActionModel requiredCertificateHolderTypeToSign(CertificateHolderTypes requiredCertificateHolderTypeToSign) {
    this.requiredCertificateHolderTypeToSign = requiredCertificateHolderTypeToSign;
    return this;
  }

   /**
   * Get requiredCertificateHolderTypeToSign
   * @return requiredCertificateHolderTypeToSign
  **/
  @Schema(description = "")
  public CertificateHolderTypes getRequiredCertificateHolderTypeToSign() {
    return requiredCertificateHolderTypeToSign;
  }

  public void setRequiredCertificateHolderTypeToSign(CertificateHolderTypes requiredCertificateHolderTypeToSign) {
    this.requiredCertificateHolderTypeToSign = requiredCertificateHolderTypeToSign;
  }

  public FlowActionModel refusalReason(String refusalReason) {
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

  public FlowActionModel signatureInitialsMode(SignatureInitialsModes signatureInitialsMode) {
    this.signatureInitialsMode = signatureInitialsMode;
    return this;
  }

   /**
   * Get signatureInitialsMode
   * @return signatureInitialsMode
  **/
  @Schema(description = "")
  public SignatureInitialsModes getSignatureInitialsMode() {
    return signatureInitialsMode;
  }

  public void setSignatureInitialsMode(SignatureInitialsModes signatureInitialsMode) {
    this.signatureInitialsMode = signatureInitialsMode;
  }

  public FlowActionModel isElectronic(Boolean isElectronic) {
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

  public FlowActionModel allowRuleFlowToContinueIfRefused(Boolean allowRuleFlowToContinueIfRefused) {
    this.allowRuleFlowToContinueIfRefused = allowRuleFlowToContinueIfRefused;
    return this;
  }

   /**
   * Get allowRuleFlowToContinueIfRefused
   * @return allowRuleFlowToContinueIfRefused
  **/
  @Schema(description = "")
  public Boolean isAllowRuleFlowToContinueIfRefused() {
    return allowRuleFlowToContinueIfRefused;
  }

  public void setAllowRuleFlowToContinueIfRefused(Boolean allowRuleFlowToContinueIfRefused) {
    this.allowRuleFlowToContinueIfRefused = allowRuleFlowToContinueIfRefused;
  }

  public FlowActionModel type(FlowActionType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public FlowActionType getType() {
    return type;
  }

  public void setType(FlowActionType type) {
    this.type = type;
  }

  public FlowActionModel status(ActionStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public ActionStatus getStatus() {
    return status;
  }

  public void setStatus(ActionStatus status) {
    this.status = status;
  }

  public FlowActionModel step(Integer step) {
    this.step = step;
    return this;
  }

   /**
   * Get step
   * @return step
  **/
  @Schema(description = "")
  public Integer getStep() {
    return step;
  }

  public void setStep(Integer step) {
    this.step = step;
  }

  public FlowActionModel ruleName(String ruleName) {
    this.ruleName = ruleName;
    return this;
  }

   /**
   * Name of the rule if type is SignRule
   * @return ruleName
  **/
  @Schema(description = "Name of the rule if type is SignRule")
  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public FlowActionModel title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Title of the participant
   * @return title
  **/
  @Schema(description = "Title of the participant")
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
    FlowActionModel flowActionsFlowActionModel = (FlowActionModel) o;
    return Objects.equals(this.id, flowActionsFlowActionModel.id) &&
        Objects.equals(this.creationDate, flowActionsFlowActionModel.creationDate) &&
        Objects.equals(this.pendingDate, flowActionsFlowActionModel.pendingDate) &&
        Objects.equals(this.updateDate, flowActionsFlowActionModel.updateDate) &&
        Objects.equals(this.user, flowActionsFlowActionModel.user) &&
        Objects.equals(this.numberRequiredSignatures, flowActionsFlowActionModel.numberRequiredSignatures) &&
        Objects.equals(this.signRuleUsers, flowActionsFlowActionModel.signRuleUsers) &&
        Objects.equals(this.marks, flowActionsFlowActionModel.marks) &&
        Objects.equals(this.allowElectronicSignature, flowActionsFlowActionModel.allowElectronicSignature) &&
        Objects.equals(this.requireSmsAuthenticationToSignElectronically, flowActionsFlowActionModel.requireSmsAuthenticationToSignElectronically) &&
        Objects.equals(this.requireAuthenticatorAppToSignElectronically, flowActionsFlowActionModel.requireAuthenticatorAppToSignElectronically) &&
        Objects.equals(this.requireSelfieAuthenticationToSignElectronically, flowActionsFlowActionModel.requireSelfieAuthenticationToSignElectronically) &&
        Objects.equals(this.requireDatavalidAuthenticationToSignElectronically, flowActionsFlowActionModel.requireDatavalidAuthenticationToSignElectronically) &&
        Objects.equals(this.requirePixAuthenticationToSignElectronically, flowActionsFlowActionModel.requirePixAuthenticationToSignElectronically) &&
        Objects.equals(this.requiredCertificateTypeToSign, flowActionsFlowActionModel.requiredCertificateTypeToSign) &&
        Objects.equals(this.requireCompanyCertificate, flowActionsFlowActionModel.requireCompanyCertificate) &&
        Objects.equals(this.requiredCompanyIdentifier, flowActionsFlowActionModel.requiredCompanyIdentifier) &&
        Objects.equals(this.requiredCertificateHolderTypeToSign, flowActionsFlowActionModel.requiredCertificateHolderTypeToSign) &&
        Objects.equals(this.refusalReason, flowActionsFlowActionModel.refusalReason) &&
        Objects.equals(this.signatureInitialsMode, flowActionsFlowActionModel.signatureInitialsMode) &&
        Objects.equals(this.isElectronic, flowActionsFlowActionModel.isElectronic) &&
        Objects.equals(this.allowRuleFlowToContinueIfRefused, flowActionsFlowActionModel.allowRuleFlowToContinueIfRefused) &&
        Objects.equals(this.type, flowActionsFlowActionModel.type) &&
        Objects.equals(this.status, flowActionsFlowActionModel.status) &&
        Objects.equals(this.step, flowActionsFlowActionModel.step) &&
        Objects.equals(this.ruleName, flowActionsFlowActionModel.ruleName) &&
        Objects.equals(this.title, flowActionsFlowActionModel.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creationDate, pendingDate, updateDate, user, numberRequiredSignatures, signRuleUsers, marks, allowElectronicSignature, requireSmsAuthenticationToSignElectronically, requireAuthenticatorAppToSignElectronically, requireSelfieAuthenticationToSignElectronically, requireDatavalidAuthenticationToSignElectronically, requirePixAuthenticationToSignElectronically, requiredCertificateTypeToSign, requireCompanyCertificate, requiredCompanyIdentifier, requiredCertificateHolderTypeToSign, refusalReason, signatureInitialsMode, isElectronic, allowRuleFlowToContinueIfRefused, type, status, step, ruleName, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowActionModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    pendingDate: ").append(toIndentedString(pendingDate)).append("\n");
    sb.append("    updateDate: ").append(toIndentedString(updateDate)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    numberRequiredSignatures: ").append(toIndentedString(numberRequiredSignatures)).append("\n");
    sb.append("    signRuleUsers: ").append(toIndentedString(signRuleUsers)).append("\n");
    sb.append("    marks: ").append(toIndentedString(marks)).append("\n");
    sb.append("    allowElectronicSignature: ").append(toIndentedString(allowElectronicSignature)).append("\n");
    sb.append("    requireSmsAuthenticationToSignElectronically: ").append(toIndentedString(requireSmsAuthenticationToSignElectronically)).append("\n");
    sb.append("    requireAuthenticatorAppToSignElectronically: ").append(toIndentedString(requireAuthenticatorAppToSignElectronically)).append("\n");
    sb.append("    requireSelfieAuthenticationToSignElectronically: ").append(toIndentedString(requireSelfieAuthenticationToSignElectronically)).append("\n");
    sb.append("    requireDatavalidAuthenticationToSignElectronically: ").append(toIndentedString(requireDatavalidAuthenticationToSignElectronically)).append("\n");
    sb.append("    requirePixAuthenticationToSignElectronically: ").append(toIndentedString(requirePixAuthenticationToSignElectronically)).append("\n");
    sb.append("    requiredCertificateTypeToSign: ").append(toIndentedString(requiredCertificateTypeToSign)).append("\n");
    sb.append("    requireCompanyCertificate: ").append(toIndentedString(requireCompanyCertificate)).append("\n");
    sb.append("    requiredCompanyIdentifier: ").append(toIndentedString(requiredCompanyIdentifier)).append("\n");
    sb.append("    requiredCertificateHolderTypeToSign: ").append(toIndentedString(requiredCertificateHolderTypeToSign)).append("\n");
    sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
    sb.append("    signatureInitialsMode: ").append(toIndentedString(signatureInitialsMode)).append("\n");
    sb.append("    isElectronic: ").append(toIndentedString(isElectronic)).append("\n");
    sb.append("    allowRuleFlowToContinueIfRefused: ").append(toIndentedString(allowRuleFlowToContinueIfRefused)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
    sb.append("    ruleName: ").append(toIndentedString(ruleName)).append("\n");
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
