package com.expedia.weather.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expedia.weather.model.Conditions;
import com.expedia.weather.model.ForecastForm;
import com.expedia.weather.model.validator.ForecastFormValidator;
import com.expedia.weather.service.IForecastService;
import com.expedia.weather.service.exception.ZipNotFoundException;

@Controller
public class ForecastFormController {
	
	@Autowired
	private IForecastService forecastService;
	
	@RequestMapping(value = "/")
	public String home(Map<String, Object> model) {
		return "forecastForm";
	}
	
	@RequestMapping(value = "/forecast")
	public String processForecastForm(@ModelAttribute("form") ForecastForm form, BindingResult result,  Map<String, Object> model) {
		new ForecastFormValidator().validate(form, result);
		if (!result.hasErrors()) {
			try {
				Conditions conditions = forecastService.findConditionsByZipcode(form.getZip());
				model.put("conditions", conditions);
			} catch (ZipNotFoundException e) {
				result.rejectValue("zip", ForecastFormValidator.ERR_CODE_ZIP_NOTFOUND, ForecastFormValidator.ERR_CODE_ZIP_NOTFOUND);
			}
		}
		return "forecastForm";
	}
}
