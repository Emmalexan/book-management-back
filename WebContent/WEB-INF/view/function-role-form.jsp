<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

<form:form modelAttribute="auth" action="${pageContext.request.contextPath}/function/saveRoleFunction/${functid}" method="get" >
	<table>
    <tr>
    	<th>Επιλέξτε έναν ρόλο που μπορεί να εκτελέσει την υπηρεσία : ${fct.functionName} </th> 

 		<td><form:select  path="authority">
    	<form:option value="NONE"> --SELECT--</form:option>
    	<form:options items="${auths}" itemLabel="authority" itemValue="authority"></form:options>
  		</form:select>
  		</td>
  	</tr>
  	
    <tr>
    <td><input type="submit" value="Αποθήκευση"/></td>
    </tr>

    </table>
</form:form>


</div>