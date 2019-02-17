<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

		<h3>Add Details for Secretary</h3>

 <form:form action="${pageContext.request.contextPath}/user/saveDetailsSecretary/${username}/${secid}" modelAttribute="secretary" method="POST" class="ui form">
		<div class="field">
			<label>Department</label> 
			<form:input path="departmentName"/>
		</div>
		<div class="field">
			<label>Working State</label>
			<form:input path="workingState"/>
		</div>
		<div class="field">
			<label>Year of recruitment</label> 
			<form:input path="yearOfRecruitment"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form> 
	
</div>
