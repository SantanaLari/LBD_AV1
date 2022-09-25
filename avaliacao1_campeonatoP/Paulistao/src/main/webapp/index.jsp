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
		<form action="grupo" method="get">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar">
					</td> 
					<td>
						<input type="submit" id="botao" name="botao" value="Excliur">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Mostrar">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<h1><b>Opções de Rodadas</b></h1>
		<form action="jogos" method="get">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Excliur">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Mostrar">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>