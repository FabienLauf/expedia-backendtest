# Expedia - Fabien LAUF - Software Dev Engineer II - Back-end test

## Running the application locally
```
	mvn tomcat7:run
```
Then, You can then access the application here: http://localhost:1337/weather/

## Compiling the application
```
	mvn clean install
```

## Compiling the application without the tests
```
	mvn clean install -Dmaven.test.skip=true
```

## Running the tests
```
	mvn test
```

## Looking for something in particular?

<table>
	<tr>
		<th>Module</th><th>Java</th><th>Configuration</th><th>Test</th>
	</tr>
	<tr>
		<td>Model</td>
		<td>
			<a href="/src/main/java/com/expedia/weather/model/Conditions.java">Conditions.java</a>
			<a href="/src/main/java/com/expedia/weather/model/CurrentObservation.java">CurrentObservation.java</a>
			<a href="/src/main/java/com/expedia/weather/model/DisplayLocation.java">DisplayLocation.java</a>
			<a href="/src/main/java/com/expedia/weather/model/ForecastForm.java">ForecastForm.java</a>
			<a href="/src/main/test/com/expedia/weather/model/validator/ForecastFormValidator.java">ForecastFormValidator.java</a>
		</td>
		<td>
		</td>
		<td>
			<a href="/src/main/test/com/expedia/weather/model/ConditionsTest.java">ConditionsTest.java</a>
			<a href="/src/main/test/com/expedia/weather/model/validator/ForecastFormValidatorTest.java">ForecastFormValidatorTest.java</a>
		</td>
	</tr>
	<tr>
		<td>Repository</td>
		<td>
			<a href="/src/main/java/com/expedia/weather/repository/IForecastRepository.java">IForecastRepository.java</a>
			<a href="/src/main/java/com/expedia/weather/repository/wunderground/ForecastWundergroundRepository.java">ForecastWundergroundRepository.java</a>
		</td>
		<td>
			<a href="/src/main/resources/spring/repository-config.xml">repository-config.xml</a>
		</td>
		<td>
			<a href="/src/main/test/com/expedia/weather/repository/mock/ForecastWundergroundRepositoryMock.java">ForecastWundergroundRepositoryMock.java</a>
		</td>
	</tr>
	<tr>
		<td>Service</td>
		<td>
			<a href="/src/main/java/com/expedia/weather/service/IForecastService.java">IForecastService.java</a>
			<a href="/src/main/java/com/expedia/weather/service/ForecastServiceImpl.java">ForecastServiceImpl.java</a>
		</td>
		<td>
			<a href="/src/main/resources/spring/service-config.xml">service-config.xml</a>
		</td>
		<td>
			<a href="/src/main/test/com/expedia/weather/service/ForecastServiceWundergroundTest.java">ForecastServiceWundergroundTest.java</a>
		</td>
	</tr>
	<tr>
		<td>Controller</td>
		<td>
			<a href="/src/main/java/com/expedia/weather/web/ForecastFormController.java">ForecastFormController.java</a>
			<a href="/src/main/webapp/WEB-INF/freemarker/forecastForm.ftl">forecastForm.ftl</a>
		</td>
		<td>
			<a href="/src/main/resources/mvc-servlet.xml">mvc-servlet.xml</a>
			<a href="/src/main/resources/spring/i18n-config.xml">i18n-config.xml</a>
			<a href="/src/main/resources/messages.properties">messages.properties</a>
		</td>
		<td>
			<a href="/src/main/test/com/expedia/weather/web/ForecastFormControllerTest.java">ForecastFormControllerTest.java</a>
		</td>
	</tr>
</table>


