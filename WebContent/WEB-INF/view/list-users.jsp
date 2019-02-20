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
	<div id="header">
		<h3>Οι Χρήστες του Συστήματος</h3>
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
			<th>Enabled</th>
			

		</tr>
		<!-- loop over and print our customers -->
		<c:forEach var="tempUser" items="${users}">
		
			<tr>
				<td>${tempUser.userName}</td>
				<td>*******</td>
				<td>${tempUser.firstName}</td>
				<td>${tempUser.lastName}</td>
				<td>${tempUser.email}</td>
		<!-- <td>${tempUser.authoritie.authority}</td> -->	
		<td>${tempUser.getAuthoritie().authority}</td>	
				<td><c:if test="${tempUser.enabled == 'true'}">
						ΝΑΙ
					</c:if>
					<c:if test="${tempUser.enabled == 'false'}">
						ΟΧΙ
					</c:if>
				</td>

				<td><button type="submit" id="${tempUser.userName}"name="deleteUser"><i class="remove user icon"></i>Διαγραφή</button> 
				
				<a class="link" href="<c:url value="/user/${tempUser.userName}"></c:url>"><iclass="unhide icon"></i>Στοιχεία Χρήστη</a> 
				
				<c:if test="${tempUser.getAuthoritie().authority != 'ROLE_ADMIN'}">

						<a class="link" href="<c:url value="/user/Details/${tempUser.userName}"></c:url>"><iclass="unhide icon"></i>Λεπτομέρειες Χρήστη</a>
						
					<!-- <c:if test="${tempUser.getStudent().getId() == 0}">
							<a href="<c:url value="/user/ShowDetailsForm/${tempUser.userName}"></c:url>"><iclass="unhide icon"></i>ADD Details</a>
						</c:if> -->	
			</c:if> 
				<c:if test="${tempUser.getAuthoritie().authority == 'null'}">	
					<a class="link" href="<c:url value="/authorities/showRoleForm/${tempUser.userName}"></c:url>">ADD Role</a>	
				</c:if>
					
			</tr>
		
		</c:forEach>
		
		<!-- <tr><a href="<c:url value="/user/chooseRole"></c:url>"><i class="unhide icon"></i>ADD User</a>	</tr> -->
		<tr>
			<a class="link" href="<c:url value="/user/showAddForm/"></c:url>"></i>Προσθήκη Χρήστη</a>
		</tr>

	</table>

</div>

<script type="text/javascript">
	$("[name='deleteUser']").click(
			function() {
				if (confirm("θέλετε να διαγράψετε αυτό τον Χρήστη;")) {
				    txt = "You pressed OK!";
			
				var urlCall = "<c:url value="/user/delete/"></c:url>";
				$.ajax({
					url : urlCall + $(this).attr('id'),
					type : 'GET',
					success : function(result) {
						console.log(result);
						$(location).attr("href",
								"<c:url value="/user/listuser"></c:url>");
					},
					error : function(result) {
						console.log(result);
					},
				});
				} else {
				    txt = "You pressed Cancel!";
			 	}
				document.getElementById("demo").innerHTML = txt;
		
			});
</script>

