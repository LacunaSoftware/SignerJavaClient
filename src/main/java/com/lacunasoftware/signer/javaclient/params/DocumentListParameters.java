package com.lacunasoftware.signer.javaclient.params;

import com.lacunasoftware.signer.*;

import java.util.UUID;

public class DocumentListParameters extends PaginatedSearchParams {


    private boolean isConcluded;

    private UUID folderId = null;

    private FolderType folderType = FolderType.NORMAL;

    private DocumentTypes documentType;

    private boolean filterByDocumentType;

    private DocumentFilterStatus documentFilterStatus;

    private DocumentQueryTypes documentQueryTypes;

    private ParticipantQueryTypes participantQueryTypes;

    private String participantQ = null;


    public boolean getIsConcluded() {
        return this.isConcluded;
    }

    /**
     *
     *	This method does not use the new patterns to retrieve a document
     * @deprecated use {@link #setDocumentFilterStatus} instead.
     */
    @Deprecated
    public void setIsConcluded(boolean isConcluded) {
        this.isConcluded = isConcluded;
    }

    public UUID getFolderId() {
        return this.folderId;
    }

    public void setFolderId(UUID folderId) {
        this.folderId = folderId;
    }

    public FolderType getFolderType() {
        return this.folderType;
    }

    public void setFolderType(FolderType folderType) {
        this.folderType = folderType;
    }

    public DocumentTypes getDocumentTypes() {
        return this.documentType;
    }

    public void setDocumentTypes(DocumentTypes documentType) {
        this.documentType = documentType;
    }

    public boolean getFilterByDocumentType() {
        return this.filterByDocumentType;
    }

    public void setFilterByDocumentType(boolean filterByDocumentType) {
        this.filterByDocumentType = filterByDocumentType;
    }

    public DocumentFilterStatus getDocumentFilterStatus() {
        return this.documentFilterStatus;
    }

    public void setDocumentFilterStatus(DocumentFilterStatus documentFilterStatus) {
        this.documentFilterStatus = documentFilterStatus;
    }

    public DocumentQueryTypes getDocumentQueryTypes() {
        return this.documentQueryTypes;
    }

    public void setDocumentQueryTypes(DocumentQueryTypes documentQueryTypes) {
        this.documentQueryTypes = documentQueryTypes;
    }

    public ParticipantQueryTypes getParticipantQueryTypes() {
        return this.participantQueryTypes;
    }

    public void setParticipantQueryTypes(ParticipantQueryTypes participantQueryTypes) {
        this.participantQueryTypes = participantQueryTypes;
    }

    public String getParticipantQ() {
        return this.participantQ;
    }

    public void setParticipantQ(String ParticipantQ) {
        this.participantQ = ParticipantQ;
    }

}