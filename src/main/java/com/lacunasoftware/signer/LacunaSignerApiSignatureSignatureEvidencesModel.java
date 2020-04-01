package com.lacunasoftware.signer;


import com.google.gson.annotations.SerializedName;


class LacunaSignerApiSignatureSignatureEvidencesModel {

	@SerializedName("geolocation")
	private LacunaSignerApiSignatureGeolocationModel geolocation;

	public LacunaSignerApiSignatureGeolocationModel getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(LacunaSignerApiSignatureGeolocationModel geolocation) {
		this.geolocation = geolocation;
	}
}
