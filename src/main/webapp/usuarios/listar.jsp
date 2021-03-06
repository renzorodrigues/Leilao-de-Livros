<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Usu�rios</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Usu�rios</h1>
		</div>
		
		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/usuarios/novo">
					<button type="submit" class="btn btn-primary">Novo Cadastro</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/usuarios/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um nome" class="form-control" />
					</div>
					<button type="submit" class="btn btn-warning">Filtrar</button>
				</form>
			</div>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>CPF</th>
					<th>Data Nascimento</th>
					<th>Renda</th>
					<th>A��o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codUsuario}</td>
						<td>${x.nome}</td>
						<td>${x.email}</td>
						<td>${x.cpf}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.nascimento}" /></td>
						<td><fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.renda}" /></td>
						<td><a href="<%=request.getContextPath()%>/usuarios/editar?cod=${x.codUsuario}" class="btn btn-primary btn-xs">Editar</a>
							<a href="<%=request.getContextPath()%>/usuarios/excluir?cod=${x.codUsuario}" class="btn btn-danger btn-xs">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="/resources/templates/footer.jsp" />

	<!-- CORE JS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
