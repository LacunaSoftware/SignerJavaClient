package com.lacunasoftware.signer;

import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    
    protected RestClient getRestClient() {
		if (restClient == null) {
			restClient = new RestClient(endpointUri, apiKey);
		}
		return restClient;
	}
}