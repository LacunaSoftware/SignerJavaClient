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
import com.lacunasoftware.signer.DocumentTypes;
import com.lacunasoftware.signer.documents.DocumentTagModel;
import com.lacunasoftware.signer.folders.FolderInfoModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
/**
 * DocumentListModel
 */


public class DocumentListModel {
  @JsonProperty("id")
	@SerializedName("id")
  private UUID id = null;

  @JsonProperty("name")
	@SerializedName("name")
  private String name = null;

  @JsonProperty("creationDate")
	@SerializedName("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("updateDate")
	@SerializedName("updateDate")
  private OffsetDateTime updateDate = null;

  @JsonProperty("folder")
	@SerializedName("folder")
  private FolderInfoModel folder = null;

  @JsonProperty("type")
	@SerializedName("type")
  private DocumentTypes type = null;

  @JsonProperty("tags")
	@SerializedName("tags")
  private List<DocumentTagModel> tags = null;

  public DocumentListModel id(UUID id) {
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

  public DocumentListModel name(String name) {
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

  public DocumentListModel creationDate(OffsetDateTime creationDate) {
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

  public DocumentListModel updateDate(OffsetDateTime updateDate) {
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

  public DocumentListModel folder(FolderInfoModel folder) {
    this.folder = folder;
    return this;
  }

   /**
   * Get folder
   * @return folder
  **/
  @Schema(description = "")
  public FolderInfoModel getFolder() {
    return folder;
  }

  public void setFolder(FolderInfoModel folder) {
    this.folder = folder;
  }

  public DocumentListModel type(DocumentTypes type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public DocumentTypes getType() {
    return type;
  }

  public void setType(DocumentTypes type) {
    this.type = type;
  }

  public DocumentListModel tags(List<DocumentTagModel> tags) {
    this.tags = tags;
    return this;
  }

  public DocumentListModel addTagsItem(DocumentTagModel tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<DocumentTagModel>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @Schema(description = "")
  public List<DocumentTagModel> getTags() {
    return tags;
  }

  public void setTags(List<DocumentTagModel> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentListModel documentsDocumentListModel = (DocumentListModel) o;
    return Objects.equals(this.id, documentsDocumentListModel.id) &&
        Objects.equals(this.name, documentsDocumentListModel.name) &&
        Objects.equals(this.creationDate, documentsDocumentListModel.creationDate) &&
        Objects.equals(this.updateDate, documentsDocumentListModel.updateDate) &&
        Objects.equals(this.folder, documentsDocumentListModel.folder) &&
        Objects.equals(this.type, documentsDocumentListModel.type) &&
        Objects.equals(this.tags, documentsDocumentListModel.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, creationDate, updateDate, folder, type, tags);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentListModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    updateDate: ").append(toIndentedString(updateDate)).append("\n");
    sb.append("    folder: ").append(toIndentedString(folder)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
