package com.expedia.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.repository.IForecastRepository;
import com.expedia.weather.service.exception.ZipNotFoundException;

@Service
public class ForecastServiceImpl implements IForecastService {

	@Autowired
	private IForecastRepository forecastRepository;

	@Override
	public Conditions findConditionsByZipcode(String zip) throws ZipNotFoundException {
		Conditions conditions = this.forecastRepository.findConditionsByZipcode(zip);
		if(conditions==null || conditions.getCurrent_observation()==null) {
			throw new ZipNotFoundException();
		}
		return conditions;
	}
	
}
