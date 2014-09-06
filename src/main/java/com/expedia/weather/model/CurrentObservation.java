package com.expedia.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservation {

	private Double temp_f;
	private DisplayLocation display_location;
	
	public Double getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(Double temp_f) {
		this.temp_f = temp_f;
	}
	
	public DisplayLocation getDisplay_location() {
		return display_location;
	}
	public void setDisplay_location(DisplayLocation display_location) {
		this.display_location = display_location;
	}
	
}
