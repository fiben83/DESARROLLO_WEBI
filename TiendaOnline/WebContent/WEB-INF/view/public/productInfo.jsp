<%@page import="modelo.beans.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.beans.Catalogo"%>
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
<script>
	$(document).ready(function(){
		
	});
</script>

</head>
<body>
<jsp:useBean id="categorias" scope="application" class="java.util.HashMap"/>
<jsp:useBean id="catalog" scope="application" class="modelo.beans.Catalogo"/>
<jsp:useBean id="producto" scope="request" class="modelo.beans.Producto"/>
<jsp:useBean id="info" scope="request" class="java.lang.String"/>


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
						<li><a href="#">Admin</li>
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
				<section class="catalogo">
					<div class="row">
						<div class="col-md-12">
							<div id="about">
								<%if(info != null && !info.equals("")) {%>
									<p class="tree"><b><%=info%></b></p>
								<%} %>
									<p class="tree"><a href="/TiendaOnline/go?to=search"></a></p>
									<div class="photos">
										<pre></pre>
										<img src="<%=producto.getImagen() %>" width="180" height="187"/><br/>
										<a href="#" class="comments">Ver Comentarios</a>
									</div>
									<div class="description">
										<a href="/TiendaOnline/go?to=product&cod=<%=producto.getCodProducto() %>" class="name"><%=producto.getNomProducto() %></a>
										<pre></pre>
										<p><span><%=producto.getNomProducto() %></span></p>
										<p><span><%=producto.getCodProducto() %></span></p>
										<p><span ><%=producto.getPriceAsString() %></span></p>
										<pre></pre>
										<form method="post" action="/TiendaOnline/go">
											<input name="to" value="shoppingcart" type="hidden">
											<input name="cod" value="<%=producto.getCodProducto()%>" type="hidden">
											<p class="line"><span>Unidades</span> <input name="n" value="1" type="text" size="3" maxlength="3"></p>
											<p><span>Solo <%=producto.getStockTotal() %> disponibles</span>
											<button>Al carro</button>
										</form>
									
									</div>
							</div>
						</div>
					
					</div>
				</section>
			
			</div>
			<div class="col-md-2">
				<div><img src="images/imagen2017.jpg" class="img-responsive"/></div>
				<div><img src="images/hombres.jpg" class="img-responsive"/></div>
				<div><img src="images/mujeres.jpg" class="img-responsive"/></div>
			<div>
				<form class="form-inline" role="form">
					<div class="form-group">
							<label for="name_user" class="col-md-3">Usuario</label>
							<input type="text" class="form-control" id="name_user" placeholder="Ingresa Usuario">
					</div>
					<div class="form-group">
						<label for="text_password">Contraseña</label>
						<input type="password"class="form-control" id="text_passwrd" placeholder="Contraseña"> 
					</div>
					<button type="submit" class="btn btn-primary">Ingresar</button>
				</form>
			</div>
		</div>
		</div>
		</section>
		</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="jQuery/js/1291523190-jpaginate.js"></script>
</body>
</html>