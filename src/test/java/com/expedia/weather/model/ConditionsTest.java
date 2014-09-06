package com.expedia.weather.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import com.expedia.weather.util.JsonSerializationUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConditionsTest {
		
	@Test
	public void serializationTest() throws JsonParseException, JsonMappingException, IOException {
		Conditions conditions = JsonSerializationUtil.serializeFromFile("94117.json");
		Assert.assertNotNull(conditions);
		if(conditions != null) {
			Assert.assertFalse(StringUtils.isEmpty(conditions.getCurrent_observation().getDisplay_location().getState_name()));
			Assert.assertFalse(StringUtils.isEmpty(conditions.getCurrent_observation().getDisplay_location().getCity()));
			Assert.assertFalse(StringUtils.isEmpty(conditions.getCurrent_observation().getTemp_f()));
			Assert.assertFalse(StringUtils.isEmpty(conditions.getCurrent_observation().getDisplay_location().getZip()));
		}
	}
}
