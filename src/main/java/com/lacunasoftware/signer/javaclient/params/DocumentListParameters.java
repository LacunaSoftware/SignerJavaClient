package com.lacunasoftware.signer.javaclient.params;

import com.lacunasoftware.signer.DocumentTypes;
import com.lacunasoftware.signer.FolderType;
import com.lacunasoftware.signer.PaginationOrders;

import java.util.UUID;

public class DocumentListParameters extends PaginatedSearchParams {

    public boolean IsConcluded;

    public UUID FolderId;

    public FolderType FolderType;

    public DocumentTypes DocumentType;

    public boolean FilterByDocumentType;


    public boolean getIsConcluded() {
        return this.IsConcluded;
    }

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

}