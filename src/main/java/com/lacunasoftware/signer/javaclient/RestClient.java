package com.lacunasoftware.signer.javaclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParseException;
import com.lacunasoftware.signer.webhooks.WebhookModel;
import org.threeten.bp.OffsetDateTime;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import  java.lang.reflect.Type;

import com.lacunasoftware.signer.javaclient.exceptions.RestErrorException;
import com.lacunasoftware.signer.javaclient.exceptions.RestException;
import com.lacunasoftware.signer.javaclient.exceptions.RestUnreachableException;
import com.lacunasoftware.signer.javaclient.exceptions.RestDecodeException;
import com.lacunasoftware.signer.javaclient.exceptions.RestResourceNotFoundException;
import com.lacunasoftware.signer.javaclient.models.RestGeneralErrorModel;
import com.lacunasoftware.signer.javaclient.models.RestResourceNotFoundModel;

class RestClient {
	private URI endpointUrl;
	private String apiKey;

	RestClient(URI endpointUrl) {
		this.endpointUrl = endpointUrl;
	}

	RestClient(URI endpointUrl, String apiKey) {
		this.endpointUrl = endpointUrl;
		this.apiKey = apiKey;
	}

	<TResponse> TResponse get(String requestUri, Class<TResponse> valueType) throws RestException {
		return get(requestUri, TypeToken.get(valueType));
	}

	<TResponse> TResponse get(String requestUri, TypeToken<TResponse> typeReference) throws RestException {

		String verb = "GET";
		String requestUrl = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		try {

			URL url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(verb);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Api-Key", apiKey);

		} catch (Exception e) {
			throw new RestUnreachableException(verb, requestUrl, e);
		}
		checkResponse(verb, requestUrl, conn);

		TResponse response;
		try {
			response = readResponse(conn, typeReference);
		} catch (Exception e) {
			throw new RestDecodeException(verb, requestUrl, e);
		}

		conn.disconnect();
		return response;
	}

	/**
	 * This method does not use the new patterns of authentication
	 *
	 * @deprecated use {@link #getStreamV2} instead.
	 */
	@Deprecated
	public InputStream getStream(String requestUri) throws RestException {

		String verb = "GET";
		String url = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		try {

			URL urlObj = new URL(url);
			conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod(verb);

			return conn.getInputStream();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}
	}

	public InputStream getStreamV2(String requestUri) throws RestException {

		String verb = "GET";
		String url = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		try {

			URL ur = new URL(url);
			conn = (HttpURLConnection) ur.openConnection();
			conn.setRequestMethod(verb);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Api-Key", apiKey);

			return conn.getInputStream();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}
	}

	<TRequest> void post(String requestUri, TRequest request) throws RestException {
		post(requestUri, request, (TypeToken<?>) null);
	}

	<TRequest, TResponse> TResponse post(String requestUri, TRequest request, Class<TResponse> valueType) throws RestException {
		return post(requestUri, request, TypeToken.get(valueType));
	}

	<TRequest, TResponse> TResponse post(String requestUri, TRequest request, TypeToken<TResponse> typeReference) throws RestException {

		String verb = "POST";
		String requestUrl = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		try {

			URL url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(verb);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Api-Key", apiKey);
			conn.setDoOutput(true);

			OutputStream outStream = conn.getOutputStream();
			if (request != null) {
				String json = getJackson().writeValueAsString(request);
				outStream.write(json.getBytes("UTF-8"));
			}
			outStream.close();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, requestUrl, e);
		}
		checkResponse(verb, requestUrl, conn);

		TResponse response = null;
		try {
			if (typeReference != null) {
				response = readResponse(conn, typeReference);
			}
		} catch (Exception e) {
			throw new RestDecodeException(verb, requestUrl, e);
		}

		conn.disconnect();
		return response;
	}

	<TResponse> TResponse postMultipart(String requestUri, InputStream stream, String name, String mimeType, Class<TResponse> valueType) throws RestException {
		return postMultipart(requestUri, stream, name, mimeType, TypeToken.get(valueType));
	}

	<TResponse> TResponse postMultipart(String requestUri, InputStream stream, String name, String mimeType, TypeToken<TResponse> typeReference) throws RestException {

		String verb = "POST";
		String requestUrl = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		String crlf = "\r\n";
		String twoHyphens = "--";
		String boundary =  "*****" + System.currentTimeMillis() + "*****";

		try {

			URL url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestMethod(verb);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			conn.setRequestProperty("X-Api-Key", apiKey);

			DataOutputStream request = new DataOutputStream(conn.getOutputStream());
			request.writeBytes(twoHyphens + boundary + crlf);
			StringBuilder sb = new StringBuilder("Content-Disposition: form-data");
			if (name != null) {
				sb.append(String.format("; name=\"%s\"; filename=\"%s\"", name, name));
			}
			sb.append(crlf);
			request.write(sb.toString().getBytes("UTF-8"));

			if (mimeType != null) {
				request.writeBytes(String.format("Content-Type: %s; charset=UTF-8", mimeType) + crlf);
			}
			request.writeBytes(crlf);

			int nRead;
			byte[] data = new byte[16384]; // 16KB
			while ((nRead = stream.read(data, 0, data.length)) != -1) {
				request.write(data, 0, nRead);
			}

			request.writeBytes(crlf);

			if (name != null) {
				byte[] nameBytes = name.getBytes("UTF-8");
				request.writeBytes(twoHyphens + boundary + crlf);
				request.writeBytes("Content-Disposition: form-data; name=\"name\"" + crlf);
				request.writeBytes("Content-Type: text/plain; charset=UTF-8" + crlf);
				request.writeBytes(crlf);
				request.write(nameBytes);
				request.writeBytes(crlf);
			}

			if (mimeType != null) {
				request.writeBytes(twoHyphens + boundary + crlf);
				request.writeBytes("Content-Disposition: form-data; name=\"contentType\"" + crlf);
				request.writeBytes("Content-Type: text/plain; charset=UTF-8" + crlf);
				request.writeBytes(crlf);
				request.writeBytes(mimeType);
				request.writeBytes(crlf);
			}

			request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);

			request.flush();
			request.close();

		} catch (Exception e) {
			throw new RestUnreachableException(verb, requestUrl, e);
		}
		checkResponse(verb, requestUrl, conn);

		TResponse response = null;
		try {
			if (typeReference != null) {
				response = readResponse(conn, typeReference);
			}
		} catch (Exception e) {
			throw new RestDecodeException(verb, requestUrl, e);
		}

		conn.disconnect();
		return response;
	}


	<TRequest> void putAsJson(String requestUri, TRequest request) throws RestException, IOException {

		String verb = "PUT";
		String requestUrl = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;
		
		try {
			URL url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(verb);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Api-Key", apiKey);
			conn.setDoOutput(true);

			OutputStream outStream = conn.getOutputStream();
			if (request != null) {
				String json = getGson().toJson(request);
				outStream.write(json.getBytes());
			}
			outStream.close();
		} catch (Exception e) {
			throw new RestUnreachableException(verb, requestUrl, e);
		}
		checkResponse(verb, requestUrl, conn);
		conn.disconnect();

	}

	void delete(String requestUri) throws RestException {

		String verb = "DELETE";
		String requestUrl = resolveUrl(endpointUrl.toString(), requestUri);
		HttpURLConnection conn;

		try {

			URL url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(verb);
			conn.setRequestProperty("X-Api-Key", apiKey);

		} catch (Exception e) {
			throw new RestUnreachableException(verb, requestUrl, e);
		}
		checkResponse(verb, requestUrl, conn);

		conn.disconnect();
	}

	private void checkResponse(String verb, String url, HttpURLConnection conn) throws RestException {

		int statusCode;

		try {
			statusCode = conn.getResponseCode();
		} catch (Exception e) {
			throw new RestUnreachableException(verb, url, e);
		}

		if (statusCode < 200 || statusCode > 299) {

			RestException ex = null;

			try {

				if (statusCode == 404) {

					RestResourceNotFoundModel model = readErrorResponse(conn, RestResourceNotFoundModel.class);
					if (model != null) {
						if (model.getResourceName() != null && model.getResourceId() != null) {
							ex = new RestResourceNotFoundException(verb, url, model.getResourceName(), model.getResourceId());
						} else {
							ex = new RestErrorException(verb, url, statusCode, model.getMessage());
						}
					}

				} else if(statusCode == 400){
					Scanner scanner = new Scanner(conn.getErrorStream());
					String	errorBody = scanner.nextLine();
					ex = new RestErrorException(verb, url, statusCode, errorBody);
				}else {

					RestGeneralErrorModel model = readErrorResponse(conn, RestGeneralErrorModel.class);
					if (model != null && model.getMessage() != null) {
						ex = new RestErrorException(verb, url, statusCode, model.getMessage());
					}

				}

			} catch (Exception e) {
				// do nothing
				//throw new RuntimeException("Error decoding error", e);
			}

			if (ex == null) {
				ex = new RestErrorException(verb, url, statusCode);
			}
			throw ex;
		}
	}

	private <T> T readResponse(HttpURLConnection conn, TypeToken<T> typeToken) throws IOException {
		InputStream inStream = conn.getInputStream();
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(inStream, "UTF-8")); 
		T response = getGson().fromJson(streamReader, typeToken.getType());
		inStream.close();
		return response;
	}

	private <T> T readErrorResponse(HttpURLConnection conn, Class<T> valueType) throws IOException {
		InputStream inStream = conn.getErrorStream();
		T response = getGson().fromJson(readJsonStream(inStream), valueType);
		inStream.close();
		return response;
	}

	private String readJsonStream(InputStream stream) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(stream);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			sb.append(sc.nextLine());
		}
		sc.close();
		return new String(sb.toString().getBytes("UTF-8"));
	}

	private String resolveUrl(String endpoint, String path) {
		String processedEndpoint = endpoint.replaceAll("([/]*)$", "");
		String processedPath = path.replaceAll("^([/]*)", "");
		return processedEndpoint + "/" + processedPath;
	}

	protected Gson getGson() {

		Gson gson = new GsonBuilder()
			.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
			.create();
		return gson;
	}

	protected ObjectMapper getJackson(){

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);

		objectMapper.registerModule(new JavaTimeModule());

		SimpleModule simpleModule = new SimpleModule();
		simpleModule.registerSubtypes(WebhookModel.class);
		simpleModule.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
		simpleModule.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());
		objectMapper.registerModule(simpleModule);

		return objectMapper;
	}

	protected class OffsetDateTimeDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<OffsetDateTime> implements JsonDeserializer<OffsetDateTime> {
		@Override
		public OffsetDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			if (json == null) {
				return null;
			}
			// The java deserializer
			String dateString = json.getAsString();
			return OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}

		@Override
		public OffsetDateTime deserialize(JsonParser json, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			String dateString = json.getValueAsString();
			return OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}

	public class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime>
	{
		private final DateTimeFormatter ISO_8601_FORMATTER = DateTimeFormatter
				.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxx")
				.withZone(ZoneId.of("UTC"));

		@Override
		public void serialize(OffsetDateTime value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException
		{
			if (value == null) {
				throw new IOException("OffsetDateTime argument is null.");
			}

			jsonGenerator.writeString(ISO_8601_FORMATTER.format(value));
		}
	}
}