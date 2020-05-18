package com.capgemini.clima.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponseDados {
	
	private Map<String, Object> valoresDaResponse = new HashMap<String, Object>();
	
	public Object getItem(String chave){
		return this.valoresDaResponse.get(chave);
	}
	
	public void addItem(String chave, Object valor) {
		this.valoresDaResponse.put(chave, valor);
	}

}
