	<div id="ui segment">
		<div id="header">
			<h3>Τα Συγγράμματά Μου</h3>
		</div>
		
		<table class="ui celled  striped table">
			<tr>
				<th>Τίτλος Συγγράμματος</th>
				<th>Συγγραφέας</th>
				<th>Σημείο Παράδοσης</th>
				<th>Χρονία Έκδοσης</th>
				<th>Εκδοτικός Οίκος</th>
				<th>ISBN</th>

			</tr>
		
		<c:forEach var="tempTextbook" items="${textbooks}">

				<c:if test="${tempTextbook.publisher.id == publisher.id}">

					<tr>
						<td>${tempTextbook.title}</td>
						<td>${tempTextbook.writer}</td>
						<td>${tempTextbook.receivingPoint}</td>
						<td>${tempTextbook.year}</td>
						<td>${tempTextbook.publishername}</td>
						<td>${tempTextbook.isbn}</td>
						

<td><button type="submit" id="${tempTextbook.id}"  name="deleteTextBook"><i class="remove user icon"></i>Διαγραφή</button>
						<td><a href="<c:url value="/publisher/deliveryPoint/${tempTextbook.id}"></c:url>">Σημείο Παράδοσης</a></td>
					 
					<td><a href="<c:url value="/publisher/viewtextbook/${tempTextbook.id}"></c:url>"><i class="unhide icon"></i>View</a></td>
					
					
					</tr>

				</c:if>


			</c:forEach>
			
		</table>
		
		</div>
		
		<script type="text/javascript">
	$("[name='deleteTextBook']").click(function() {
		var urlCall = "<c:url value="/publisher/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'GET',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/publisher/mytextbooks/${publisher.id}"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>
		
		
		