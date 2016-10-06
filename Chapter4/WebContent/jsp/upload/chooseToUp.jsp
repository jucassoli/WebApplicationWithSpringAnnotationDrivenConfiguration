<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload file test</title>
</head>
<body>

<form name="sendFileForm" action="<%=request.getContextPath()%>/s/save" 
	method="post" enctype="multipart/form-data">
	
	<p>File:<input type="file" name="file" ></p><br><br>
	<p>Comment: <input type="text" name="comment" value=""></p>
	<p><input type="submit" name="submitMyFile" value="Send"></p>
</form>

</body>
</html>