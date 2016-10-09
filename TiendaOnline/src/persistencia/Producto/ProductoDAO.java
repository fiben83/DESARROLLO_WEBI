package persistencia.Producto;

import java.util.ArrayList;
import java.util.Map;

import modelo.beans.Producto;

//interfaz patron de persistencia DAo de producto
public interface ProductoDAO {

	public boolean crearProducto(Producto p);
	
	public Producto getProductoByCodigo(String cod);
	
	public ArrayList<Producto> getProductosByCampo(String nom, String categoria);

	public boolean actualizarProducto(String c, Producto p);
	
	public void darBajaProducto(String c);
	
	public Map<String,Producto> getProductoMap();
	
	public boolean setUp(String url, String driver, String user, String pass);
	
	public boolean disconnect();
}
