<div id="ui segment">
		<div id="header">
			<h3>Υποστηριζόμενες Υπηρεσίες</h3>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Υπηρεσία</th>
					<th>Δικαίωμα Εκτέλεσης</th>

				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempFunction" items="${functions}">

					<tr>	
						<td>${tempFunction.functionName}</td>
						<td>${tempFunction.authority.authority}</td>
						<td><button type="submit" id="${tempFunction.id}"  name="deleteFunction"><i class="remove user icon"></i>Delete</button>
				<!--  <a href="<c:url value="/function/${tempFunction.id}/${tempFunction.authority}"></c:url>"><i class="unhide icon"></i>View</a>  -->	
					 <a href="<c:url value="/function/role/${tempFunction.id}"></c:url>"><i class="unhide icon"></i>Ενημέρωση Δικαιωμάτων Εκτέλεσης </a>
				
					</tr>
				</c:forEach>
				<tr><a href="<c:url value="/function/showFunctForm"></c:url>">Προσθήκη Υπηρεσίας</a>	</tr>
			</table>
			
		</div>
	
	<script type="text/javascript">
	$("[name='deleteFunction']").click(function() {
		var urlCall = "<c:url value="/function/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'GET',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/function/listfunction"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>
