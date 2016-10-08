<%@page import="java.util.List"%>
<%@page import="com.wasadc.domain.Department"%>
<%@page import="com.wasadc.domain.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 5 - Departments</title>
</head>
<body>
<%
	List<Department> allDepartment = (List<Department>) request.getAttribute("allDepartment");
%>

	<h1>Departments List:</h1><br>
	
	<%  for(Department dep : allDepartment ) { %>
		Name: <%=dep.getName()%><br>
		Description: <%=dep.getDescript()%><br>
		<a href="<%=request.getContextPath()%>/s/deleteDepartment?departId=<%=dep.getId()%>">Delete</a>
	<br><br>
	<%  } %>
	
</body>
</html>