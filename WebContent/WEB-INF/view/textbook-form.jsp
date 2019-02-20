<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Προσθήκη Βιβλίου</h3>
 <form:form action="${pageContext.request.contextPath}/publisher/update/${idTextbook}" modelAttribute="textbook"  method="POST" class="ui form">
		<div class="field">
			<label>Τίτλος</label> 
			<form:input path="title"/>
		</div>
		<div class="field">
			<label>Συγγραφέας</label>
			<form:input path="writer"/>
		</div>
		<div class="field">
			<label>Έτος Έκδοσης</label> 
			<form:input path="year"/>
		</div>
		<div class="field">
			<label>Εκδοτικός Οίκος</label> 
			<form:input path="publishername"/>
		</div>
		<div class="Αριθμός ISBN">
			<label>ISBN</label> 
			<form:input path="isbn"/>
		</div>
		<button class="ui button" type="submit">Αποθήκευση</button>
	</form:form> 
</div>

 
