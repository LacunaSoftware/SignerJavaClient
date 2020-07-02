package com.lacunasoftware.signer.reserveds;

import com.google.gson.annotations.SerializedName;

public class EvidencesModel {

	@SerializedName("geolocation")
	private GeolocationModel geolocation;

	public GeolocationModel getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeolocationModel geolocation) {
		this.geolocation = geolocation;
	}
}