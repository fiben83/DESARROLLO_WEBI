package controller.publico;

import java.io.IOException;

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
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet(name = "ProductInfoServlet")
public class ProductInfoServlet extends BasicUtilitiesServlet {
	

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet ProductoInfoServlet");
		Producto product= generateProductFromRequest(request);
		if(product == null){
			request.setAttribute("info", "El disco solicitado no existe!...");
		}else{
			
			System.out.println("Solicitando el disco: "+product.getCodProducto());
		}
		request.setAttribute("producto", product);
		System.out.println("antes de ir a la URL productInfo");
		gotoURL(productInfo, request, response);
		
		
	}
	
	private Producto generateProductFromRequest(HttpServletRequest request){
		System.out.println("al metodo generate");
		HttpSession session= request.getSession();
		ServletContext context= session.getServletContext();
		Catalogo catalog= (Catalogo) context.getAttribute("catalog");
			String codProduct= request.getParameter("cod");
			System.out.println("codigo producto "+codProduct);
			/*if(!validateFreeText(codProduct,36,36)){
				
				return null;
			}*/
			return catalog.getProducto(codProduct);
	}
       
    
}
