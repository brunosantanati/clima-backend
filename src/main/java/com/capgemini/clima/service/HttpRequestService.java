package com.capgemini.clima.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

import com.capgemini.clima.domain.HttpRequestDados;
import com.capgemini.clima.domain.HttpResponseDados;
import com.capgemini.clima.factory.HttpClientFactory;

public abstract class HttpRequestService {
	
	protected String endpoint;
	protected HttpRequestDados requestDados;
	private HttpClient httpClient;
	protected HttpRequestBase request;
	protected HttpResponse response;

	public final HttpResponseDados executarRequest(String endpoint, HttpRequestDados requestDto) {
		
		this.endpoint = endpoint;
		this.requestDados = requestDto;
		
		HttpResponseDados responseDto = null;
		
		try {
			
			criarHttpClient();
			
			prepararRequest();
			
			adicionarHeaders();
			
			adicionarPayload();
			
			executarRequest();
			
			responseDto = tratarResponse();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseDto;
	}
	
	protected void criarHttpClient() {
		this.httpClient = HttpClientFactory.criarHttpClient();
	}
	
	protected abstract void prepararRequest();
	
	protected abstract void adicionarHeaders();
	
	protected void adicionarPayload() {
		//Hook
	}
	
	protected void executarRequest() throws ClientProtocolException, IOException {
		this.response = this.httpClient.execute(this.request);
	}
	
	protected HttpResponseDados tratarResponse() throws Exception{
		return new HttpResponseDados();
	}

}
