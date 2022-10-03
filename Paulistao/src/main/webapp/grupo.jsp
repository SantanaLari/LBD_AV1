<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Grupo</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<H1><b> GRUPOS FORMADOS </b></H1>
	
	<div align="center">
		<c:if test="${not empty listGPA }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo A</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPA }" var="gp">
					<tr>
						<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<br />
	
	<div align="center">
		<c:if test="${not empty listGPB }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo B</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPB }" var="gp">
					<tr>
						<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<br />
	
	<div align="center">
		<c:if test="${not empty listGPC }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo C</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPC }" var="gp">
					<tr>
						<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<br />
	
	<div align="center">
		<c:if test="${not empty listGPD }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo D</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGPD }" var="gp">
					<tr>
						<td><c:out value="${gp.codigoTime.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	

</body>
</html>