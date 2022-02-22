<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1> New Ninja</h1>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninja" class="form">
			<div>
				<form:label path="dojo" class="form-label">Dojo:</form:label>
				<form:select path="dojo" class="form-select">
					<c:forEach var="dojo" items="${dojos }">
						<option value="${dojo.id }">${dojo.name }</option>
					</c:forEach>
				</form:select>
			</div>
			
			<div>
				<form:label path="firstName" class="form-label">First Name :</form:label>
		        <form:input path="firstName" class="form-control" />
		        <form:errors path="firstName" class="text-danger" />
	        </div>
	        <div>
				<form:label path="lastName" class="form-label">Last Name :</form:label>
		        <form:input path="lastName" class="form-control" />
		        <form:errors path="lastName" class="text-danger" />
	        </div>
	        <div>
				<form:label path="age" class="form-label">Age :</form:label>
		        <form:input path="age" type="number" class="form-control" />
		        <form:errors path="age" class="text-danger" />
	        </div>
			<button class="btn btn-primary"> Create </button>
		</form:form>
	</div>
</body>
</html>