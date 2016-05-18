<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Usuários</title>

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
			<h1>Usuários</h1>
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
					<th>Código</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>CPF</th>
					<th>Data Nascimento</th>
					<th>Renda</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codUsuario}</td>
						<td>${x.nome}</td>
						<td>${x.email}</td>
						<td>${x.cpf}</td>
						<td>${x.nascimento}</td>
						<td>${x.renda}</td>
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
