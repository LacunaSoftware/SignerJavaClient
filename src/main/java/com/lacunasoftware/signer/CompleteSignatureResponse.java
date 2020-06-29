package com.lacunasoftware.signer;

public class CompleteSignatureResponse {
	private boolean success;
	private ValidationResultsModel validationResults;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ValidationResultsModel getValidationResults() {
		return validationResults;
	}

	public void setValidationResults(ValidationResultsModel validationResults) {
		this.validationResults = validationResults;
	}
}