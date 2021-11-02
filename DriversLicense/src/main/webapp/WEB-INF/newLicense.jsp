<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>NEW LICENSE</h1>
			<form:form  action="/licenses" method="post" modelAttribute="form">
				<p>
			       	<form:label class="form-label" path="person">Person</form:label>
			        <form:errors path="person"/>
			        <form:select class="form-control" path="person">
			        	<c:forEach items="${persons}" var="person" >
			        		<option value="${person.id}">${person.firstName}</option>
			        	</c:forEach>
			        </form:select>
    			</p>
			
    			<p>
			       	<form:label class="form-label" path="state">State</form:label>
			        <form:errors path="state"/>
			        <form:input class="form-control" path="state"/>
    			</p>
    			<p>
			       	<form:label class="form-label" path="expirationDate">Expiration Date</form:label>
			        <form:errors path="expirationDate"/>
			        <form:input type= "date" class="form-control" path="expirationDate"/>
			 
    			</p>
    		
 
    
    			<button class="btn-btn-success">Create</button>
			</form:form> 
		</div>

	</body>
</html>