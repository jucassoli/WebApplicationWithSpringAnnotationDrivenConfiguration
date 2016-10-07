<%@page import="com.wasadc.domain.DependantType"%>
<%@page import="com.wasadc.domain.Department"%>
<%@page import="com.wasadc.domain.Dependant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 5 - Add Employee</title>
</head>
<body>

<%
	Iterable<Department> allDepartment = (Iterable<Department>) request.getAttribute("departments");
%>

<form name="addUpdateDepartmentForm" action="<%=request.getContextPath()%>/s/saveDepartment" method="POST">
	<h1>Add Department</h1>
	<p><label>Name: </label><input type="text" name="name" value="" ></p>
	<p><label>Description: </label><input type="text" name="desc" value="" ></p>
	<br>
	<input type="submit" name="submitButton" value="Create">
</form>

</body>
</html>