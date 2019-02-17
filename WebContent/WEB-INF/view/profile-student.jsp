	<div id="wrapper">
		<div id="header">
			<h2>ΤO ΠΡΟΦΙΛ ΤΟΥ ΦΟΙΤΗΤΗ</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Όνομα</th>
					<th>Επώνυμο</th>
				
				</tr>
				<!-- loop over and print our customers -->
				
				
					<tr>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>					
					     
						<td><a href="<c:url value="/publisher/studentTextbooks&${student.id}"></c:url>"><i class="unhide icon"></i>Επιλογή Συγγράμματος</a></td>
					</tr>
					
				
			</table>
		</div>
	</div>