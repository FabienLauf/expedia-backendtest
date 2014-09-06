/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expedia.weather.model.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.expedia.weather.model.ForecastForm;

/**
 * {@code Validator} for {@code ForecastForm}.
 *
 * @author Fabien Lauf
 */
public class ForecastFormValidator implements Validator {

	public static final String US_ZIPCODE_REGEXP = "[0-9]{5}";
	
	public static final String ERR_CODE_ZIP_NOTFOUND = "zip.notfound";
	public static final String ERR_CODE_ZIP_INVALID = "zip.invalid";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ForecastForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", ForecastFormValidator.ERR_CODE_ZIP_INVALID, ForecastFormValidator.ERR_CODE_ZIP_NOTFOUND);
		if(!errors.hasErrors()) {
			ForecastForm form = (ForecastForm) target;
			if (!Pattern.matches(ForecastFormValidator.US_ZIPCODE_REGEXP, form.getZip())) {
				errors.rejectValue("zip", ForecastFormValidator.ERR_CODE_ZIP_INVALID, ForecastFormValidator.ERR_CODE_ZIP_INVALID);
			}
		}
	}

}
