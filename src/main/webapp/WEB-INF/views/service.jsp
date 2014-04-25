<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Test service</title>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>	
</head>
<body>
<script type="text/javascript">
$(document).ready(function() { 
	$("#test").bind("click",function() {		
		var points = $('#point').val();		
        $.ajax({
       	 url: "/itc/service?type=POINT&points="+points,
       	type: "POST",
     		 success: function(response){
     			alert(response.data);
      		},
       			error: function(e){
       			alert('Error: ' + e);
       		}
       });		
	});	
}); 
</script>

<h3>
	Servcie!  
</h3>

<p><a href="/itc">Back</a></p>

<br>

<textarea id="point" rows="20" cols="50">
<points>
	<point id="a">
		<x>0.0</x>
		<y>0.0</y>
		<z>0.0</z>
	</point>
	<point id="b">
		<x>10.0</x>
		<y>0.0</y>
		<z>10.0</z>
	</point>
</points>

</textarea>

<input id="test" type="button" value="Test!">

</body>
</html>
