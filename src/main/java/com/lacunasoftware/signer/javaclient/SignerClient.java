package com.lacunasoftware.signer.javaclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import com.lacunasoftware.signer.DocumentDownloadTypes;
import com.lacunasoftware.signer.TicketModel;
import com.lacunasoftware.signer.DocumentTicketType;
import com.lacunasoftware.signer.documents.*;
import com.lacunasoftware.signer.invoices.UpdateInvoicePaymentStatusRequest;
import com.lacunasoftware.signer.javaclient.params.DocumentListParameters;
import com.lacunasoftware.signer.notifications.CreateFlowActionReminderRequest;
import com.lacunasoftware.signer.folders.FolderInfoModel;
import com.lacunasoftware.signer.folders.FolderCreateRequest;
import com.lacunasoftware.signer.javaclient.responses.PaginatedSearchResponse;
import com.lacunasoftware.signer.javaclient.responses.CompleteSignatureResponse;
import com.lacunasoftware.signer.javaclient.responses.StartSignatureResponse;
import com.lacunasoftware.signer.javaclient.folders.FolderDetailsModel;
import com.lacunasoftware.signer.javaclient.models.UploadModel;
import com.lacunasoftware.signer.javaclient.params.PaginatedSearchParams;
import com.lacunasoftware.signer.javaclient.exceptions.RestException;
import com.lacunasoftware.signer.javaclient.requests.ElectronicSignatureRequest;
import com.lacunasoftware.signer.javaclient.requests.SendElectronicSignatureAuthenticationRequest;
import com.lacunasoftware.signer.javaclient.requests.StartSignatureRequest;
import com.lacunasoftware.signer.javaclient.requests.CompleteSignatureRequest;
import org.threeten.bp.OffsetDateTime;

public class SignerClient {
    protected String apiKey;
	protected URI endpointUri;
    protected RestClient restClient;
    
    public SignerClient(String endpointUri, String apiKey) throws URISyntaxException {
		this(new URI(endpointUri), apiKey);
    }
    
    public SignerClient(URI endpointUri, String apiKey) {
		this.endpointUri = endpointUri;
		this.apiKey = apiKey;
    }
    
    private RestClient getRestClient() {
		if (restClient == null) {
			restClient = new RestClient(endpointUri, apiKey);
		}
		return restClient;
	}

	// region SHARED

	public ObjectMapper getJackson() {
		return getRestClient().getJackson();
	}

	public Gson getGson() {
		return getRestClient().getGson();
	}
	public byte[] getFile(TicketModel ticket) throws RestException {
		return getRestClient().get(ticket.getLocation(), byte[].class);
	}

	public UploadModel uploadFile(String name, byte[] file, String mimeType) throws IOException, RestException {
		UploadModel model;
		try (ByteArrayInputStream stream = new ByteArrayInputStream(file)) {
			model = uploadFile(name, stream, mimeType);
		}
		return model;
	}

	public UploadModel uploadFile(String name, InputStream fileStream, String mimeType) throws RestException {
		return getRestClient().postMultipart("/api/uploads", fileStream, name, mimeType, UploadModel.class);
	}

	// endregion

	// region DOCUMENT

	@SuppressWarnings("unchecked")
	public List<CreateDocumentResult> createDocument(CreateDocumentRequest request) throws RestException {
		List<CreateDocumentResult> result = (List<CreateDocumentResult>)getRestClient().post("/api/documents", request, TypeToken.getParameterized(List.class, CreateDocumentResult.class));
		return result;
	}
	
	public void deleteDocument(UUID id) throws RestException {
		String requestUri = String.format("api/documents/%s", id.toString());
		getRestClient().delete(requestUri);
	}

	public DocumentModel getDocumentDetails(UUID id) throws RestException {
		String requestUri = String.format("api/documents/%s", id.toString());
		DocumentModel document = getRestClient().get(requestUri, DocumentModel.class);
		return document;
	}

	public TicketModel getDocumentDownloadTicket(UUID id, DocumentTicketType type) throws RestException {
		String requestUri = String.format("/api/documents/%s/ticket?type=%s", id.toString(), type.getValue());
		TicketModel ticket = getRestClient().get(requestUri, TicketModel.class);
		return ticket;
	}

	/**
	 *
	 *	This method does not use the new patterns to retrieve a document
	 * @deprecated use {@link #getDocumentContent} instead.
	 */
	@Deprecated
	public InputStream getDocument(UUID id, DocumentTicketType type) throws RestException {
		TicketModel ticket = getDocumentDownloadTicket(id, type);
		return getRestClient().getStream(ticket.getLocation());
	}


	public  InputStream getDocumentContent(UUID id, DocumentDownloadTypes type) throws RestException {
		String requestUri = String.format("/api/documents/%s/content?type=%s", id.toString(), type.getValue());
		InputStream documento = getRestClient().getStreamV2(requestUri);
		return documento;
	}


	public byte[] getDocumentBytes(UUID id, DocumentTicketType type) throws IOException, RestException {
		byte[] content;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (InputStream stream = getDocument(id, type)) {
				int nRead;
				byte[] data = new byte[1];
				while((nRead = stream.read(data, 0, data.length)) != -1) {
					baos.write(data, 0, nRead);
				}
				content = baos.toByteArray();
			}
		}
		return content;
	}

	// endregion

	// region ACTIONURL

	public ActionUrlResponse getActionUrl(UUID documentId, ActionUrlRequest request) throws RestException {
		String requestUri = String.format("/api/documents/%s/action-url", documentId.toString());
		ActionUrlResponse response = getRestClient().post(requestUri, request, ActionUrlResponse.class);
		return response;
	}

	// endregion

	// region SIGNATURE

	public StartSignatureResponse startPublicSignature(String key, StartSignatureRequest request) throws RestException {
		String requestUri = String.format("/api/documents/keys/%s/signature/certificate", key);
		StartSignatureResponse response = getRestClient().post(requestUri, request, StartSignatureResponse.class);
		return response;
	}

	public CompleteSignatureResponse completePublicSignature(String key, CompleteSignatureRequest request) throws RestException {
		String requestUri = String.format("/api/documents/keys/%s/signature", key);
		CompleteSignatureResponse response = getRestClient().post(requestUri, request, CompleteSignatureResponse.class);
		return response;
	}

	public StartSignatureResponse startSignature(UUID id, StartSignatureRequest request) throws RestException {
		String requestUri = String.format("/api/documents/%s/signature/certificate", id.toString());
		StartSignatureResponse response = getRestClient().post(requestUri, request, StartSignatureResponse.class);
		return response;
	} 

	public CompleteSignatureResponse completeSignature(UUID id, CompleteSignatureRequest request) throws RestException {
		String requestUri = String.format("/api/documents/%s/signature", id.toString());
		CompleteSignatureResponse response = getRestClient().post(requestUri, request, CompleteSignatureResponse.class);
		return response;
	}

	public void sendElectronicSignatureAuthenticationCode(SendElectronicSignatureAuthenticationRequest request) throws RestException {
		getRestClient().post("/api/documents/sms-authentication-code", request);
	}

	public void signElectronically(UUID id, ElectronicSignatureRequest request) throws RestException {
		String requestUri = String.format("/api/documents/%s/electronic-signature", id.toString());
		getRestClient().post(requestUri, request);
	}
	
	// endregion

	// region FOLDER

	public FolderInfoModel createFolder(FolderCreateRequest request) throws RestException {
		FolderInfoModel folderInfo = getRestClient().post("api/folders", request, FolderInfoModel.class);
		return folderInfo;
	}
	
	public FolderDetailsModel getFolderDetails(UUID folderId) throws RestException {
		String requestUri = String.format("/api/folders/%s/details", folderId.toString());
		FolderDetailsModel folderDetails = getRestClient().get(requestUri, FolderDetailsModel.class);
		return folderDetails;
	}
	
	@SuppressWarnings("unchecked")
	public PaginatedSearchResponse<FolderInfoModel> listFoldersPaginated(PaginatedSearchParams searchParams, UUID organizationId) throws RestException {
		String orgIdStr = organizationId != null ? organizationId.toString() : "";
		String requestUri = String.format("/api/folders%s&organizationId=%s", buildSearchPaginatedParamsString(searchParams), orgIdStr);
		PaginatedSearchResponse<FolderInfoModel> model = (PaginatedSearchResponse<FolderInfoModel>)getRestClient().get(requestUri, TypeToken.getParameterized(PaginatedSearchResponse.class, FolderInfoModel.class));
		return model;
	}

	public PaginatedSearchResponse<DocumentListModel> listDocuments(DocumentListParameters searchParams) throws RestException {

		String requestUri = String.format("api/documents?%s", buildSearchDocumentListString(searchParams));
		PaginatedSearchResponse<DocumentListModel> model = (PaginatedSearchResponse<DocumentListModel>)getRestClient().get(requestUri, TypeToken.getParameterized(PaginatedSearchResponse.class, DocumentListModel.class));
		return model;
	}

	// endregion

	// region NOTIFICATIONS

	public void sendFlowActionReminder(UUID documentId, UUID flowActionId) throws RestException {	
		CreateFlowActionReminderRequest request = new CreateFlowActionReminderRequest();	
		request.setDocumentId(documentId);
		request.setFlowActionId(flowActionId);
		getRestClient().post("/api/notifications/flow-action-reminder", request);
	}


	public void UpdateInvoiceStatus(int id, UpdateInvoicePaymentStatusRequest request) throws RestException, IOException {
		 getRestClient().putAsJson(String.format("api/invoices/%s/payment", id), request);
	}

	// endregion

	// region PRIVATE

	private String buildSearchPaginatedParamsString(PaginatedSearchParams searchParams) {
		return String.format("?q=%s&limit=%s&offset=%s", getParameterOrEmpty(searchParams.getQ()), searchParams.getLimit(), searchParams.getOffset());
	}

	private String buildSearchDocumentListString(DocumentListParameters searchParams) {
		return String.format("IsConcluded=%s&OrganizationType=Normal&FolderType=Normal&FilterByDocumentType=False&Q=%s&Limit=%s&Offset=0&Order=%s", searchParams.getIsConcluded(), getParameterOrEmpty(searchParams.getQ()), searchParams.getLimit(), searchParams.getOrder());
	}

	private String getParameterOrEmpty(String parameter) {
		if (parameter == null || parameter.length() == 0) {
			return "";
		}

		try {
			return URLEncoder.encode(parameter, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	// endregion
}