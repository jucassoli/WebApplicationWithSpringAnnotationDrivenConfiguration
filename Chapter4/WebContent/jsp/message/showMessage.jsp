<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Message</title>
</head>
<body>

<script>

$("document").ready(function() {
	
	$.ajax({
		method: "GET",
		dataType: "json",
		url: '<%=request.getContextPath()%>/s/mymess',
		success: function(data) {
			$("#msgNameContainer").text(data.name);
			$("#msgMessageContainer").text(data.message);
			$("#msgNumberContainer").text(data.number);
		},
		cache: false
	});
	
});

</script>

<p>Message test</p>

<p>This is a message to <span id="msgNameContainer"></span>,
saying <span id="msgMessageContainer"></span> with the 
number <span id="msgNumberContainer"></span>
</p>

</body>
</html>