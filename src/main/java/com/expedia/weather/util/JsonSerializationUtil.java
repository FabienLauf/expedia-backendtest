package com.expedia.weather.util;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import com.expedia.weather.model.Conditions;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonSerializationUtil {

	public static Conditions serializeFromFile(String filePath) throws JsonParseException, JsonMappingException, IOException {
		Resource resource = new ClassPathResource(filePath);
		ObjectMapper mapper = new ObjectMapper();
		Conditions conditions = null;
		
		conditions = mapper.readValue(resource.getInputStream(), Conditions.class);
		       
		return conditions;
	}
	
	public static Conditions serializeFromUrl(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
		Conditions conditions = restTemplate.getForObject(url, Conditions.class);
	        
		return conditions;
	}
}
