<!-- Entering the spring form tag library -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
	<title>Customer Registration Form</title>
	
	<!--  This is the styling bit for the css -->
	<style>
		.error{color:red}
	</style>
</head>

<body>

<i>Fill out the form. Asterik(*) means required.</i>
<br><br>
	<form:form action="processForm" modelAttribute="customer">
	First name:<form:input path="firstName" />
	
	<br><br>
	
	Last name(*):<form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />
	
	<br><br>
	Free passes:<form:input path="freePasses" />
	<form:errors path="freePasses" cssClass="error"/>
	
	<br><br>
	Postal Code:<form:input path="postalCode" />
	<form:errors path="postalCode" cssClass="error"/>
	
	
	<br><br>
	Course code:<form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error"/>
	
	<br><br>
	<input type="submit" value="Submit"/>
	<!--  value is the label that will appear in the submit button -->
	
	<br><br>
	</form:form>
</body>
</html>