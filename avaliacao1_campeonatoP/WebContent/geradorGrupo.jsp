<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Gerar Grupos</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="grupo" method="post">
			<p class="title">
				<b>Gerador de grupos</b>
			</p>
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Gerar grupos">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	
	<div align="center">
		<table class="table_round">
			<thead>	
				<tr>
					<th><b>Codigo</b></th>
					<th><b>Time</b></th>
					<th><b>Cidade</b></th>
					<th><b>Estádio</b></th>
				</tr>
			</thead>
	  		<tbody>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>