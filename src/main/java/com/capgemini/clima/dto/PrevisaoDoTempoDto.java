package com.capgemini.clima.dto;

public class PrevisaoDoTempoDto {
	
	private String temperaturaAtual;
	private String chancesDeChover;
	private String humidade;
	
	public String getTemperaturaAtual() {
		return temperaturaAtual;
	}
	public void setTemperaturaAtual(String temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
	}
	public String getChancesDeChover() {
		return chancesDeChover;
	}
	public void setChancesDeChover(String chancesDeChover) {
		this.chancesDeChover = chancesDeChover;
	}
	public String getHumidade() {
		return humidade;
	}
	public void setHumidade(String humidade) {
		this.humidade = humidade;
	}

}
