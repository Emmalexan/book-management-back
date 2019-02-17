<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div id="ui segment">
<sec:authorize access="hasRole('STUDENT')">	
		<div id="header">
			<h3>Το Προφίλ Μου</h3>
		</div>
		<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
					<th>Department</th>
					<th>A.M.</th>
					<th>Semester</th>
					<th>Role</th>
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						
						<td>${user.student.departmentName}</td>
						<td>${user.student.passNumber}</td>
						<td>${user.student.semesterNum}</td>
						<td>${user.authoritie.authority}</td>
						
						
						
					</tr>
					
			</table>
			<br>
			<a href="<c:url value="/firstPage"></c:url>">OK</a>
</sec:authorize>
<sec:authorize access="hasRole('TEACHER')">	
<div id="header">
			<h3>Το Προφίλ Μου</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
					<th>Working State</th>
					<th>Department</th>
					<th>Year of Recruitment</th>
					<th>Field of Study</th>
					<th>Role</th>
				</tr>


					<tr>	
						<td>${user.userName}</td>
						
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						
						<td>${user.teacher.workingState}</td>
						<td>${user.teacher.departmentName}</td>
						<td>${user.teacher.yearOfRecruitment}</td>
						<td>${user.teacher.fieldOfStudy}</td>
						<td>${user.authoritie.authority}</td>
						
					</tr>
					
			</table>
			<br>
			<a href="<c:url value="/firstPage"></c:url>">OK</a>
</sec:authorize>
<sec:authorize access="hasRole('SECRETARY')">	
<div id="header">
			<h3>Το Προφίλ Μου</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
					<th>Working State</th>
					<th>Department</th>
					<th>Year of Recruitment</th>
					<th>Role</th>
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						
						<td>${user.secretary.workingState}</td>
						<td>${user.secretary.departmentName}</td>
						<td>${user.secretary.yearOfRecruitment}</td>
						<td>${user.authoritie.authority}</td>
						
						
					</tr>
					
			</table>
			<br>
			<a href="<c:url value="/firstPage"></c:url>">OK</a>
</sec:authorize>	
<sec:authorize access="hasRole('ADMIN')">
<div id="header">
			<h3>Το Προφίλ Μου</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
				</tr>


				<tr>	
						<td>${user.userName}</td>
						
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
				
				</tr>
				
			</table>
			<br>
			<a href="<c:url value="/firstPage"></c:url>">OK</a>
	
</sec:authorize>
<sec:authorize access="hasRole('PUBLISHER')">
<div id="header">
		<div id="header">
			<h3>Το Προφίλ Μου</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
					<th>Publisher Name</th>
					<th>Role</th>
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						
						<td>${user.publisher.publisherName}</td>
						<td>${user.authoritie.authority}</td>
					</tr>
					
			</table>
			<br>
				 	<a href="<c:url value="/firstPage"></c:url>">OK</a>
</sec:authorize>				 	
		</div>
		