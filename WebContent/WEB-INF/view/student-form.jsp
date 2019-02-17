<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Add Details for Student</h3>

 <form:form action="${pageContext.request.contextPath}/user/saveDetailsStudent/${username}/${sid}" modelAttribute="student" method="POST" class="ui form">
		<div class="field">
			<label>Department</label> 
			<form:input path="departmentName"/>
		</div>
		<div class="field">
			<label>Pass number</label>
			<form:input path="passNumber"/>
		</div>
		<div class="field">
			<label>Current semester</label> 
			<form:input path="semesterNum"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form> 
</div>  
