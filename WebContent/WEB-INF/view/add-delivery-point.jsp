<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 							
 					<div class="ui segment">

						<h3>Σημείο Παράδοσης Συγγράμματος</h3>
						
						
 							<form:form action="${pageContext.request.contextPath}/publisher/saveTextBook/${tid}" modelAttribute="textbook" method="POST" class="ui form">
								<div class="field">
									<label>Σημείο Παράδοσης</label> 
									<form:input path="receivingPoint"/>
								</div>
							
								<button class="ui button" type="submit">Αποθήκευση</button>
							</form:form>
				</div>