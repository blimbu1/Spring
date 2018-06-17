<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Favourite Language:${student.favoriteLanguage}
<!--  Spring will call student.getFavoriteLanguage() method -->
<br><br>
Operating systems:

<!--  Creating a loop to display all values of operating system -->
<!--  different @taglib syntax used -->
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	<li> ${temp }</li>
	</c:forEach>
</ul>

</body>

</html>