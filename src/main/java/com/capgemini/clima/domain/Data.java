package com.capgemini.clima.domain;

public class Data {
	
	private String summary;
	private float humidity;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Data [summary=" + summary + ", humidity=" + humidity + "]";
	}

}
