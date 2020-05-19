package com.capgemini.clima.domain;

public class PrevisaoDoTempoDados {
	
	private Daily daily;
	private Currently currently;

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}

	public Currently getCurrently() {
		return currently;
	}

	public void setCurrently(Currently currently) {
		this.currently = currently;
	}

	@Override
	public String toString() {
		return "PrevisaoDoTempoDados [daily=" + daily + ", currently=" + currently + "]";
	}

}
