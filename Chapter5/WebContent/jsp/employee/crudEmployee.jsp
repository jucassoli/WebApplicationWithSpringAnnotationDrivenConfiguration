<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 5 - CRUD Employee</title>
</head>
<body>
	<h1>Employee</h1>
	<p>Add Employee: <a href="<%=request.getContextPath()%>/s/addEmployee">Click here</a></p>
	<p>Add Department: <a href="<%=request.getContextPath()%>/s/addDepartment">Click here</a></p>
	<p>List Employees: <a href="<%=request.getContextPath()%>/s/listEmployee">Click here</a></p>
	<p>List Departments: <a href="<%=request.getContextPath()%>/s/listDepartment">Click here</a></p>
</body>
</html>