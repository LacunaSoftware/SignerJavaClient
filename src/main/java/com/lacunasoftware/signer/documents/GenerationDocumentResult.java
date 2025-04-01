package com.lacunasoftware.signer.documents;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class GenerationDocumentResult {
    
    @JsonProperty("folderId")
	@SerializedName("folderId")
    private String folderId;

    @JsonProperty("subscriptionId")
	@SerializedName("subscriptionId")
    private String subscriptionId;

    @JsonProperty("id")
	@SerializedName("id")
    private String id;

    @JsonProperty("type")
	@SerializedName("type")
    private String type;

    @JsonProperty("agentId")
	@SerializedName("agentId")
    private String agentId;

    @JsonProperty("totalDocumentsCount")
	@SerializedName("totalDocumentsCount")
    private Integer totalDocumentsCount;

    @JsonProperty("initializedCount")
	@SerializedName("initializedCount")
    private Integer initializedCount;

    @JsonProperty("completedCount")
	@SerializedName("completedCount")
    private Integer completedCount;

    @JsonProperty("status")
	@SerializedName("status")
    private String status;
    // Default constructor
    public GenerationDocumentResult() {}

    // Constructor with fields
    public GenerationDocumentResult(String folderId, String subscriptionId, String id, String type, String agentId, 
                                    Integer totalDocumentsCount, Integer initializedCount, Integer completedCount, String status) {
        this.folderId = folderId;
        this.subscriptionId = subscriptionId;
        this.id = id;
        this.type = type;
        this.agentId = agentId;
        this.totalDocumentsCount = totalDocumentsCount;
        this.initializedCount = initializedCount;
        this.completedCount = completedCount;
        this.status = status;
    }

    // Getters and Setters
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Integer getTotalDocumentsCount() {
        return totalDocumentsCount;
    }

    public void setTotalDocumentsCount(Integer totalDocumentsCount) {
        this.totalDocumentsCount = totalDocumentsCount;
    }

    public Integer getInitializedCount() {
        return initializedCount;
    }

    public void setInitializedCount(Integer initializedCount) {
        this.initializedCount = initializedCount;
    }

    public Integer getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Integer completedCount) {
        this.completedCount = completedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenerationDocumentResult that = (GenerationDocumentResult) o;
        return Objects.equals(folderId, that.folderId) &&
               Objects.equals(subscriptionId, that.subscriptionId) &&
               Objects.equals(id, that.id) &&
               Objects.equals(type, that.type) &&
               Objects.equals(agentId, that.agentId) &&
               Objects.equals(totalDocumentsCount, that.totalDocumentsCount) &&
               Objects.equals(initializedCount, that.initializedCount) &&
               Objects.equals(completedCount, that.completedCount) &&
               Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folderId, subscriptionId, id, type, agentId, totalDocumentsCount, initializedCount, completedCount, status);
    }

    @Override
    public String toString() {
        return "GenerationDocumentResult{" +
               "folderId='" + folderId + '\'' +
               ", subscriptionId='" + subscriptionId + '\'' +
               ", id='" + id + '\'' +
               ", type='" + type + '\'' +
               ", agentId='" + agentId + '\'' +
               ", totalDocumentsCount=" + totalDocumentsCount +
               ", initializedCount=" + initializedCount +
               ", completedCount=" + completedCount +
               ", status='" + status + '\'' +
               '}';
    }
}
