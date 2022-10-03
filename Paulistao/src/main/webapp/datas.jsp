<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datas</title>
</head>
<body>

	<div>
		<jsp:include page="menu.jsp" />
	</div>
	
	<div align="center">
	
		<h1><b>Datas</b></h1>
	
		<form action="jogosFormados" method="get">
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="date" id="data" name="data" placeholder="Data">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
			</table>
		</form>	
	</div>
	
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