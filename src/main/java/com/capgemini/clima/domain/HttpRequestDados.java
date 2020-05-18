package com.capgemini.clima.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestDados {
	
	private Map<String, String> parametrosDaRequest = new HashMap<String, String>();
	
	public void addItem(String chave, String valor) {
		this.parametrosDaRequest.put(chave, valor);
	}
	
	public String getItem(String chave) {
		return this.parametrosDaRequest.get(chave);
	}

}
