<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Leilão de Livros</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/usuarios/listar">Cadastro
						de Usuários</a></li>
				<li><a href="<%=request.getContextPath()%>/livro/pesquisar">Pesquisar
						Livros</a></li>
				<li><a href="<%=request.getContextPath()%>/lances/inserir">Incluir
						Lance</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>