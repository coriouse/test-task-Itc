<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>List</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>	
</head>
<body>



<script type="text/javascript">
$(document).ready(function() { 
	$("#csv").bind("click",function() {
		var type = $("option:selected").val();
		filterFigures(type);
		window.open("/itc/csv?type="+type);	       
		
	});	
	
	$("#json").bind("click",function() {
		var type = $("option:selected").val();		
		window.open("/itc/json?type="+type);	       
		filterFigures(type);
	}); 
}); 
	
	function filterFigures(type) {
		$("#list tr").removeAttr('style');
		$("#list td.figure").filter(function() {
		    return $(this, "td.figure").text() != type;    
		 }).closest("tr").css("display","none");
	}

        
       
</script>        

<h3>
	List of figures!  
</h3>

<p><a href="/itc">Upload</a></p>


<h3>Actions</h3>
<table id="result"> 
	<tr><td>
		<select name="types">
		    <c:forEach items="${combobox}" var="item">
		        <option value="${item}">${item}</option>
		    </c:forEach>
		</select> 
</td><td>
	<input id="csv" type="button" value="Download csv">
</td><td>
	<input id="json"  type="button" value="Download json">
</td></tr>
</table>

<br>

<hr>

<table id="list"> 
<tr><td>Type</td><td>Object</td></tr>
 <c:forEach var="f" items="${figures}">
 	<tr><td class="figure"><c:out value="${f.name}"/></td><td><c:out value="${f}"/></td></tr>
</c:forEach>
</table> 





</body>
</html>
