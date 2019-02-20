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
			<h2>Τα Συγγράμματα Μου</h2>
		</div>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<tr>
					<th>Title</th>
					<th>Writer</th>
					<th>Year of publishing</th>
					<th>Name of publisher</th>
					<th>Number ISBN</th>

				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempTextBook" items="${textbooks}">

					<tr>	
						<td>${tempTextBook.title}</td>
						<td>${tempTextBook.writer}</td>
						<td>${tempTextBook.year}</td>
						<td>${tempTextBook.publishername}</td>
						<td>${tempTextBook.isbn}</td>
						<td><button type="submit" id="${tempTextBook.id}"  name="deleteTextBook"><i class="remove user icon"></i>Delete</button>
					 <a class="link" href="<c:url value="/textbook/${tempTextBook.id}"></c:url>"><i class="unhide icon"></i>View</a>
				
					</tr>
				</c:forEach>
				 <a class="link" href="<c:url value="/textbook/0"></c:url>"><i class="unhide icon"></i>Add</a>
				
			</table>
		</div>
	
	<script type="text/javascript">
	$("[name='deleteTextBook']").click(function() {
		var urlCall = "<c:url value="/api/textbook/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/textbook/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>

