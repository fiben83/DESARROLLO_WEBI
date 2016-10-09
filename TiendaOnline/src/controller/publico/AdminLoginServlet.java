package controller.publico;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.BasicUtilitiesServlet;

/**
 * Servlet implementation class AdminLoginServlet
 * Concede permiso de administrador si los datos proporcionados 
 * son validos
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends BasicUtilitiesServlet{

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user= request.getParameter("user");
		String pass= request.getParameter("pass");
		
		if(user == null || pass ==null){
			gotoURL(frontPage, request, response);
		}
		
		HttpSession session= request.getSession();
		ServletContext context= session.getServletContext();
		InputStream is= context.getResourceAsStream(adminConfigFile);
		Properties adminConfig= new Properties();
		try{
			adminConfig.load(is);
			String adminUser= adminConfig.getProperty("adminUser");
			String adminPass= adminConfig.getProperty("adminPass");
			if(user.equals(adminUser) && pass.equals(adminPass)){
				session.setAttribute("admin", "true");
				System.out.println("Logueado admin desde la IP: "+request.getRemoteAddr());
				gotoURL(adminSettings, request, response);
				
			}else{
				request.setAttribute("info", "Los datos son incorrectos");
				System.out.println("Intento fallido de logueo admin desde la IP: "+request.getRemoteAddr());
			gotoURL(adminLogin, request, response);
			}
		}catch(IOException ex){
			request.setAttribute("info", "Error cargango los parametros");
			System.out.println("Error cargando los parametros del fichero Administrador");
			gotoURL(adminLogin, request, response);
		}
		
		
	}
	
    
    
}
