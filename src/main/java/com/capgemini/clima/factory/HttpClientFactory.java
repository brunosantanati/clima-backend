package com.capgemini.clima.factory;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientFactory {
	
	public static HttpClient criarHttpClient() {
		
		HttpClientBuilder builder = HttpClientBuilder.create();
		
		return builder.build();
		
	}

}
