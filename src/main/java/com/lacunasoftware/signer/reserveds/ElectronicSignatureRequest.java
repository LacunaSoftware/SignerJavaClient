package com.lacunasoftware.signer.reserveds;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class ElectronicSignatureRequest {
	public enum AuthenticationTypes {
		SMS("SMS"),
		AUTHENTICATION_APP("AuthenticationApp");

		private String value;

		AuthenticationTypes(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	@SerializedName("flowActionId")
	private UUID flowActionId;

	@SerializedName("signaturePosition")
	private PdfMarkPosition signaturePosition;

	@SerializedName("authenticationCode")
	private String authenticationCode;

	@SerializedName("authenticationType")
	private AuthenticationTypes authenticationType;

	@SerializedName("evidences")
	private EvidencesModel evidences;

	public UUID getFlowActionId() {
		return flowActionId;
	}

	public void setFlowActionId(UUID flowActionId) {
		this.flowActionId = flowActionId;
	}

	public PdfMarkPosition getSignaturePosition() {
		return signaturePosition;
	}

	public void setSignaturePosition(PdfMarkPosition signaturePosition) {
		this.signaturePosition = signaturePosition;
	}

	public String getAuthenticationCode() {
		return authenticationCode;
	}

	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}

	public AuthenticationTypes getAuthenticationType() {
		return authenticationType;
	}

	public void setAuthenticationType(AuthenticationTypes authenticationType) {
		this.authenticationType = authenticationType;
	}

	public EvidencesModel getEvidences() {
		return evidences;
	}

	public void setEvidences(EvidencesModel evidences) {
		this.evidences = evidences;
	}
}