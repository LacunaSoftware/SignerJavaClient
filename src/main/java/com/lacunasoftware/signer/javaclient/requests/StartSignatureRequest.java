package com.lacunasoftware.signer.javaclient.requests;

import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.javaclient.positions.PdfMarkPosition;

import java.util.UUID;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureStartSignatureRequest.java

class LacunaSignerApiSignatureStartSignatureRequest {
=======
public class StartSignatureRequest {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/requests/StartSignatureRequest.java

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