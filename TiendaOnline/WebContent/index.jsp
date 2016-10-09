<%@page import="modelo.beans.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Tienda Online</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/style.css" rel="stylesheet" media="screen">
</head>
<body>

<jsp:useBean id="categorias" scope="application" class="java.util.HashMap"/>
<jsp:useBean id="catalog" scope="application" class="modelo.beans.Catalogo"/>
<jsp:useBean id="loginError" scope="request" class="java.lang.String"/>
<%int maxItemsDisplay= 4; %>
	<header class="navbar navbar-static-top bs-docs-nav" role="banner">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<img src="images/delcarmen.jpg" width="240" height="155" />
				</div>
				<div class="col-md-10" id="menu-navigation">
					<ul class="list-inline ">
						<li><a href="#">Home</a></li>
						<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Mujeres<b class="caret"></b></a>
						<ul class="dropdown-menu">
								<li><a href="#">Carteras</a></li>
								<li><a href="#">Zapatos</a></li>
								<li><a href="#">Bolsos</a></li>
								
						</ul>
						</li>
						<li class="dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Hombres</a>
						<ul class="dropdown-menu">
								<li><a href="#">Billeteras</a></li>
								<li><a href="#">Zapatos</a></li>
								<li><a href="#">Correas</a></li>
								
						</ul>
						</li>
						<li><a href="#">Novedades</li>
						<li><a href="#">Mi Cuenta</li>
						<li><a href="#">Iniciar Sesión</li>
						<li><a href="/TiendaOnline/go?to=admin">Admin</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					
				</div>
			</div>
		</div>

	</header>
	<div class="container" style="padding-top: 3em;">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Desplegar navegación</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logotipo</a>
			</div>

			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<p class="navbar-text">Tel. 073 368073</p>
					<li><a href="#">Enlace #2</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Menu #1<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Accion #1</a></li>
							<li><a href="#">Accion #2</a></li>
							<li><a href="#">Accion #3</a></li>
							<li class="divider"></li>
							<li><a href="#">Accion #4</a></li>
							<li class="divider"></li>
							<li><a href="#">Accion #5</a></li>
						</ul></li>
				</ul>


				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Enlace #3</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Menú #2 <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Acción #1</a></li>
							<li><a href="#">Acción #2</a></li>
							<li><a href="#">Acción #3</a></li>
							<li class="divider"></li>
							<li><a href="#">Acción #4</a></li>
						</ul></li>
				</ul>
			</div>

		</nav>
		
		<div class="box-content">
		
		<!-- panel izquierdo, central y derecho -->
		<section class="paneles">
		<div class="row">
		<div class="col-md-2">
			<div class="panel panel-default panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Categorías</h3>
				</div>
				<div class="panel-body">
				</div>
				<ul class="list-group"id="navigation">
						<li class="list-group-item"><a href="#">Hombres</a></li>
						<li class="list-group-item"><a href="#">Mujeres</a></li>
						<li class="list-group-item"><a href="#">Zapatos</a></li>
						<li class="list-group-item"><a href="#">Billeteras</a></li>
						<li class="list-group-item"><a href="#">Carteras</a></li>
					</ul>
			</div>
		</div>
		<div class="col-md-8">
		
		<div id="carousel-example-generic" class="carousel slide" 
		data-ride="carousel" data-interval="3000">
  		<!-- Indicators -->
  			<ol class="carousel-indicators">
    			<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
    			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
  			</ol>

  			<!-- Wrapper for slides -->
  			<div class="carousel-inner">
    			<div class="item active">
      				<img src="images/imgPrincipa3.jpg" class="img-responsive"
			 		alt="Responsive imagen" />
      				<div class="carousel-caption">Imagen 1</div>
    			</div>
    			<div class="item">
      				<img src="images/imgPrincipa2.jpg" class="img-responsive" />
      				<div class="carousel-caption"> Imagen 2</div>
    			</div>
    			<div class="item">
      				<img src="images/imgPrincipal.jpg" class="img-responsive" />
      				<div class="carousel-caption"> Imagen 3</div>
    			</div>
    	    </div>

  			<!-- Controls -->
  			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    			<span class="sr-only">Previous</span>
  			</a>
 			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
   				 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    			<span class="sr-only">Next</span>
  			</a>
		</div>
				
		</div>
		<div class="col-md-2">
			<div><img src="images/imagen2017.jpg" class="img-responsive"/></div>
			<div><img src="images/hombres.jpg" class="img-responsive"/></div>
			<div><img src="images/mujeres.jpg" class="img-responsive"/></div>
			<div>
				<form class="form-inline" method="post" action="/TiendaOnline/go" role="form">
					<input name="to" value="user" type="hidden">
					<div class="form-group">
							<label for="user" class="col-md-3">Usuario</label>
							<input type="text" class="form-control" name="user" id="user" placeholder="Ingresa Usuario">
					</div>
					<div class="form-group">
						<label for="pass">Contraseña</label>
						<input type="password"class="form-control" name="pass" id="pass" placeholder="Contraseña"> 
					</div>
					<p class=""></p>
					<button type="submit" class="btn btn-primary">Ingresar</button>
				</form>
			</div>
		</div>

		</div>
		</section>
		<!-- catalogo mas buscados -->
		<section class="catalogo">
			<div class="slider-title">
				<span class="separator-holder separator-left" style="border-color: rgb(86, 86, 86);"/>
				Las Ultimas Novedades 
				<span class="separator-holder separator-right" style="border-color: rgb(86, 86, 86);"/>
			</div>
			<div class="row">
				
				<div class="col-md-12">
													
				<%Producto[] newProducts= catalog.getProdNuevos();
					for(int i=0; i<newProducts.length && i<maxItemsDisplay;i++){
						if(newProducts[i] !=null){%>
							<div class="item">
								<img src="<%=newProducts[i].getImagen() %>" width="180" height="187"/>
								<a href="/TiendaOnline/go?to=product&cod=<%=newProducts[i].getCodProducto() %>" class="name"><%=newProducts[i].getNomProducto() %></a>
								<span><%=newProducts[i].getCodProducto() %></span>
								<span>S/. <%=newProducts[i].getPrecioUnitario() %></span>
								<a href="/TiendaOnline/go?to=product&cod=<%=newProducts[i].getCodProducto() %>" class="g-boton">
									<span class="glyphicon glyphicon-eye-open vista">Vista </span>
								</a>
								<a href="/TiendaOnline/go?to=shoppingcart&cod=<%=newProducts[i].getCodProducto() %>&n=1" class="agregar">
									<span class="icon-icon agregar">Agregar a la bolsa</span>
								</a>
							</div>
						<%}
					}%>
					
				</div>
			</div>
		
		
		</section>
		</div>
		<!-- <div id="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-7"></div>
			<div class="col-md-3"></div>
		</div>

		</div>-->

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function(){
		$('.carousel-example-generic').carousel()
	});
	</script>
</body>
</html>