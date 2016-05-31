<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Leilão de Livros</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">

  </head>

  <body>
  
  	<jsp:include page="/resources/templates/navbar.jsp" />

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Mercado do Livro</h1>
      </div>
      <p class="lead"><i>Faça o seu cadastro</i></p>
      <p class="lead"><i>Pesquise os livros disponíveis</i></p>
    </div>

	<jsp:include page="/resources/templates/footer.jsp" />
    
    <!-- CORE JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
