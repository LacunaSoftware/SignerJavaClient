package com.lacunasoftware.signer.javaclient.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.ValidationResultsModel;

public class StartSignatureResponse {

	@SerializedName("success")
	@JsonProperty("success")
	private boolean success;

	@SerializedName("token")
	@JsonProperty("token")
	private String token;

	@SerializedName("toSignHash")
	@JsonProperty("toSignHash")
	private byte[] toSignHash;

	@SerializedName("digestAlgorithm")
	@JsonProperty("digestAlgorithm")
	private String digestAlgorithm;

	@SerializedName("validationResults")
	@JsonProperty("validationResults")
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