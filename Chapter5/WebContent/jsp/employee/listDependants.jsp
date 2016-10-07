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
	Iterable<Dependant> depList = (Iterable<Dependant>) request.getAttribute("depList");
%>

	<h1>Dependants List:</h1><br>
	
	<%  for(Dependant dep : depList ) { %>
		Employee Name: <%=dep.getEmployee().getFirstName()%><br>
		Dependant Name: <%=dep.getName()%>,&nbsp; 	
		Type: <%=dep.getType()%><br>
	<br><br>		
	<%  } %>
	
</body>
</html>