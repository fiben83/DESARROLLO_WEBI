package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="FrontController", urlPatterns={"/go"})
public class FrontController extends BasicUtilitiesServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
           System.out.println("No se pudo establecer el encoding "+ex);
                  
        }
        String to = request.getParameter("to");
        HttpSession session = request.getSession();
        String authenticated = (String) session.getAttribute("authenticated");
        String admin = (String) session.getAttribute("admin");
        if (to == null || (persistencia != null && persistencia.equals("none"))) {
            gotoURL(errorForm, request, response);
        } else if(to.equals("product")) {
        	 gotoNamedResource(productInfoServlet,request,response);
        } else if(to.equals("search")) {
            if(request.getParameter("type")==null && request.getParameter("nomProduct")==null) {
                gotoURL(productSearch,request,response);
            } else {
                gotoNamedResource(productSearchServlet,request,response);
            }
        } else if(to.equals("featured")) {
            gotoURL(productDestacados,request,response);
        } else if(to.equals("new")) {
            gotoURL(productNuevos,request,response);
        } else if(to.equals("login")) {
            gotoURL(userLogin,request,response);
        } else if(to.equals("shoppingcart")) {
            if(request.getParameter("id")==null) {
                gotoURL(shoppingCart,request,response);
            } else {
                gotoNamedResource(shoppingCartServlet,request,response);
            }
        } else if(to.equals("checkout")) {
            if(request.getParameter("action")==null) {
                gotoURL(checkoutLogin,request,response);
            } else {
                gotoNamedResource(checkoutCartServlet,request,response);
            }
        } else if(to.equals("user")) {
            if("false".equals(authenticated)) {
                if(request.getParameter("user")==null) {
                    gotoURL(userLogin,request,response);
                } else {
                    gotoNamedResource(userLoginServlet,request,response);
                }
            } else if("true".equals(authenticated)) {
                String action = request.getParameter("action");
                if(action == null) {
                    gotoURL(userSettings,request,response);
                } else if("delete".equals(action)) {
                    gotoNamedResource(userDeleteServlet,request,response);
                } else if("update".equals(action)) {
                    if(request.getParameter("nick")==null) {
                        gotoURL(userUpdate,request,response);
                    } else {
                        gotoNamedResource(userUpdateServlet,request,response);
                    }
                }
            }
        }  else if(to.equals("logout")) {
            gotoNamedResource(userLogoutServlet,request,response);
        }  else if(to.equals("mailuser")) {
            gotoNamedResource(mailUserServlet,request,response);
        } else if(to.equals("mailsale")) {
            gotoNamedResource(mailSaleServlet,request,response);
        } else if(to.equals("admin")) {
            if("false".equals(admin)) {
                if(request.getParameter("user")==null) {
                    gotoURL(adminLogin,request,response);
                } else {
                	
                    gotoNamedResource(adminLoginServlet,request,response);
                }
            } else if("true".equals(admin)) {
                String action = request.getParameter("action");
                if(action == null) {
                    gotoURL(adminSettings,request,response);
                }else if("storeProduct".equals(action)) {
                    if(request.getParameter("nomProduct")==null) {
                        gotoURL(adminStoreProduct,request,response);
                    } else {
                        //gotoNamedResource(productCreateServlet,request,response);
                    }
                }else if("newProduct".equals(action)) {
                    if(request.getParameter("name")==null) {
                        gotoURL(adminProductForm,request,response);
                    } else {
                        gotoNamedResource(productCreateServlet,request,response);
                    }
                } else if("updateProduct".equals(action)) {
                    if(request.getParameter("name")==null) {
                        request.setAttribute("cod",request.getParameter("cod"));
                        gotoURL(adminProductUpdate,request,response);
                    } else {
                        gotoNamedResource(productUpdateServlet,request,response);
                    }
                }  else if("searchuser".equals(action)) {
                    if(request.getParameter("nick")==null) {
                        gotoURL(adminUserSearch,request,response);
                    } else {
                        gotoNamedResource(userSearchServlet,request,response);
                    }
                } else if("searchsale".equals(action)) {
                    if(request.getParameter("cod")==null) {
                        gotoURL(adminSalesSearch,request,response);
                    } else {
                        gotoNamedResource(salesSearchServlet,request,response);
                    }
                } else if("logout".equals(action)) {
                    gotoNamedResource(adminLogoutServlet,request,response);
                }
            }      
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}