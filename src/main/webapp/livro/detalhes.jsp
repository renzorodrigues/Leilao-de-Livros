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
			<h1>Detalhes do Livro</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codLivro}</li>
				<li class="list-group-item">Título: ${item.titulo}</li>
				<li class="list-group-item">Descrição: ${item.descricao}</li>
				<li class="list-group-item">Edição: ${item.edicao}</li>			
			</ul>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/livro/pesquisar" class="btn btn-success">Nova Pesquisa</a>
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
