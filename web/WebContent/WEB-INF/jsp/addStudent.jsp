<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Add Student</title>
</head>
<body>
	<form:form action="addStud" method="post">
		Name : <form:input path="name" />
		<br />
		Marks : <form:input path="marks" />
		<br />
		Mobile : <form:input path="mobile" />
		<br />
		<input type=submit value=add>
	</form:form>
</body>
</html>