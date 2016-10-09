package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BasicUtilitiesServlet extends HttpServlet {
    
    //Recursos accesibles sin credenciales
    protected String frontPage = null;
    protected String imagesMujer=null;
    protected String userLogin = null;
    protected String shoppingCart = null;
    protected String productInfo = null;
    protected String productSearch = null;
    protected String checkoutLogin = null;
    protected String checkoutSuccess = null;
    protected String checkoutError = null;
    protected String productNuevos = null;
    protected String productDestacados = null;
    //Recursos accesibles solo con credenciales de cliente logueado
    protected String userUpdate = null;
    protected String userSettings = null;
    //Recursos accesibles solo con credenciales de administrador
    protected String adminLogin = null;
    protected String adminProductForm = null;
    protected String adminStoreProduct = null;
    protected String adminProductUpdate = null;
    protected String adminSalesSearch = null;
    protected String adminUserSearch = null;
    protected String adminSettings = null;
    //Solicitud incorrecta por parte del cliente o error por excepcion
    protected String errorForm = null;
    protected String exceptionError = null;
    //Servlets de la aplicacion
    protected String frontController = null;
    protected String userLoginServlet = null;
    protected String userLogoutServlet = null;
    protected String userCreateServlet = null;
    protected String userUpdateServlet = null;
    protected String userDeleteServlet = null;
    protected String userSearchServlet = null;
    protected String shoppingCartServlet = null;
    protected String checkoutCartServlet = null;
    protected String adminLoginServlet = null;
    protected String adminLogoutServlet = null;
    protected String productInfoServlet = null;
    protected String productCreateServlet = null;
    protected String productUpdateServlet = null;
    protected String productDeleteServlet = null;
    protected String productSearchServlet = null;
    
    protected String salesSearchServlet = null;
    protected String mailSaleServlet = null;
    protected String mailUserServlet = null;
    //Modelo de persistencia empleado
    protected String persistencia = null;
    //Fichero con los credenciales del administrador
    protected String adminConfigFile = null;
    //Fichero con la configuracion del servidor de correo
    protected String emailConfigFile = null;
    

    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    /**
     * Permite redireccionar a un servlet dada su direccion
     * @param address direccion del Servlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void gotoNamedResource(String address, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(address);
        System.out.println("entró a gotoNamedResource y redirecciona al servlet ");
        dispatcher.forward(request, response);
    }
     /**
     * Permite redireccionar a una URL dada su direccion
     * @param address direccion URL a donde queremos ir
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void gotoURL(String address, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        System.out.println("entró a gotURL y va al productInfo ");
        dispatcher.forward(request, response);
    }

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        frontPage = context.getInitParameter("frontPage");
        imagesMujer= context.getInitParameter("imagesMujer");
        userLogin = context.getInitParameter("userLogin");
        
        shoppingCart = context.getInitParameter("shoppingCart");
        productInfo = context.getInitParameter("productInfo");
        productSearch = context.getInitParameter("productSearch");
        checkoutLogin = context.getInitParameter("checkoutLogin");
        checkoutSuccess = context.getInitParameter("checkoutSuccess");
        checkoutError = context.getInitParameter("checkoutError");
        productNuevos = context.getInitParameter("productNuevos");
        productDestacados = context.getInitParameter("productDestacados");
        userUpdate = context.getInitParameter("userUpdate");
        userSettings = context.getInitParameter("userSettings");
        adminLogin = context.getInitParameter("adminLogin");
        adminStoreProduct= context.getInitParameter("adminStoreProduct");
        adminProductForm = context.getInitParameter("adminProductForm");
        adminProductUpdate = context.getInitParameter("adminProductUpdate");
        adminSalesSearch = context.getInitParameter("adminSalesSearch");
        adminUserSearch = context.getInitParameter("adminUserSearch");
        adminSettings = context.getInitParameter("adminSettings");
        errorForm = context.getInitParameter("errorForm");
        exceptionError = context.getInitParameter("exceptionError");
        frontController = context.getInitParameter("frontController");
        userLoginServlet = context.getInitParameter("userLoginServlet");
        userLogoutServlet = context.getInitParameter("userLogoutServlet");
        userCreateServlet = context.getInitParameter("userCreateServlet");
        userUpdateServlet = context.getInitParameter("userUpdateServlet");
        userDeleteServlet = context.getInitParameter("userDeleteServlet");
        userSearchServlet = context.getInitParameter("userSearchServlet");
        shoppingCartServlet = context.getInitParameter("shoppingCartServlet");
        checkoutCartServlet = context.getInitParameter("checkoutCartServlet");
        adminLoginServlet = context.getInitParameter("adminLoginServlet");
        adminLogoutServlet = context.getInitParameter("adminLogoutServlet");
        productInfoServlet = context.getInitParameter("productInfoServlet");
        productCreateServlet = context.getInitParameter("productCreateServlet");
        productUpdateServlet = context.getInitParameter("productUpdateServlet");
        productDeleteServlet = context.getInitParameter("productDeleteServlet");
        productSearchServlet = context.getInitParameter("productSearchServlet");
        
        salesSearchServlet = context.getInitParameter("salesSearchServlet");
        mailSaleServlet = context.getInitParameter("mailSaleServlet");
        mailUserServlet = context.getInitParameter("mailUserServlet");
        persistencia= context.getInitParameter("persistencia");
        adminConfigFile = context.getInitParameter("adminConfigFile");
        emailConfigFile = context.getInitParameter("emailConfigFile");
        
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    /**
     * Valida que la cadena contiene campos permitidos para un nombre,
     * apellidos... solo caracteres alfabeticos y con acentos
     * @param data datos a validar
     * @param minAcceptable tamanyo minimo de la cadena
     * @param maxAcceptable tamanyo maximo de la cadena
     * @return true si es valida, false en caso contrario
     */
    protected boolean validateName(String data, int minAcceptable, int maxAcceptable) {
        boolean isGoodLength = data!=null && checkLength(data, minAcceptable, maxAcceptable);
        String namePattern = "([a-zA-ZñÑáéíóúÁÉÍÓÚç ])+";
        return isGoodLength && data.matches(namePattern);
    }
    
    /**
     * Valida que la cadena contiene solo caracteres alfabeticos y numericos
     * @param data datos a validar
     * @param minAcceptable tamanyo minimo de la cadena
     * @param maxAcceptable tamanyo maximo de la cadena
     * @return true si es valida, false en caso contrario
     */
    protected boolean validateAlphaNumeric(String data, int minAcceptable, int maxAcceptable) {
        boolean isGoodLength = data!=null && checkLength(data, minAcceptable, maxAcceptable);
        String namePattern = "([0-9a-zA-Z])+";
        return isGoodLength && data.matches(namePattern);
    }
    
    /**
     * Valida que la cadena contiene solo caracteres numericos
     * @param data datos a validar
     * @param minAcceptable tamanyo minimo de la cadena
     * @param maxAcceptable tamanyo maximo de la cadena
     * @return true si es valida, false en caso contrario
     */
    protected boolean validateNumeric(String data, int minAcceptable, int maxAcceptable) {
        boolean isGoodLength = data!=null && checkLength(data, minAcceptable, maxAcceptable);
        String namePattern = "([0-9])+";
        return isGoodLength && data.matches(namePattern);
    }
    
    /**
     * Valida que la cadena contiene solo caracteres validos para un email
     * @param data datos a validar
     * @return true si es valida, false en caso contrario
     */
    protected boolean validateEmail(String data) {
        String emailPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        Pattern p = Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(data);
        return (data!=null && m.matches());
    }
    
    /**
     * Valida que la cadena contiene solo caracteres alfabeticos, acentuados
     * y numericos y algunos caracteres especiales. Direcciones, descripciones...
     * @param data datos a validar
     * @param minAcceptable tamanyo minimo de la cadena
     * @param maxAcceptable tamanyo maximo de la cadena
     * @return true si es valida, false en caso contrario
     */
    protected boolean validateFreeText(String data, int minAcceptable, int maxAcceptable) {
        boolean isGoodLength = data!=null && checkLength(data, minAcceptable, maxAcceptable);
        String namePattern = "([0-9a-zA-ZñÑáéíóúÁÉÍÓÚ._,;:()/\\?\\!\\¿\\¡ \\-])*";
        return isGoodLength && data.matches(namePattern);
    }
    
    
    protected boolean checkLength(String data, int minAcceptable, int maxAcceptable) {
        if(data == null)
            return false;
        int length = data.length();
        boolean isGoodLength = length >= minAcceptable && length <= maxAcceptable;
        return isGoodLength;
    }
    
    
}
