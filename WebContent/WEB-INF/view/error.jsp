 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
 
 <table class="ui celled  striped table">
 <form:form action="${pageContext.request.contextPath}/authorities/listrole" modelAttribute="role" method="get" class="ui form">
	<tr>
	<td>
		<div class="field">
			<h4>${message}</h4>
		</div>
		
		<button class="ui button" type="submit">OK</button>
	</tr>
	</td>
	</form:form> 
</table>