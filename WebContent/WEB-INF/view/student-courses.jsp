
<div id="wrapper">
	<div id="header">
		<h3>Τα μαθηματά μου : Για το ${student.semesterNum} εξάμηνο</h3>
		
	</div>
</div>

<div id="container">
	<div id="content">
		<!--  add our html table here -->
		<table>
			

			<!-- loop over and print our customers -->
			<c:forEach var="tempCourses" items="${courses}">

				<c:if test="${tempCourses.semester == student.semesterNum}">

					<tr>
						
					<td><a href="<c:url value="/student/${student.id}/selectcourse_textbooks/${tempCourses.id}"></c:url>">${tempCourses.title}</a></td>
						
					</tr>

				</c:if>


			</c:forEach>

			
		</table>
		<br>
		<form action="${pageContext.request.contextPath}/student/selectedTextbooks/<%=session.getAttribute("student_id")%>" method="get">
				<input value="Συνέχεια" type="submit">
			</form>
	</div>
</div>