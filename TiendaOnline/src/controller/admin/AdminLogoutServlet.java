package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.BasicUtilitiesServlet;

/**
 * Servlet implementation class AdminLogoutServlet
 */
@WebServlet("/AdminLogoutServlet")
public class AdminLogoutServlet extends BasicUtilitiesServlet {

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		session.setAttribute("admin", "false");
		System.out.println("Deslogueado admin desde IP "+request.getRemoteAddr());
		request.setAttribute("loginError", "Administracion terminada");
		gotoURL(frontPage, request, response);
	}
	

}
