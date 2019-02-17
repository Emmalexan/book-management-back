<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Add a Textbook</h3>
 <form:form action="${pageContext.request.contextPath}/publisher/update/${idTextbook}" modelAttribute="textbook"  method="POST" class="ui form">
		<div class="field">
			<label>Title</label> 
			<form:input path="title"/>
		</div>
		<div class="field">
			<label>Writer</label>
			<form:input path="writer"/>
		</div>
		<div class="field">
			<label>Year of publishing</label> 
			<form:input path="year"/>
		</div>
		<div class="field">
			<label>Name of publisher</label> 
			<form:input path="publishername"/>
		</div>
		<div class="Number ISBN">
			<label>ISBN</label> 
			<form:input path="isbn"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form> 
</div>

 
