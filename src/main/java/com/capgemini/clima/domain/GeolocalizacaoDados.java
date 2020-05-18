package com.capgemini.clima.domain;

import java.util.ArrayList;
import java.util.List;

public class GeolocalizacaoDados {

	private List<Feature> features = new ArrayList<>();

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "GeolocalizacaoDados [features=" + features + "]";
	}

}