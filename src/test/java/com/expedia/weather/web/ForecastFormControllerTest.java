package com.expedia.weather.web;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-mvc-context.xml"})
public class ForecastFormControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    
    @Test
    public void getWeatherHome() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/").accept(MediaType.TEXT_HTML));
        actions.andExpect(status().isOk());
        actions.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
    
    @Test
    public void getWeatherForecast() throws Exception {
    	ResultActions actions = this.mockMvc.perform(get("/forecast?zip=94117").accept(MediaType.TEXT_HTML));
        actions.andExpect(status().isOk());
        actions.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
        actions.andExpect(model().attributeExists("conditions"));
        actions.andExpect(model().attribute("conditions", hasProperty("current_observation", hasProperty("display_location", hasProperty("city", is("San Francisco"))))));
    }
    
    @Test
    public void getZipNotFound() throws Exception {
    	ResultActions actions = this.mockMvc.perform(get("/forecast?zip=99999").accept(MediaType.TEXT_HTML));
        actions.andExpect(status().isOk());
        actions.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
        actions.andExpect(model().attributeDoesNotExist("conditions"));
    }
}
