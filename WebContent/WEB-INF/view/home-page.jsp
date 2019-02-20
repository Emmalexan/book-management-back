<style>
		.link{
			display: block;

			text-align: center;
			padding: 5px;
			text-decoration: none; float:left;
             margin-right:10px; 
             background-color: #F2F2F2;
            
		}

		.link :hover {
			background-color:#6E6E6E;
		}
       
</style>

<div id="ui segment">
<sec:authorize access="hasRole('STUDENT')">	
		<div id="header">	
			<h3>Σελίδα Φοιτητή</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Department</th>
					<th>A.M.</th>
					<th>Semester</th>
					
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						<td>*******</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
						<td>${user.student.departmentName}</td>
						<td>${user.student.passNumber}</td>
						<td>${user.student.semesterNum}</td>
						
						
						
					</tr>
					
			</table>
			<br>
			<a class="link" href="<c:url value="/student/${user.student.id}"></c:url>">ΔΗΛΩΣΗ ΜΑΘΗΜΑΤΩΝ</a>
			<a class="link" href="<c:url value="/student/selectedTextbooks/${user.student.id}"></c:url>">Η ΔΗΛΩΣΗ ΜΟΥ</a>
</sec:authorize>
<sec:authorize access="hasRole('TEACHER')">	
<div id="header">
			<h3>Σελίδα Καθηγητή</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Working State</th>
					<th>Department</th>
					<th>Year of Recruitment</th>
					<th>Field of Study</th>
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						<td>*******</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
						<td>${user.teacher.workingState}</td>
						<td>${user.teacher.departmentName}</td>
						<td>${user.teacher.yearOfRecruitment}</td>
						<td>${user.teacher.fieldOfStudy}</td>
						
						
					</tr>
					
			</table>
			<br>
			<a class="link" href="<c:url value="/teacher/${user.teacher.id}/choose"></c:url>">ΕΠΙΛΟΓΗ ΣΥΓΓΡΑΜΜΑΤΩΝ</a>
			<a class="link" href="<c:url value="/teacher/${user.teacher.id}/view"></c:url>">Η ΔΗΛΩΣΗ ΜΟΥ</a>
</sec:authorize>
<sec:authorize access="hasRole('SECRETARY')">	
<div id="header">
			<h3>Σελίδα Γραμματείας</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Working State</th>
					<th>Department</th>
					<th>Year of Recruitment</th>
			
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						<td>*******</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
						<td>${user.secretary.workingState}</td>
						<td>${user.secretary.departmentName}</td>
						<td>${user.secretary.yearOfRecruitment}</td>
					
						
						
					</tr>
					
			</table>
			<br>
			<a class="link" href="<c:url value="/secretary/studentStatement"></c:url>">ΔΗΛΩΣΕΙΣ ΦΟΙΤΗΤΩΝ</a>	
</sec:authorize>	
<sec:authorize access="hasRole('ADMIN')">
<div id="header">
			<h3>Σελίδα Admin</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
				</tr>


				<tr>	
						<td>${user.userName}</td>
						<td>*******</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
				
				</tr>
				
			</table>
		
			<th><a class="link" href="<c:url value="/user/listuser"></c:url>">Χρήστες</a></th>
		    <th><a class="link" href="<c:url value="/authorities/listrole"></c:url>">Ρόλοι Χρηστών</a></th>
			<th><a class="link" href="<c:url value="/function/listfunction"></c:url>">Υποστηριζόμενες Υπηρεσίες</a></th>
	 
</sec:authorize>
<sec:authorize access="hasRole('PUBLISHER')">
<div id="header">
			<h3>Σελίδα Εκδότη</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Publisher Name</th>
					
				
				</tr>


					<tr>	
						<td>${user.userName}</td>
						<td>*******</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.authoritie.authority}</td>
						<td>${user.publisher.publisherName}</td>
						
					</tr>
					
			</table>
			<br>
				 	<a class="link" href="<c:url value="/publisher/mytextbooks/${user.publisher.id}"></c:url>">Τα Συγγράμματα Μου</a> 
				 	<a class="link" href="<c:url value="/publisher/${user.publisher.id}"></c:url>">Προσθήκη Συγγράμματος</a>
				 	<a class="link" href="<c:url value="/publisher/students"></c:url>">Παράδοση Συγγράμματος</a>
</sec:authorize>				 	
		</div>
