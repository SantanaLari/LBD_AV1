<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rodadas</title>
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
				<c:if test= "${not empty jogos } ">
					<table class="table_round">
					<thead>
						<tr>
							<th><b>TimeA</b></th>
							<th><b>TimeB</b></th>
							<th><b>Data</b></th>
						</tr>				
					</thead>		
					</table>
					<tbody>
					<c:forEach items="${jogos } " var="j">
						<tr>
							<td><c:out value= "${j.CodigoTimeA }" /></td>
							<td><c:out value= "${j.CodigoTimeB }" /></td>
							<td><c:out value= "${j.Data }" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</c:if>
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
	<div align="center">
		
	</div>

</body>
</html>