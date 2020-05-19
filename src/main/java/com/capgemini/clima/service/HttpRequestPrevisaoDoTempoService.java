package com.capgemini.clima.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.client.methods.HttpGet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.clima.domain.HttpResponseDados;
import com.capgemini.clima.domain.PrevisaoDoTempoDados;
import com.capgemini.clima.enums.HttpHeadersEnum;
import com.google.gson.Gson;

@Service("previsaoDoTempo")
@Scope("prototype")
public class HttpRequestPrevisaoDoTempoService extends HttpRequestService {
	
	Gson gson = new Gson();

	@Override
	protected void prepararRequest() {
		this.request = new HttpGet(this.endpoint);		
	}

	@Override
	protected void adicionarHeaders() {
		this.request.addHeader(HttpHeadersEnum.ACCEPT.get(), HttpHeadersEnum.APPLICATION_JSON.get());
	}
	
	@Override
	protected HttpResponseDados tratarResponse() throws Exception{
		
		HttpResponseDados responseDados = new HttpResponseDados();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.response.getEntity().getContent()));
		
		PrevisaoDoTempoDados previsaoDoTempoDados = gson.fromJson(reader, PrevisaoDoTempoDados.class);
		responseDados.addItem("previsaoDoTempoDados", previsaoDoTempoDados);
		
		return responseDados;
	}

}
