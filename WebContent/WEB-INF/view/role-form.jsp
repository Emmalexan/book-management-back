<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<h3>Πρόσθεσε ρόλο στον Χρήστη</h3>

		
	
<form:form modelAttribute="auth" action="${pageContext.request.contextPath}/authorities/saveRole/${username}" method="post" >	
	<table>
    <tr>

 		<td><form:select  path="authority">
    	<form:option value="NONE"> --SELECT--</form:option>
    	<form:options items="${auths}" itemLabel="authority" itemValue="authority"></form:options>
  		</form:select>
  		</td>
  	</tr>
  	
    <tr>
    <td><input type="submit" value="Επιλογή"/></td>
    </tr>

    </table>
</form:form>
</div>