<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="ui segment">
		<div id="header">
			<h3>Δηλώσεις Φοιτητών</h3> <br>
		</div>
		<sec:authorize access="hasRole('PUBLISHER')">
		${message}				
	
        <form:form action="${pageContext.request.contextPath}/publisher/findStudent" method="POST">
        	<div>Αριθμός Πάσου <input name="passnum" type="text" /> <input type="submit" value="OK" /></div>
        
            <br>
            
        </form:form>
        
       
        </sec:authorize>
			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<sec:authorize access="hasRole('SECRETARY')">
					<th>Όνομα</th>
					<th>Επώνυμο</th>
					<th>Αριθμός Πάσου</th>
					</sec:authorize>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">

					<tr>
						<sec:authorize access="hasRole('SECRETARY')">
							<td><a href="<c:url value="/secretary/studentProfile/${tempStudent.id}"></c:url>"> ΔΗΛΩΣΗ </a></td>	
						
							<td>${tempStudent.user.firstName}</td>	
							<td>${tempStudent.user.lastName}</td>
							<td>${tempStudent.passNumber}</td>
						</sec:authorize>
						
						<!-- <sec:authorize access="hasRole('PUBLISHER')">
							<c:forEach var="tempProfile" items="${textbookprofiles}">
							<c:if test="${tempProfile.student.id == tempStudent.id}">
							<c:if test="${tempProfile.textbook.publisher.id == pub_id}">
								<td>${tempStudent.user.firstName}</td>	
								<td>${tempStudent.user.lastName}</td>
								<td><a href="<c:url value="/publisher/studentProfile/${tempStudent.id}"></c:url>">${tempStudent.passNumber}·</a></td>	
							</c:if>
							</c:if>
							</c:forEach>
						</sec:authorize> -->
					</tr>
				</c:forEach>
			</table>
</div>