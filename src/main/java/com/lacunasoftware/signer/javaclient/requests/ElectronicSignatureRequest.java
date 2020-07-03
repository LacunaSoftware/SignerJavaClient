package com.lacunasoftware.signer.javaclient.requests;

import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.javaclient.models.EvidencesModel;
import com.lacunasoftware.signer.javaclient.positions.PdfMarkPosition;

import java.util.UUID;

<<<<<<< HEAD:src/main/java/com/lacunasoftware/signer/LacunaSignerApiSignatureElectronicSignatureRequest.java

class LacunaSignerApiSignatureElectronicSignatureRequest {
=======
public class ElectronicSignatureRequest {
>>>>>>> update/signer-java-client:src/main/java/com/lacunasoftware/signer/javaclient/requests/ElectronicSignatureRequest.java
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