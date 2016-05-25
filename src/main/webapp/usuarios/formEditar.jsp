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
			<h1>Editar Usuário</h1>
		</div>
		
		<form name="myForm" method="post" class="form-horizontal" action="<%=request.getContextPath()%>/usuarios/atualizar">
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<ul>
						<c:forEach items="${erros}" var="msg">
							<li>${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Código:</label>
				<div class="col-sm-5">
					<input type="text" name="codUsuario" id="codUsuario" value="${item.codUsuario}" required="required" readonly="readonly" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome" value="${item.nome}" required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="email">Email:</label>
				<div class="col-sm-5">
					<input type="email" name="email" id="email" value="${item.email}" required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="cpf">CPF:</label>
				<div class="col-sm-5">
					<input type="text" name="cpf" id="cpf" value="${item.cpf}" required="required" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nascimento">Data de Nascimento:</label>
				<div class="col-sm-5">
					<input type="text" name="nascimento" id="nascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${item.nascimento}" />" required="required" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="renda">Renda:</label>
				<div class="col-sm-5">
					<input type="text" name="renda" id="renda" value="${item.renda}" required="required" class="form-control" id="campoData" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Atualizar</button>
					<a href="<%=request.getContextPath()%>/usuarios/listar" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
		
		
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
