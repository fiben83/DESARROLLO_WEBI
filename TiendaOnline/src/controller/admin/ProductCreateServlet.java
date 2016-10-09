package controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.BasicUtilitiesServlet;
import modelo.beans.Catalogo;
import modelo.beans.Producto;

/**
 * Servlet implementation class ProductCreateServlet
 */
@WebServlet("/ProductCreateServlet")
public class ProductCreateServlet extends BasicUtilitiesServlet {

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		ServletContext context= session.getServletContext();
		Catalogo catalog= (Catalogo) context.getAttribute("catalog");
		Producto p= generateProductFromRequest(request);
		if(p != null){
			System.out.println("Articulo Creado");
		}else{
			System.out.println("Error");
		}
		if(catalog.addProductoCatalogo(p)){
			request.setAttribute("info", "¡El Artículo: "+p.getNomProducto()+" Se ha insertado correctamente!");
			System.out.println("Creando el articulo: "+p.getNomProducto());
			gotoURL(adminSettings, request, response);
		}else{
			request.setAttribute("registerError", "Algo falla en nuesto sistema! Intentalo mas tarde...");
			System.out.println("Error insertando un nuevo articulo: "+p.getNomProducto());
		}
	}
	
	private Producto generateProductFromRequest(HttpServletRequest request){
		String codigo= request.getParameter("codigo");
		String name = request.getParameter("name");
		String descripcion= request.getParameter("descripcion");
		String imagen= request.getParameter("imagen");
		
		String pathImagenMujer= imagesMujer.concat(imagen);
				
		String precioString = request.getParameter("precio");
		Double precio= Double.valueOf(precioString);
		
		int stockReal = Integer.parseInt(request.getParameter("stockReal"));
		int stockTotal = Integer.parseInt(request.getParameter("stockTotal"));
		
		return new Producto(codigo,name,descripcion,pathImagenMujer,precio,stockReal,stockTotal);
	}
}
