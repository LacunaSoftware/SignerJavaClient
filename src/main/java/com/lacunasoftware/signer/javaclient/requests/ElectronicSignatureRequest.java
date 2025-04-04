package com.lacunasoftware.signer.javaclient.requests;

import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.documentmark.DocumentMarkPositionModel;
import com.lacunasoftware.signer.javaclient.models.EvidencesModel;
import com.lacunasoftware.signer.javaclient.positions.PdfMarkPosition;
import com.lacunasoftware.signer.uploads.ImageUploadModel;
import com.lacunasoftware.signer.uploads.SignatureImageUploadModel;

public class ElectronicSignatureRequest {
	public enum AuthenticationTypes {
	@SerializedName("SMS")
	SMS("SMS"),
	@SerializedName("AuthenticationApp")
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

    @SerializedName("signaturePositions")
    private List<DocumentMarkPositionModel> signaturePositions;

    @SerializedName("signatureInitialsPositions")
    private List<DocumentMarkPositionModel> signatureInitialsPositions;

    @SerializedName("signatureImage")
    private SignatureImageUploadModel signatureImage;

    @SerializedName("initialsImage")
    private ImageUploadModel initialsImage;

    @SerializedName("smsCode")
    private String smsCode;

    @SerializedName("whatsappCode")
    private String whatsappCode;

    @SerializedName("otpCode")
    private String otpCode;

    @SerializedName("emailCode")
    private String emailCode;

    /**
     * The user's timezone offset in minutes, this is the timezone that will appear on the signature's visual representation.
     * This offset is the difference from UTC to the user's time, that is, if the user's timezone is UTC-3 this offset should be -180.
     */
    @SerializedName("userTimeZoneOffset")
    private Integer userTimeZoneOffset;

	@SerializedName("ticket")
	public String Ticket;

	@SerializedName("disableNotifications")
	public boolean DisableNotifications;

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

	public List<DocumentMarkPositionModel> getSignaturePositions() {
		return signaturePositions;
	}

	public void setSignaturePositions(List<DocumentMarkPositionModel> signaturePositions) {
		this.signaturePositions = signaturePositions;
	}

	public List<DocumentMarkPositionModel> getSignatureInitialsPositions() {
		return signatureInitialsPositions;
	}

	public void setSignatureInitialsPositions(List<DocumentMarkPositionModel> signatureInitialsPositions) {
		this.signatureInitialsPositions = signatureInitialsPositions;
	}

	public SignatureImageUploadModel getSignatureImage() {
		return signatureImage;
	}

	public void setSignatureImage(SignatureImageUploadModel signatureImage) {
		this.signatureImage = signatureImage;
	}

	public ImageUploadModel getInitialsImage() {
		return initialsImage;
	}

	public void setInitialsImage(ImageUploadModel initialsImage) {
		this.initialsImage = initialsImage;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getWhatsappCode() {
		return whatsappCode;
	}

	public void setWhatsappCode(String whatsappCode) {
		this.whatsappCode = whatsappCode;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public Integer getUserTimeZoneOffset() {
		return userTimeZoneOffset;
	}

	public void setUserTimeZoneOffset(Integer userTimeZoneOffset) {
		this.userTimeZoneOffset = userTimeZoneOffset;
	}

	public boolean isDisableNotifications() {
		return DisableNotifications;
	}

	public void setDisableNotifications(boolean disableNotifications) {
		DisableNotifications = disableNotifications;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	
}