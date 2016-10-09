package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import modelo.beans.Catalogo;
import persistencia.Producto.ProductoDAO;
import persistencia.Producto.ProductoPersistFactory;

@WebListener
public class StartUpListener implements ServletContextListener {
    
    private ProductoDAO productoDAO;
    //private SaleDAO saleDAO;
    //private UserDAO userDAO;

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        String url, driver, user, password, persistencia;
        ServletContext context = evt.getServletContext();
        String persistenceConfigFile = context.getInitParameter("persistenceConfigFile");
        InputStream is = context.getResourceAsStream(persistenceConfigFile);
        Properties persistenceConfig = new Properties();
        try {
            persistenceConfig.load(is);
            url = persistenceConfig.getProperty("url");
            driver = persistenceConfig.getProperty("driver");
            user = persistenceConfig.getProperty("user");
            password = persistenceConfig.getProperty("password");
        } catch (IOException ex) {
            System.out.println("Error cargando los parametros del fichero de configuracion de BD: "+ex);
            //En este caso sacamos los parametros directamente del descriptor
            url = context.getInitParameter("databaseURL");
            driver = context.getInitParameter("databaseDriver");
            user = context.getInitParameter("databaseUser");
            password = context.getInitParameter("databasePassword");
        }
        persistencia = context.getInitParameter("persistencia");
        
        System.out.println("Estableciendo conexion con la BD empleando: "+persistencia+"...");
        
        productoDAO = ProductoPersistFactory.getProductoDAO(persistencia);
        //saleDAO = SalePersistFactory.getSaleDAO(persistenceMechanism);
         //userDAO = UserPersistFactory.getUserDAO(persistenceMechanism);
        boolean connected = productoDAO.setUp(url, driver, user, password); //&&
                            //saleDAO.setUp(url, driver, user, password) &&
                            //userDAO.setUp(url, driver, user, password);
        if (!connected) {
           System.out.println("Error conectando a la BD");
            context.setAttribute("persistencia", "none");
            context.setAttribute("catalog", "none");
        } else {
        	System.out.println("Conexion con la BD realizada con exito");
            Catalogo catalog = new Catalogo();
            if( catalog.setUp(persistencia) ) {
            	System.out.println("Catalogo de la aplicacion cargado con exito");
                context.setAttribute("catalog", catalog);
            } else {
            	System.out.println("Error cargando los datos en el Catalogo");
                context.setAttribute("catalog", "none");
            }
        }
        if(cargarCategoriasAContexto(context) ) {
        	System.out.println("Cargadas las categorias del menu");
        } else {
        	System.out.println("Error cargando las categorias del menu");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
        boolean ok = productoDAO.disconnect();
                     //saleDAO.disconnect() &&
                     //userDAO.disconnect();
                     //adminDAO.disconnect();
        if (!ok) {
        	System.out.println("No se encontro el driver para la base de datos");
        } else {
        	System.out.println("Cerrada correctamente la conexion con la base de datos");
        }
    }

    private boolean cargarCategoriasAContexto(ServletContext context) {
        String categorias = context.getInitParameter("categorias");
        if(categorias != null) {
            HashMap<String,String> categoriasMap = new HashMap<String,String>();
            String[] pairs = categorias.split(",");
            for(int i=0;i<pairs.length;i++) {
                String[] par = pairs[i].split("=");
                categoriasMap.put(par[0],par[1]);
            }
            context.setAttribute("categorias",categoriasMap);
            return true;
        }
        return false;
    }
}
