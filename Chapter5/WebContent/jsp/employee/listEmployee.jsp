<%@page import="com.wasadc.domain.Dependant"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wasadc.domain.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 5</title>
</head>
<body>
<%
	Iterable<Employee> employeeList = (Iterable<Employee>) request.getAttribute("mylist");
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
%>

	<h1>Employee List:</h1><br>
	
	<%  for(Employee emp : employeeList ) { %>
		First Name: <%=emp.getFirstName()%><br>	
		Last Name: <%=emp.getLastName()%><br>
		
		<% if(emp.getHireDate()!=null) { %>
			Hired at: <%=sdf.format(emp.getHireDate().getTime())%><br>
		<% } %>
		
		<% if(emp.getDepartment()!=null) { %>
			Department: <%=emp.getDepartment().getName()%><br>
		<% } %>
		
		<a href="<%=request.getContextPath()%>/s/listDependants?employeeId=<%=emp.getId()%>">List Dependants</a><br>
		
		<a href="<%=request.getContextPath()%>/s/deleteEmployee?employeeId=<%=emp.getId()%>">Delete</a>
		<br><br>
	<%  } %>
	${emp.firstName}
	
</body>
</html>