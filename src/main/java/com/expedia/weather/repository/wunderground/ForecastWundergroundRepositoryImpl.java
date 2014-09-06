package com.expedia.weather.repository.wunderground;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.repository.IForecastRepository;
import com.expedia.weather.util.JsonSerializationUtil;

public class ForecastWundergroundRepositoryImpl implements IForecastRepository {

	private String fileUrl;
	private String key;
	
	@Override
	public Conditions findConditionsByZipcode(String zip) {
		String urlToCall = String.format(this.fileUrl, this.key, zip);
		Conditions conditions = JsonSerializationUtil.serializeFromUrl(urlToCall);
		return conditions;
	}
	
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}	
	
}
