<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jogos</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<div align="center" class="container">
		<form action="jogos" method="post">
			<p class="title">
				<b>Jogos</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data" type="text" id="data" name="data" placeholder="Data"
						value='<c:out value= "${jogo.Data }" />'>
					</td>
					<td colspan="4">
						<input type="submit" id="botao" name="botao" value="Enviar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<c:if test= "${not empty erro} ">
			<h2><c:out value= "${erro}" /></h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test= "${not empty saida} ">
			<h3><c:out value= "${saida}" /></h3>
		</c:if>
	</div>
	
	<c:if test= "${not empty jogos } ">
		<table class="table_round">
			<c:forEach items="${jogos } " var="j">
				<c:if test= "${j.Data eq jogo.Data } ">
				<tr>
					<td><c:out value= "${j.CodigoTimeA }" /></td>
					<td><c:out value= "${j.CodigoTimeB }" /></td>
					<td><c:out value= "${j.Data}" /></td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>