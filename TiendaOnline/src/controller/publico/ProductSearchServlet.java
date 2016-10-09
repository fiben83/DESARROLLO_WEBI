package controller.publico;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends BasicUtilitiesServlet {

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ingreso a ProductSearch");
		ArrayList<Producto> productList = generateProductListFromRequest(request);
        if(productList.isEmpty()) {
            request.setAttribute("info","No se han encontrado resultados para su busqueda");
        } else {
            request.setAttribute("info","Se han encontrado: "+productList.size()+" coincidencias");
        }
        request.setAttribute("list",productList);
        gotoURL(productSearch,request,response);
		
	}
	
	private ArrayList generateProductListFromRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        Catalogo catalog = (Catalogo) context.getAttribute("catalog");
        
        String nomProduct = request.getParameter("nomProduct");
                
        String type = request.getParameter("type");
                
        return catalog.buscarProducto(nomProduct, type);
    }


}
