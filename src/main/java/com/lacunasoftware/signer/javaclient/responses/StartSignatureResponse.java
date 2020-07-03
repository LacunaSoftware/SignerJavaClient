package com.lacunasoftware.signer.javaclient.responses;

import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.ValidationResultsModel;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureStartSignatureResponse.java

class LacunaSignerApiSignatureStartSignatureResponse {
=======
public class StartSignatureResponse {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/responses/StartSignatureResponse.java

	@SerializedName("success")
	private boolean success;

	@SerializedName("token")
	private String token;

	@SerializedName("toSignHash")
	private byte[] toSignHash;

	@SerializedName("digestAlgorithm")
	private String digestAlgorithm;

	@SerializedName("validationResults")
	public ValidationResultsModel validationResults;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public byte[] getToSignHash() {
		return toSignHash;
	}

	public void setToSignHash(byte[] toSignHash) {
		this.toSignHash = toSignHash;
	}

	public String getDigestAlgorithm() {
		return digestAlgorithm;
	}

	public void setDigestAlgorithm(String digestAlgorithm) {
		this.digestAlgorithm = digestAlgorithm;
	}

	public ValidationResultsModel getValidationResults() {
		return validationResults;
	}

	public void setValidationResults(ValidationResultsModel validationResults) {
		this.validationResults = validationResults;
	}
}