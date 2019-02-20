<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Πρόσθεσε ενα ρόλο</h3>

 <form:form action="${pageContext.request.contextPath}/authorities/saveRole" modelAttribute="role" method="POST" class="ui form">
		<div class="field">
			<label>Ρόλος</label> 
			<form:input path="authority"/>
		</div>
		
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
	
</div>