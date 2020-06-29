package com.lacunasoftware.signer;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class StartSignatureRequest {

	@SerializedName("flowActionId")
	private UUID flowActionId;

	@SerializedName("certificate")
	private byte[] certificate;

	@SerializedName("signaturePosition")
	private PdfMarkPosition signaturePosition;

	public UUID getFlowActionId() {
		return flowActionId;
	}

	public void setFlowActionId(UUID flowActionId) {
		this.flowActionId = flowActionId;
	}

	public byte[] getCertificate() {
		return certificate;
	}

	public void setCertificate(byte[] certificate) {
		this.certificate = certificate;
	}

	public PdfMarkPosition getSignaturePosition() {
		return signaturePosition;
	}

	public void setSignaturePosition(PdfMarkPosition signaturePosition) {
		this.signaturePosition = signaturePosition;
	}
}