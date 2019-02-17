<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 							
 					<div class="ui segment">

						<h3>Προσθήκη Σημείου Παράδοσης</h3>
 							<form:form action="saveTextBookProfile" modelAttribute="textbookprofile" method="POST" class="ui form">

								<div class="field">
									<label>Επιβεβαίωση Παράδοσης</label>
									<form:input path="confirmationReceived"/>
								</div>
								<button class="ui button" type="submit">Save</button>
							</form:form>
				</div>