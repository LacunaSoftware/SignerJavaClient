package com.lacunasoftware.signer.javaclient.params;

import com.lacunasoftware.signer.*;

import java.util.UUID;

public class DocumentListParameters extends PaginatedSearchParams {


    public boolean IsConcluded;

    public UUID FolderId = null;

    public FolderType FolderType = com.lacunasoftware.signer.FolderType.NORMAL;

    public DocumentTypes DocumentType;

    public boolean FilterByDocumentType;

    public DocumentFilterStatus documentFilterStatus;

    public DocumentQueryTypes documentQueryTypes;

    public ParticipantQueryTypes participantQueryTypes;

    public String participantQ = null;


    public boolean getIsConcluded() {
        return this.IsConcluded;
    }
    @Deprecated
    public void setIsConcluded(boolean IsConcluded) {
        this.IsConcluded = IsConcluded;
    }

    public UUID getFolderId() {
        return this.FolderId;
    }

    public void setFolderId(UUID FolderId) {
        this.FolderId = FolderId;
    }

    public FolderType getFolderType() {
        return this.FolderType;
    }

    public void setFolderType(FolderType FolderType) {
        this.FolderType = FolderType;
    }

    public DocumentTypes getDocumentTypes() {
        return this.DocumentType;
    }

    public void setDocumentTypes(DocumentTypes DocumentTypes) {
        this.DocumentType = DocumentTypes;
    }

    public boolean getFilterByDocumentType() {
        return this.FilterByDocumentType;
    }

    public void setFilterByDocumentType(boolean FilterByDocumentType) {
        this.FilterByDocumentType = FilterByDocumentType;
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