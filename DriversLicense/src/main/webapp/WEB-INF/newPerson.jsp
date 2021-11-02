<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>NEW PERSON</h1>
<form:form  action="/persons/new" method="post" modelAttribute="form">
    <p>
        <form:label class="form-label" path="firstName">Name</form:label>
        <form:errors path="firstName"/>
        <form:input class="form-control" path="firstName"/>
    </p>
    <p>
       <form:label class="form-label" path="lastName">LastName</form:label>
        <form:errors path="lastName"/>
        <form:input class="form-control" path="lastName"/>
    </p>
 
    
    <input type="submit" class="btn btn-success" value="Create"/>
</form:form> 
</div>

</body>
</html>