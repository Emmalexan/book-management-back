<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

		<h3>Προσθήκη Στοιχείων Γραμματείας </h3>

 <form:form action="${pageContext.request.contextPath}/user/saveDetailsSecretary/${username}/${secid}" modelAttribute="secretary" method="POST" class="ui form">
		<div class="field">
			<label>Τμήμα</label> 
			<form:input path="departmentName"/>
		</div>
		<div class="field">
			<label>Κατάσταση Εργασίας</label>
			<form:input path="workingState"/>
		</div>
		<div class="field">
			<label>Έτος Πρόσληψης</label> 
			<form:input path="yearOfRecruitment"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
	
</div>
