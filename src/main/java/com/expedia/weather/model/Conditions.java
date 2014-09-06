package com.expedia.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conditions {

	private CurrentObservation current_observation;

	public CurrentObservation getCurrent_observation() {
		return current_observation;
	}

	public void setCurrent_observation(CurrentObservation current_observation) {
		this.current_observation = current_observation;
	}
	
}
