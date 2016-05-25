<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leilão de Livros</title>

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
			<h1>Confirmar Exclusão</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codUsuario}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Email: ${item.email}</li>
				<li class="list-group-item">CPF: ${item.cpf}</li>
				<li class="list-group-item">Data de Nascimento: <fmt:formatDate pattern="dd/MM/yyyy" value="${item.nascimento}" /></li>
				<li class="list-group-item">Renda: <fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${item.renda}" /></li>			
			</ul>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/usuarios/excluir_definitivo?cod=${item.codUsuario}" class="btn btn-danger">Excluir</a>
			<a href="<%=request.getContextPath()%>/usuarios/listar" class="btn btn-default">Voltar</a>
		</div>
	</div>

	<jsp:include page="/resources/templates/footer.jsp" />

	<!-- CORE JS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/funcoes.js"></script>
</body>
</html>
