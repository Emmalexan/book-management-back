<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Προσθήκη Υπηρεσίας</h3>

 <form:form action="saveFunction/${functid}/${roleid}" modelAttribute="function" method="POST" class="ui form">
		<div class="field">
			<label>Όνομα Υπηρεσίας</label> 
			<form:input path="functionName"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
	
</div>