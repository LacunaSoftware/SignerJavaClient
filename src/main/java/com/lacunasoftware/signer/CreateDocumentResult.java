package com.lacunasoftware.signer;


import java.util.UUID;


public class CreateDocumentResult {
	private String uploadId;
	private UUID documentId;

	public CreateDocumentResult(LacunaSignerApiDocumentsCreateDocumentResult model) {
		this.uploadId = model.getUploadId();
		this.documentId = model.getDocumentId();
	}

	public String getUploadId() {
		return uploadId;
	}

	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}

	public UUID getDocumentId() {
		return documentId;
	}

	public void setDocumentId(UUID documentId) {
		this.documentId = documentId;
	}
}
