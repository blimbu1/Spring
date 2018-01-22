<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName" />
	
	<br><br>
	Last name: <form:input path="lastName" />
	
	<br><br>
	Country: 
	<!-- Second way of selecting note the s at the end of option -->
	<form:select path="country" >
		<form:options items="${student.countryOptions }" />
	</form:select>
	<!-- First way of enabling drop down for country selection -->
	<!-- 
	<form:select path="country">
		<form:option value="BRA" label="Brasil" />
		<form:option value="FRA" label="France" />
		<form:option value="GER" label="Germany" />
		<form:option value="IND" label="India" />
	</form:select>
	 -->
	
	<br><br>
	
	<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>