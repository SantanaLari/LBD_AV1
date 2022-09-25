<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grupo</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<div align="center" class="container">
		<form action="grupo" method="get">
			<p class="title">
				<b>Grupos</b>
			</p>
			<table>
				<tr>
					<td colspan="4">
						<input class="input_data_id" type="text" id="Grupo" name="Grupo" placeholder="Grupo">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Excluir">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Listar">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<c:if test= "${not empty erro } ">
			<h2><c:out value= "${erro }" /></h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test= "${not empty saida } ">
			<h3><c:out value= "${saida }" /></h3>
		</c:if>
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test= "${not empty grupos } ">
			<table class="table_round">
				<thead>
					<tr>
						<th><b>Grupo</b></th>
					</tr>				
				</thead>		
			</table>
			<tbody>
				<c:forEach items="${grupos } " var="g">
					<tr>
						<td><c:out value= "${g.Grupo }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</div>

</body>
</html>