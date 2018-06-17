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
	
	Favourite Language:
	
	<!--  This can be assigned similarly to the country.See source code. -->
	<!--  Radio buttons enables you to select only one -->	
	<!--  On submit, Spring will call student.favoriteLanguage(....) -->
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" />
	PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby<form:radiobutton path="favoriteLanguage" value="Ruby" />
	
	<br><br>
	
	Operating systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux" />
	Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
	MS Windows<form:checkbox path="operatingSystems" value="MS Window" />
	
	<br><br>
	
	<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>