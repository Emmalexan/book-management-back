<style>
		.link{
			display: block;

			text-align: center;
			padding: 5px;
			text-decoration: none; float:left;
             
             background-color: #F2F2F2;
            
		}

		.link :hover {
			background-color:#6E6E6E;
		}
       
</style>

<div id="ui segment">
		<div id="header">
			<h3>Διαθέσιμοι Ρόλοι Χρηστών</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Ρόλοι</th>
					
					
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempRole" items="${roles}">
					<c:if test="${tempRole.authority != 'null'}">
					<tr>	
						<td>${tempRole.authority}</td>
						
						<td><button type="submit" id="${tempRole.authority}"  name="deleteRole"><i class="remove user icon"></i>Διαγραφή</button>
				<!-- <a href="<c:url value="/authorities/${tempRole.authority}"></c:url>"><i class="unhide icon"></i>View</a> -->	 
				
					</tr>
					</c:if>
				</c:forEach>
				
				<tr><a class="link" href="<c:url value="/authorities/showRoleForm"></c:url>">Προσθήκη Ρόλου</a></tr>
			</table>
		</div>
	
	<script type="text/javascript">
	$("[name='deleteRole']").click(function() {
		if (confirm("θέλετε να διαγράψετε αυτό τον Ρόλο;")) {
		    txt = "You pressed OK!";
		 
		var urlCall = "<c:url value="/authorities/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'GET',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/authorities/listrole"></c:url>");
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