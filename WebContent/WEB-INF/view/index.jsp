<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<div id="ui segment">

	<h3>Welcome ${firstName}</h3>
	<table class="ui celled  striped table">
		<tr>${message}
	 		User: <sec:authentication property="principal.username" /> με Ρόλο: <sec:authentication property="principal.authorities"/>
		<tr>	
			<br><br>
		<tr>	<form action="${pageContext.request.contextPath}/firstPage" method="get">
			<input value="Συνέχεια" type="submit">
			</form>
		</tr>
	</table>
</div>	
	