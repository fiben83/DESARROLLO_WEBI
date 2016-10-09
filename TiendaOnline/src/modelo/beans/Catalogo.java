package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import persistencia.Producto.ProductoDAO;
import persistencia.Producto.ProductoPersistFactory;

public class Catalogo implements Serializable{
	private HashMap<String,Producto> catalogo=null;
	private Producto[] prodDestacados=null;
	private Producto[] prodNuevos=null;
	private ProductoDAO productoDAO= null;
	private Producto[] productsAll=null;
	
	public Catalogo() {
		catalogo= new HashMap<String,Producto>();
		prodDestacados= new Producto[10];
		prodNuevos= new Producto[10];
		
		
	}

	public HashMap<String, Producto> getCatalogo() {
		return catalogo;
	}

	public Producto[] getProdDestacados() {
		return prodDestacados;
	}
	
	public Producto[] getProdNuevos() {
		return prodNuevos;
	}
	
			
	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public Producto[] getProductsAll() {
		return productsAll;
	}

	
	public void setCatalogo(HashMap<String, Producto> catalogo) {
		this.catalogo = catalogo;
	}

	public void setProdDestacados(Producto[] prodDestacados) {
		this.prodDestacados = prodDestacados;
	}

	public void setProdNuevos(Producto[] prodNuevos) {
		this.prodNuevos = prodNuevos;
	}

	public boolean setUp(String persistencia){
		productoDAO = ProductoPersistFactory.getProductoDAO(persistencia);
		
		if(productoDAO ==null){
			return false;
		}else{
			this.catalogo= (HashMap) productoDAO.getProductoMap();
			System.out.println("entro a setUp asignando tamaño productsAll");
			productsAll= new Producto[catalogo.size()];
			this.cargaProductosNuevos();
			this.cargaProductosDes();
			
		}
		return true;
	}
	
	private void cargaProductosNuevos(){
		Producto[] productos= new Producto[catalogo.size()];
		int n=0;
		for(String cod : catalogo.keySet()){
			productos[n] = catalogo.get(cod);
			n++;
		}
		
		//codigo agregado
		System.out.println("productsAll listo");
		productsAll= productos;
		
		//continua codigo original
		
		 int lastPos= productos.length-1;
		 for(int i=0; i< prodNuevos.length && lastPos>=0; lastPos--){
			 prodNuevos[i]= productos[lastPos];
			 i++;
		 }
	}
	
	private void cargaProductosDes(){
		prodDestacados= prodNuevos;
	}
	
	public boolean addProductoCatalogo(Producto p){
		System.out.println("Entro al metodo addproducto");
		if(productoDAO.crearProducto(p)){
			System.out.println("devuelve true y agrega al catalogo");
			String codProd= p.getCodProducto();
			catalogo.put(codProd, p);
				
		addProductoArreglo(prodNuevos,catalogo.get(codProd));
		return true;
		}
		return false;
	}
	
	public Producto getProducto(String cod){
		Producto p=null;
		p= catalogo.get(cod);
		return p;
	}
	
	public ArrayList<Producto> buscarProducto(String nom, String cat){
		System.out.println("Ingresó buscarProducto()");
		ArrayList<Producto> lista= new ArrayList();
		for(String cod: catalogo.keySet()){
			Producto p = catalogo.get(cod);
			boolean match= true;
			
			if(nom!=null && !p.getNomProducto().equalsIgnoreCase(nom)){
				System.out.println("Ingresó a comprobar nombre");
				match= false;
			}
			
			/*if(match && cat !=null && !p.getIdCategoria().equalsIgnoreCase(cat)){
				match= false;
			}*/
			if(match){
				lista.add(p);
			}
		}
		return lista;
	}
	
	public boolean actualizarProducto(String cod, Producto p){
		if(productoDAO.actualizarProducto(cod, p)){
			catalogo.put(cod, p);
			actualizarProductoArray(prodDestacados,catalogo.get(cod));
			actualizarProductoArray(prodNuevos,catalogo.get(cod));
			return true;
		}
		return false;
	}
	
	
	
	private void addProductoArreglo(Producto[]lista, Producto p){
		boolean found = false;
		for(int i=0; i<lista.length && !found;i++){
			if(lista[i] != null && lista[i].equals(p))
				found= true;
		}
		
		if(!found){
			Producto buff=null;
			Producto old= lista[0];
			for(int i=0;i+1<lista.length;i++){
				buff= lista[i+1];
				lista[i+1]= old;
				old= buff;
			}
			lista[0]= p;
		}
	}
	
	private void actualizarProductoArray(Producto[]lista, Producto p){
		boolean found= false;
		for(int i=0; i<lista.length && !found; i++){
			if(lista[i] !=null && lista[i].equals(p)){
				lista[i]= p;
				found= true;
			}
		}
	}
	
	
	
	
	
	

}
