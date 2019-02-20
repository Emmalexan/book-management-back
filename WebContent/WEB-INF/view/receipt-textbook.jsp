<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="ui segment">
	<div id="header">
	<sec:authorize access="hasRole('PUBLISHER')">	
		<h3>Παράδοση Συγγραμμάτων</h3>
		
		
	</sec:authorize>
	<sec:authorize access="hasRole('SECRETARY')">
		<h3>Κατάσταση Δήλωσης</h3>	
	</sec:authorize>
	</div>
				<sec:authorize access="hasRole('PUBLISHER')">	
				 	<a href="<c:url value="/publisher/students"></c:url>">Υπόλοιποι Φοιτητές</a> <br>
				 	<h4> Δήλωση Φοιτητή : ${student.user.firstName} ${student.user.lastName} με αριθμό πάσου : ${student.passNumber}</h4>
				 </sec:authorize>	
			<table class="ui celled  striped table">
				<tr>
					<th>Τίτλος Συγγράμματος</th>
					<th>Παραδόθηκε</th>
					
				</tr>
				
				<c:forEach var="tempTextBookProfile" items="${textbookprofiles}">
					<c:if test="${tempTextBookProfile.student.id == student.id}">
						<tr>
						
							<td>${tempTextBookProfile.textbook.title}</td>	
							
							<td> 	
							<c:if test="${tempTextBookProfile.confirmationReceived == true}">				
								Έχει παραδοθεί
							</c:if>

							<c:if test="${tempTextBookProfile.confirmationReceived == false}">	
					
					
					
<sec:authorize access="hasRole('PUBLISHER')">	
					   
					   <form action="${pageContext.request.contextPath}/publisher/confirmation/${stid}/${tempTextBookProfile.id}" method="get">
							<input value="Παράδοση" type="submit">
						</form>
					  
</sec:authorize>   
						
<sec:authorize access="hasRole('SECRETARY')">	
					   Δεν το έχει παραλάβει
</sec:authorize>
			</td>
			</tr>
					</c:if> 	 
				</c:if>
	
				</c:forEach>
				
			</table>


<sec:authorize access="hasRole('SECRETARY')">

	<p><a href="https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=el&service=mail#identifier">Αποστολή email</a></p>

	<br><br>
	<form action="${pageContext.request.contextPath}/secretary/studentStatement" method="get">
		<input value="Υπόλοιποι Φοιτητές" type="submit">
	</form>
</sec:authorize>

</div>
