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

<form name="addUpdateEmployeeForm" action="<%=request.getContextPath()%>/s/saveEmployee" method="POST">
	<h1>Add Employee</h1>
	<p><label>First Name: </label><input type="text" name="firstName" value="" ></p>
	<p><label>Last Name: </label><input type="text" name="lastName" value="" ></p>
	<p><label>Department: </label>
		<select name="departmentIdSelection">
			<option value="no_selection">Select ...</option>
			<% for(Department dep : allDepartment) { %>
				<option value="<%=dep.getId()%>"><%=dep.getName()%></option>			
			<% } %>
		</select>
	</p>
	<br>
	<p><label>Dependant 1: </label><input type="text" name="dependantName1" value="" >
		<select name="dependant1Selection">
			<option value="<%=DependantType.SPOUSE.toString()%>"><%=DependantType.SPOUSE.toString()%></option>
			<option value="<%=DependantType.CHILD.toString()%>"><%=DependantType.CHILD.toString()%></option>
		</select>
	</p>
	<p><label>Dependant 2: </label><input type="text" name="dependantName2" value="" >
		<select name="dependant2Selection">
			<option value="<%=DependantType.SPOUSE.toString()%>"><%=DependantType.SPOUSE.toString()%></option>
			<option value="<%=DependantType.CHILD.toString()%>"><%=DependantType.CHILD.toString()%></option>
		</select>
	</p>
	<br>
	<input type="submit" name="submitButton" value="Create">
</form>

</body>
</html>