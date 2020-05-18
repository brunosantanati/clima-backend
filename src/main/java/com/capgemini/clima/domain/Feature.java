package com.capgemini.clima.domain;

import java.util.ArrayList;
import java.util.List;

public class Feature {
	
	private List<Float> center = new ArrayList<>();
	private String place_name;
	
	public List<Float> getCenter() {
		return center;
	}
	public void setCenter(List<Float> center) {
		this.center = center;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	@Override
	public String toString() {
		return "Feature [center=" + center + ", place_name=" + place_name + "]";
	}
	
}
