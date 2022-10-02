<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<div align="center">
	
		<h1><b>Rodadas</b></h1>
	
		<form action="rodadas" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Criar Rodadas">
					</td> 
				</tr>
			</table>
		</form>	
		<form action="rodadas" method="post">
			<table>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Mostrar Rodadas">
					</td>
					
				</tr>
			</table>
		</form>	
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada1 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>1° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada1 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada2 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>2° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada2 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada3 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>3° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada3 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada4 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>4° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada4 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<div align="center">
		<c:if test="${not empty rodada5 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>5° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada5 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada6 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>6° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada6 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada7 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>7° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada7 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada8 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>8° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada8 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada9 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>9° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada9 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada10 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>10° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada10 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada11 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>11° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada11 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<div align="center">
		<c:if test="${not empty rodada12 }">
			<table class="table_round">
				<thead>
					<tr>
						<th>12° Rodada</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${rodada12 }" var="j">
					<tr>
						<td><c:out value="${j.codigoTimeA.nomeTime }"/></td>
						<td><c:out value="${j.codigoTimeB.nomeTime }"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
</body>
</html>