<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">
<form:form action="${pageContext.request.contextPath}/user/saveDetailsPublisher/${username}/${pid}" modelAttribute="publisher" method="POST" class="ui form">
		<div class="field">
			<label>Name of publisher</label> 
			<form:input path="publisherName"/>
		</div>
		
		<button class="ui button" type="submit">Save</button>
	</form:form> 
	
</div>