package com.lacunasoftware.signer.javaclient.requests;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.javaclient.positions.PdfMarkPosition;

public class StartSignatureRequest {

	@JsonProperty("flowActionId")
	@SerializedName("flowActionId")
	private UUID flowActionId;

	@JsonProperty("certificate")
	@SerializedName("certificate")
	private byte[] certificate;

	@JsonProperty("signaturePosition")
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