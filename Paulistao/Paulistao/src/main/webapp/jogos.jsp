<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Jogos</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<H1><b> JOGOS FORMADOS </b></H1>
	
	<div align="center">
		<c:if test="${not empty listJG }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Codigo Time A</th>
						<th>Codigo Time B</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listJG }" var="jg">
					<tr>
						<td><c:out value="${jg.codigoTimeA }"/></td>
						<td><c:out value="${jg.codigoTimeB }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
</body>
</html>