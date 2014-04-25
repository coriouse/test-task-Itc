<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
 
    <p><a href="/itc">Upload</a></p>
 
    <b>${name}</b>:  ${message}
 
</body>
</html>