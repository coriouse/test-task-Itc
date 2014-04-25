<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Upload</title>
</head>
<body>
<h3>
	Upload! Main page!  
</h3>

<p><a href="/itc/testService">Test Web Service</a></p>

<br>

	<form method="post" enctype="multipart/form-data">
	  File:<input type="file" name="myfile"/>&nbsp;
	  <button type="submit">Upload</button>
	</form>

</body>
</html>
