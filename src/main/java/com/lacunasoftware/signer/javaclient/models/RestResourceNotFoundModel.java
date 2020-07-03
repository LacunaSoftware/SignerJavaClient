package com.lacunasoftware.signer.javaclient.models;

import com.google.gson.annotations.SerializedName;

public class RestResourceNotFoundModel extends RestGeneralErrorModel {

	@SerializedName("resourceName")
	private String resourceName = null;

	@SerializedName("resourceId")
	private String resourceId = null;

	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}