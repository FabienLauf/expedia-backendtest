package com.expedia.weather.repository;

import com.expedia.weather.model.Conditions;

public interface IForecastRepository {

	public Conditions findConditionsByZipcode(String zip);

}