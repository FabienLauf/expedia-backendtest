package com.expedia.weather.service;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.service.exception.ZipNotFoundException;

public interface IForecastService {

	public Conditions findConditionsByZipcode(String zip) throws ZipNotFoundException;
	
}
