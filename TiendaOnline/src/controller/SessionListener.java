package controller;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import modelo.beans.Pedido;

@WebListener
public class SessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("cart", new Pedido());
        session.setAttribute("authenticated", "false");
        session.setAttribute("admin", "false");
        System.out.println("Creada sesion: "+session.getId()+" a las: "+getTime());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Destruida sesion: "+session.getId()+" a las: "+getTime());
    }

    private String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    }

}
