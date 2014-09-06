<#import "/spring.ftl" as spring />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Language" content="en-us" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Expedia - Fabien LAUF - Software Dev Engineer II - Back-end test</title>

</head>

<body>

<form action="<@spring.url '/forecast'/>" method="GET">
	<input name="zip" placeholder="Enter zipcode..." value="${(form.zip)!}" type="text" />
	<button type="submit">Submit</button>
	<#if (form.zip)?exists>
		<br/>
		<@spring.bind 'form.zip'/>
		<@spring.showErrors '<br/>' 'color: red;'/>
	</#if>
</form>

<#if (conditions.current_observation.display_location)?exists >
<div>
City: <span id="city">${(conditions.current_observation.display_location.city)!}</span><br/>
State: ${(conditions.current_observation.display_location.state_name)!}<br/>
Temperature: ${(conditions.current_observation.temp_f)!}&deg;F<br/>
</div>
</#if>

</body>
</html>