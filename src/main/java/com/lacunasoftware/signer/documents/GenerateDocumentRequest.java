package com.lacunasoftware.signer.documents;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.NotaryTypes;
import com.lacunasoftware.signer.flowactions.FlowActionCreateModel;
import com.lacunasoftware.signer.javaclient.models.UploadModel;
import com.lacunasoftware.signer.observers.ObserverCreateModel;

public class GenerateDocumentRequest {
	@JsonProperty("flowActions")
	@SerializedName("flowActions")

    private List<FlowActionCreateModel> flowActions;
	@JsonProperty("observers")
	@SerializedName("observers")

    private List<ObserverCreateModel> observers;
	@JsonProperty("folderId")
	@SerializedName("folderId")

    private String folderId;
	@JsonProperty("newFolderName")
	@SerializedName("newFolderName")

    private String newFolderName;
	@JsonProperty("organizationId")
	@SerializedName("organizationId")

    private String organizationId;
	@JsonProperty("type")
	@SerializedName("type")

    private String type;
	@JsonProperty("notaryType")
	@SerializedName("notaryType")

    private NotaryTypes notaryType;
	@JsonProperty("expirationDate")
	@SerializedName("expirationDate")

    private LocalDateTime expirationDate;
	@JsonProperty("notifiedEmails")
	@SerializedName("notifiedEmails")

    private List<String> notifiedEmails;
	@JsonProperty("dataFile")
	@SerializedName("dataFile")

    private UploadModel dataFile;
	@JsonProperty("templateFile")
	@SerializedName("templateFile")

    private UploadModel templateFile;

    public GenerateDocumentRequest() {
    }

    public List<FlowActionCreateModel> getFlowActions() {
        return flowActions;
    }

    public void setFlowActions(List<FlowActionCreateModel> flowActions) {
        this.flowActions = flowActions;
    }

    public List<ObserverCreateModel> getObservers() {
        return observers;
    }

    public void setObservers(List<ObserverCreateModel> observers) {
        this.observers = observers;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getNewFolderName() {
        return newFolderName;
    }

    public void setNewFolderName(String newFolderName) {
        this.newFolderName = newFolderName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NotaryTypes getNotaryTypes() {
        return notaryType;
    }

    public void setNotaryTypes(NotaryTypes notaryType) {
        this.notaryType = notaryType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<String> getNotifiedEmails() {
        return notifiedEmails;
    }

    public void setNotifiedEmails(List<String> notifiedEmails) {
        this.notifiedEmails = notifiedEmails;
    }

    public UploadModel getDataFile() {
        return dataFile;
    }

    public void setDataFile(UploadModel dataFile) {
        this.dataFile = dataFile;
    }

    public UploadModel getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(UploadModel templateFile) {
        this.templateFile = templateFile;
    }

    public boolean isValid() {
        return dataFile != null && templateFile != null && flowActions != null;
    }

    @Override
    public String toString() {
        return "GenerateDocumentRequest{" +
                "flowActions=" + flowActions +
                ", observers=" + observers +
                ", folderId='" + folderId + '\'' +
                ", newFolderName='" + newFolderName + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", type='" + type + '\'' +
                ", notaryType=" + notaryType +
                ", expirationDate=" + expirationDate +
                ", notifiedEmails=" + notifiedEmails +
                ", dataFile=" + dataFile +
                ", templateFile=" + templateFile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenerateDocumentRequest that = (GenerateDocumentRequest) o;
        return Objects.equals(flowActions, that.flowActions) &&
                Objects.equals(observers, that.observers) &&
                Objects.equals(folderId, that.folderId) &&
                Objects.equals(newFolderName, that.newFolderName) &&
                Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(type, that.type) &&
                notaryType == that.notaryType &&
                Objects.equals(expirationDate, that.expirationDate) &&
                Objects.equals(notifiedEmails, that.notifiedEmails) &&
                Objects.equals(dataFile, that.dataFile) &&
                Objects.equals(templateFile, that.templateFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowActions, observers, folderId, newFolderName, organizationId, type, notaryType, expirationDate, notifiedEmails, dataFile, templateFile);
    }
}
