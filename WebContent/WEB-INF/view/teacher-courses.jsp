
<div id="wrapper">
	<div id="header">
		<h2>Τα μαθηματά μου</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<!--  add our html table here -->
		<table>
			

			<!-- loop over and print our customers -->
			<c:forEach var="tempCourses" items="${courses}">

				<c:if test="${tempCourses.teacher.id == teacher.id}">

					<tr>
						
					<td><a href="<c:url value="/teacher/selectcourse_textbooks/${tempCourses.id}"></c:url>">${tempCourses.title}</a></td>
						
					</tr>

				</c:if>


			</c:forEach>


		</table>
		
		<br><br>
		<form action="${pageContext.request.contextPath}/firstPage" method="get">
			<input value="ΟΚ" type="submit">
		</form>
	</div>
</div>