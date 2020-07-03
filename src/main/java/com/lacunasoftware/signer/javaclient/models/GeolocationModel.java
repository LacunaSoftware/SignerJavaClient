package com.lacunasoftware.signer.javaclient.models;

import com.google.gson.annotations.SerializedName;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureGeolocationModel.java

class LacunaSignerApiSignatureGeolocationModel {
=======
public class GeolocationModel {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/models/GeolocationModel.java

	@SerializedName("latitude")
	private Double latitude;

	@SerializedName("longitude")
	private Double longitude;

	@SerializedName("accuracy")
	private Double accuracy;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
}