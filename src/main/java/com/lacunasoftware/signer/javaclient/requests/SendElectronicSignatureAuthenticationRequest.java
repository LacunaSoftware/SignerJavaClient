package com.lacunasoftware.signer.javaclient.requests;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureSendElectronicSignatureAuthenticationRequest.java

class LacunaSignerApiSignatureSendElectronicSignatureAuthenticationRequest {
=======
public class SendElectronicSignatureAuthenticationRequest {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/requests/SendElectronicSignatureAuthenticationRequest.java

	@SerializedName("flowActionId")
	private UUID flowActionId;

	@SerializedName("resend")
	private boolean resend;

	public UUID getFlowActionId() {
		return flowActionId;
	}

	public void setFlowActionId(UUID flowActionId) {
		this.flowActionId = flowActionId;
	}

	public boolean isResend() {
		return resend;
	}

	public void setResend(boolean resend) {
		this.resend = resend;
	}
}