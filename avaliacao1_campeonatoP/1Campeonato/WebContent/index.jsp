<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Home</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<div align="center">
		<h1><b>Campeonato Paulista</b></h1>
		<hr>
		<h1><b>Opções de Grupo</b></h1>
		<form action="grupos" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar Grupo">
					</td> 
					<td>
						<input type="submit" id="botao" name="botao" value="Excluir Grupo">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Mostrar Grupo">
					</td>
				</tr>
			</table>
		</form>	
	</div>
	
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3><c:out value="${saida }" /></H3>
		</c:if>
	</div>
	
	<br />
	<br />
	
<!--  FUNCIONA 50%
	<div align="center">
		<c:if test="${not empty listGP }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGP }" var="gp">
					<tr>
						<td><c:out value="${gp }"/></td>
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
-->
	<div align="center">
		<c:if test="${not empty listGP }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Grupo A</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${listGP }" var="gp">
					<tr>
						<td><c:out value="${gp.grupo }"/></td>
						<td><c:out value="${gp.codigoTime.codigoTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>














</body>
</html>