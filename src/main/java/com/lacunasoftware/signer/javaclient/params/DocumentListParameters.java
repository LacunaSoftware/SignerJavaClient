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
    public boolean setIsConcluded(boolean IsConcluded) {
        return this.IsConcluded = IsConcluded ;
    }


    public UUID getFolderId() {
        return this.FolderId;
    }
    public UUID setFolderId(UUID FolderId) {
        return this.FolderId = FolderId ;
    }

    public FolderType getFolderType() {
        return this.FolderType;
    }
    public FolderType setFolderType(FolderType FolderType) {
        return this.FolderType = FolderType ;
    }

    public DocumentTypes DocumentTypes() {
        return this.DocumentType;
    }
    public DocumentTypes DocumentTypes(DocumentTypes DocumentTypes) {
        return this.DocumentType = DocumentTypes ;
    }

    public boolean getFilterByDocumentType() {
        return this.FilterByDocumentType;
    }
    public boolean setFilterByDocumentType(boolean FilterByDocumentType) {
        return this.FilterByDocumentType = FilterByDocumentType ;
    }

}