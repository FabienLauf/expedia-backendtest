package com.expedia.weather.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.service.exception.ZipNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
@DirtiesContext
public class ForecastServiceWundergroundTest {
	
	@Autowired
	private IForecastService forecastService;
	
	@Test
	public void findConditionsByZipcode() throws ZipNotFoundException {
		Conditions conditions = this.forecastService.findConditionsByZipcode("94117");
		Assert.assertNotNull(conditions);
	}
	
	@Test
	public void zipCodeNotFound() {
		Conditions conditions = null;
		try {
			conditions = this.forecastService.findConditionsByZipcode("99999");
		} catch (ZipNotFoundException e) {
			Assert.assertNotNull(e);
		}
		Assert.assertNull(conditions);
	}
}
