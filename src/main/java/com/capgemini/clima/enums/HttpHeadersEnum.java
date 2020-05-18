package com.capgemini.clima.enums;

public enum HttpHeadersEnum {
	
	CONTENT_TYPE("content-type"),
	ACCEPT("Accept"),
	APPLICATION_JSON("application/json");
	
	private String header;
	
	HttpHeadersEnum(String header){
		this.header = header;
	}
	
	public String get() {
		return this.header;
	}

}
