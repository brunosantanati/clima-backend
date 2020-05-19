package com.capgemini.clima.domain;

public class Currently {
	
	private float temperature;
	private float precipProbability;
	
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getPrecipProbability() {
		return precipProbability;
	}
	public void setPrecipProbability(float precipProbability) {
		this.precipProbability = precipProbability;
	}
	@Override
	public String toString() {
		return "Currently [temperature=" + temperature + ", precipProbability=" + precipProbability + "]";
	}

}
