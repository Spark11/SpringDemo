<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Greetings page</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${greetings}" var="greeting">
			<tr>
				<td><c:out value="${greeting.id}" /></td>
				<td><c:out value="${greeting.name}" /></td>
				<td><c:out value="${greeting.message}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form action=${pageContext.servletContext.contextPath}/mvc/greetings/create method="get">
		<button type="submit">Add Greeting</button>
	</form>
</body>
</html>