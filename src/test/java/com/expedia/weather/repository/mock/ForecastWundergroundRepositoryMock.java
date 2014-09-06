package com.expedia.weather.repository.mock;

import org.springframework.stereotype.Repository;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.repository.IForecastRepository;
import com.expedia.weather.util.JsonSerializationUtil;

@Repository
public class ForecastWundergroundRepositoryMock implements IForecastRepository {

	@Override
	public Conditions findConditionsByZipcode(String zip) {
		Conditions conditions = null;
		try {
			conditions = JsonSerializationUtil.serializeFromFile(String.format("%s.json", zip));
		} catch (Exception e) {}
		return conditions;
	}
		
}
