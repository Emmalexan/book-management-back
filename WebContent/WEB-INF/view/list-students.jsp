<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="ui segment">
		<div id="header">
			<h3>Δηλώσεις Φοιτητών</h3>
		</div>
		<sec:authorize access="hasRole('PUBLISHER')">
		${message}				
	
        <form:form action="${pageContext.request.contextPath}/publisher/findStudent" method="POST">
        	<div></div><input name="passnum" type="text" /></div>
        
            <div><input type="submit" value="OK" /></div>
            
        </form:form>
        
       
        </sec:authorize>
			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					
					<th>Όνομα</th>
					<th>Επώνυμο</th>
					<th>Α.Μ.</th>
					
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">

					<tr>
						<sec:authorize access="hasRole('SECRETARY')">
							<td><a href="<c:url value="/secretary/studentProfile/${tempStudent.id}"></c:url>"> ΔΗΛΩΣΗ </a></td>	
						</sec:authorize>
						<td>${tempStudent.user.firstName}</td>	
						<td>${tempStudent.user.lastName}</td>
						<sec:authorize access="hasRole('SECRETARY')">
							 <td>${tempStudent.passNumber}</td>
						</sec:authorize>
							
						<sec:authorize access="hasRole('PUBLISHER')">
							<td><a href="<c:url value="/publisher/studentProfile/${tempStudent.id}"></c:url>">${tempStudent.passNumber}·</a></td>	
						</sec:authorize>
						
						
					</tr>
				</c:forEach>
			</table>
</div>