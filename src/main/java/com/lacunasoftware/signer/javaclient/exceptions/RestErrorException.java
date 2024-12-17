package com.lacunasoftware.signer.javaclient.exceptions;

/**
 * Thrown to indicate that a REST request returned an HTTP status code indicating error and possibly
 * a message, but no further information was returned.
 */
public class RestErrorException extends RestException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String errorMessage;
	private String errorCode;

	public RestErrorException(String verb, String url, int statusCode) {
		this(verb, url, statusCode, null, null);
	}

	public RestErrorException(String verb, String url, int statusCode, String errorCode) {
		this(verb, url, statusCode, null, errorCode);
	}
	
	public RestErrorException(String verb, String url, int statusCode, String errorMessage, String errorCode) {
		super(formatExceptionMessage(verb, url, statusCode, errorMessage, errorCode), verb, url);
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	private static String formatExceptionMessage(String verb, String url, int statusCode, String errorMessage, String errorCode) {
		StringBuilder message = new StringBuilder();
		message.append(String.format("REST action %s %s returned HTTP error %d", verb, url, statusCode));
		
		if (errorMessage != null) {
			message.append(String.format(": %s", errorMessage));
		}
		
		if (errorCode != null) {
			message.append(String.format(" (Error Code: %s)", errorCode));
		}
		
		return message.toString();
	}
	

	public int getStatusCode() {
		return statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
}