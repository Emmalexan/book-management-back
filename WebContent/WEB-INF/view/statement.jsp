<sec:authorize access="hasRole('STUDENT')">	
<div id="wrapper">
	<div id="header">
		<h3>Η Δήλωσή Μου</h3>
		
	</div>
</div>

<div id="ui segment">
	<div id="content">
		<!--  add our html table here -->
		<table class="ui celled  striped table">
				
			<tr>
				<th>Σύγγραμμα</th>
				<th>Σημείο Παράδοσης</th>
				<th>Παραλήφθηκε</th>
			
			</tr>	
			
			
			<c:forEach var="tempProfileBook" items="${texbookprofiles}">	
				<tr>	
						<td>${tempProfileBook.textbook.title}</td>
						<td>${tempProfileBook.textbook.receivingPoint}</td>
					<c:if test="${tempProfileBook.confirmationReceived == false}">	
						<td>οχι</td>
					</c:if>	
					<c:if test="${tempProfileBook.confirmationReceived == true}">	
						<td>ναι</td>
					</c:if>
						</tr>
			</c:forEach>
			
			
		</table>
		<form action="${pageContext.request.contextPath}/firstPage" method="get">
			<input value="OK" type="submit">
		</form>

	</div>
</div>
</sec:authorize>
<sec:authorize access="hasRole('TEACHER')">	<div id="wrapper">
	<div id="header">
		<h3>Τα Συγγράμματα Μου</h3>
		
	</div>
</div>

<div id="ui segment">
	<div id="content">
		<!--  add our html table here -->
		<table class="ui celled  striped table">
			<h4>${course.title}</h4>
			<tr>
				<th>Συγγράμματα</th>
			</tr>
				
			<c:forEach var="tempTextbook" items="${ex_books}">
				<tr>
					<td>${tempTextbook.title}</td>
					
				</tr>
			</c:forEach>
			
		</table>
		<form action="${pageContext.request.contextPath}/teacher/<%=session.getAttribute("teacher_id")%>/view" method="get">
			<input value="OK" type="submit">
		</form>

	</div>
</div>


</sec:authorize>
