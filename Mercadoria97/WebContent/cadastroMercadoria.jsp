<%@page import="com.example.merc97.model.TipoNegocio"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Merc97</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/landing-page.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- validações com js -->
<script type="text/javascript">
	function validar() {
		var nome = form1.nome.value;
		var tipo = form1.tipo.value;
		if (tipo.length < 2 || tipo.trim().lenght == 0) {
			document.getElementById('dv').style.visibility = 'visible';
			document.getElementById('dv').style.display = 'block';
			return false;
		} else if (nome.length < 2 || nome.trim().lenght == 0) {
			document.getElementById('dv').style.visibility = 'visible';
			document.getElementById('dv').style.display = 'block';
			return false;
		} else {
			return true;
		}

	}
</script>

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav" href="#">Merc97</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listaMercadoria.jsp">Lista de Operações</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Header -->
	<div class="intro-header">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1></h1>
						<img src="img/coin.png" id="coin">
						<h3>Seu sistema de compra e venda de mercadorias</h3>
						<hr class="intro-divider">
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->



	<div class="container">
		<h1>Cadastrar Mercadoria</h1>
		<div class="alert alert-danger alert-dismissible" id="dv"
			style="visibility: hidden; display: none;">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Ops!</strong> Digite no minimo 2 caracteres ou mais nos
			campos "Tipo" e "Nome"!
		</div>
		<section id="form">
			<form name=form1 action="AddMercadoria" method="post">
				<br> <br> <label>Tipo de Negocio:</label>
				<c:set var="tipoNegocio" value="<%=TipoNegocio.values()%>"></c:set>
				<select name="tipoNegocio">
					<c:forEach items="${tipoNegocio}" var="t">
						<option value="${t}">${t.toString()}</option>
					</c:forEach>
				</select> <br> <input type="hidden" id="id" name="id" /> <br> <br>
				<input type="text" id="tipo" name="tipo" placeholder="Tipo"
					required="required" /> <br> <br> <input type="text"
					id="nome" name="nome" placeholder="Nome" required="required" /> <br>
				<br> <input type="number" required="required" min="1"
					id="quantidade" name="quantidade" placeholder="Quantidade" /> <br>
				<br> <input type="text" id="preço" name="preço"
					placeholder="Preço" required="required"
					pattern="^(0|[1-9][0-9][.-,]*)$" /> <br> <br> <input
					type="submit" name="salvar" value="SALVAR"
					onclick="return validar()">
			</form>
			<hr class="intro-divider2">
		</section>
	</div>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="list-inline">
						<li><a href="#">Inicio</a></li>
						<li class="footer-menu-divider">&sdot;</li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy; Laécio
						2016</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
