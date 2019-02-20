<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="ui segment">

<h3>Add a User</h3>

 <form:form action="${pageContext.request.contextPath}/user/saveUser/${newUser}/${username}" modelAttribute="user" method="POST" class="ui form">
		<div class="field">
			<label>Username</label> 
			<form:input path="userName"/>
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="userPassword"/>
		</div>
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label> 
			<form:input path="lastName"/>
		</div>
		<div class="field">
			<label>Email</label> 
			<form:input path="email"/>
		</div>
		<div class="field">
			<label>Enabled</label> 
			<form:input path="enabled"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
	
</div>
 
 