<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Προσθήκη Λεπτομερειών Φοιτητή</h3>

 <form:form action="${pageContext.request.contextPath}/user/saveDetailsStudent/${username}/${sid}" modelAttribute="student" method="POST" class="ui form">
		<div class="field">
			<label>Τμήμα</label> 
			<form:input path="departmentName"/>
		</div>
		<div class="field">
			<label>Αριθμός Πάσου</label>
			<form:input path="passNumber"/>
		</div>
		<div class="field">
			<label>Τρέχον Εξάμηνο</label> 
			<form:input path="semesterNum"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
</div>  
