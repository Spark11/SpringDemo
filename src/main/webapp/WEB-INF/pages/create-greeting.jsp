<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Greeting page</title>
</head>
<body>
	<form action=${pageContext.servletContext.contextPath}/mvc/greetings/create method="post">
		<table border="1">
			<tr>
				<td>Name:</td>
				<td><input id="name" name="name" type="text"/></td>
			</tr>
			<tr>
				<td>Message:</td>
				<td><input id="message" name="message" type="text"/></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Add</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>