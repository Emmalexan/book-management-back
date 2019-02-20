<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Προσθήκη Χαρακτηριστικών Καθηγητή</h3>

 <form:form action="${pageContext.request.contextPath}/user/saveDetailsTeacher/${username}/${tid}" modelAttribute="teacher" method="POST" class="ui form">
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
		<div class="field">
			<label>Τομέας Σπουδών</label> 
			<form:input path="fieldOfStudy"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
	
</div>
 