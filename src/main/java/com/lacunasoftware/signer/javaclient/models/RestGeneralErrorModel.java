package com.lacunasoftware.signer.javaclient.models;

import com.google.gson.annotations.SerializedName;

public class RestGeneralErrorModel {

	@SerializedName("message")
	private String message = null;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}