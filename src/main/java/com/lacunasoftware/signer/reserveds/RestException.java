package com.lacunasoftware.signer.reserveds;

/**
 * Base class for exceptions thrown when calling a REST API.
 */
public abstract class RestException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String verb;
	private String url;

	RestException(String message, String verb, String url) {
		this(message, verb, url, null);
	}

	RestException(String message, String verb, String url, Exception innerException) {
		super(message, innerException);
		this.verb = verb;
		this.url = url;
	}

	/**
	 * Returns the verb used to perform the request.
	 * @return The verb (GET, POST, PUT or DELETE).
	 */
	public String getVerb() {
		return verb;
	}

	/**
	 * Returns the URL of the request.
	 * @return The absolute URL of the request.
	 */
	public String getUrl() {
		return url;
	}
}