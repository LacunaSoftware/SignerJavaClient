package com.lacunasoftware.signer.javaclient.requests;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureCompleteSignatureRequest.java

import com.google.gson.annotations.SerializedName;


class LacunaSignerApiSignatureCompleteSignatureRequest {

	@SerializedName("signature")
=======
public class CompleteSignatureRequest {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/requests/CompleteSignatureRequest.java
	private byte[] signature;
	private String token;

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
	