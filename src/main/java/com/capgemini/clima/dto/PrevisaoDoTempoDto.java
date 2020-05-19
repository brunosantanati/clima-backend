package com.capgemini.clima.dto;

public class PrevisaoDoTempoDto {
	
	private String resumo;
	private String temperaturaAtual;
	private String chancesDeChover;
	private String humidade;
	private String localizacao;
	private String endereco;
	
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
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
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
