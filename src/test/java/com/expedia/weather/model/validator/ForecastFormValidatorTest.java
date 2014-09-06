package com.expedia.weather.model.validator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.expedia.weather.model.ForecastForm;
import com.expedia.weather.model.validator.ForecastFormValidator;

public class ForecastFormValidatorTest {
	
    @Test
    public void supports() {
    	Validator forecastFormValidator = new ForecastFormValidator();
    	Assert.assertTrue(forecastFormValidator.supports(ForecastForm.class));
    	Assert.assertFalse(forecastFormValidator.supports(Object.class));
    }

    @Test
    public void zipIsProvidedAndValid() {
    	Validator forecastFormValidator = new ForecastFormValidator();
    	ForecastForm form = new ForecastForm();
    	form.setZip("90210"); //Beverly Hills
    	Errors errors = new BindException(form, "form");
        ValidationUtils.invokeValidator(forecastFormValidator, form, errors);
        Assert.assertFalse(errors.hasErrors());
    }
    
    @Test
    public void zipIsNotProvided() {
    	Validator forecastFormValidator = new ForecastFormValidator();
    	ForecastForm form = new ForecastForm();
    	form.setZip(null);
    	Errors errors = new BindException(form, "form");
    	ValidationUtils.invokeValidator(forecastFormValidator, form, errors);
    	Assert.assertTrue(errors.hasErrors());
    	
    	boolean zipHasError = errors.hasFieldErrors("zip");
    	Assert.assertTrue(zipHasError);
    	if(zipHasError) {
    		ForecastFormValidator.ERR_CODE_ZIP_INVALID.equalsIgnoreCase(errors.getFieldError("zip").getCode());
    	}
    }
    
    @Test
    public void zipIsInvalid() {
    	Validator forecastFormValidator = new ForecastFormValidator();
    	ForecastForm form = new ForecastForm();
    	form.setZip("whatever");
    	Errors errors = new BindException(form, "form");
        ValidationUtils.invokeValidator(forecastFormValidator, form, errors);
        Assert.assertTrue(errors.hasErrors());
       
        boolean zipHasError = errors.hasFieldErrors("zip");
    	Assert.assertTrue(zipHasError);
    	if(zipHasError) {
    		ForecastFormValidator.ERR_CODE_ZIP_INVALID.equalsIgnoreCase(errors.getFieldError("zip").getCode());
    	}
    }
}
