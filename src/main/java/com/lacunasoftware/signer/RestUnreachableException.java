package com.lacunasoftware.signer;

/**
 * Thrown to indicate that a REST request failed due to network-related issues.
 */
public class RestUnreachableException extends RestException {

	RestUnreachableException(String verb, String url, Exception innerException) {
		super(String.format("REST action %s %s unreachable", verb, url), verb, url, innerException);
	}
}