package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ManageExceptionServlet", urlPatterns={"/Ooops"})
public class ManageExceptionServlet extends BasicUtilitiesServlet {
   
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Exception exception =
                (Exception) request.getAttribute("javax.servlet.error.exception");
        String exceptionSource =
                (String) request.getAttribute("javax.servlet.error.request_uri");
        
        System.out.println("Excepcion en "+exceptionSource+"con Excepcion: "+exception);
        gotoURL(exceptionError,request,response);      
    }

}
