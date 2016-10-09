package persistencia.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.beans.Producto;

public class ProductoDAOJDBCImpl implements ProductoDAO {

	private Connection connection = null;
	private static ProductoDAOJDBCImpl prodPersistenciaManager = null;

	ProductoDAOJDBCImpl() {

	}
	
	public static ProductoDAO getProductoDAOJDBCImpl(){
		if(prodPersistenciaManager== null)
			prodPersistenciaManager=new ProductoDAOJDBCImpl();
		return prodPersistenciaManager;
	}

	@Override
	public boolean crearProducto(Producto p) {
		System.out.println("entro metodo crearProducto");
		String query = "insert into producto (codProducto,nomProducto,descripcion,imagen,precioUnitario,stockReal,stockTotal) values(?,?,?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, p.getCodProducto());
			statement.setString(2, p.getNomProducto());
			statement.setString(3, p.getDescripcion());
			statement.setString(4, p.getImagen());
			statement.setDouble(5, p.getPrecioUnitario());
			statement.setInt(6, p.getStockReal());
			statement.setInt(7, p.getStockTotal());
			statement.execute();
			return true;
		} catch (SQLException ex) {
			return false;
		}

	}

	@Override
	public Producto getProductoByCodigo(String cod) {
		String query = "select * from producto where codProducto= ?";
		PreparedStatement statement;
		ResultSet rs = null;
		Producto p = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, cod);
			rs = statement.executeQuery();
			if (rs.next()) {
				p = new Producto(cod);
				p.setNomProducto(rs.getString("nomProducto"));
				p.setImagen(rs.getString("imagen"));
				p.setPrecioUnitario(rs.getDouble("precioUnitario"));
				p.setStockTotal(rs.getInt("stockTotal"));
				p.setIdCategoria(rs.getString("categoria_idCategoria"));

			}
		} catch (SQLException ex) {
			p = null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		}
		return p;
	}

	@Override
	public ArrayList<Producto> getProductosByCampo(String nom, String categoria) {
	ArrayList<Producto> lista= new ArrayList();
	String query="selec * from producto";
	PreparedStatement statement;
	ResultSet rs=null;
	Producto p=null;
	Integer cate= new Integer(categoria);
	int nomPos=1, catPos=2;
	
	try{
		if(nom != null){
			query= query.concat(" where nomProducto =? ");
			
			if(cate != null ){
				query= query.concat(" and categoria_idCategoria =? ");
			}
		}else{
			nomPos=0;
			catPos--;
			if(cate != null){
				query=query.concat(" where categoria_idCategoria ");
				
			}
								
		}
		statement= connection.prepareStatement(query);
		if(nomPos !=0){
			statement.setString(nomPos, nom);
		}
		else{
			if(catPos !=0){
				statement.setString(catPos, categoria);
			}
		}
		rs= statement.executeQuery();
			while(rs.next()){
				p= new Producto(rs.getString("codProducto"));
				p.setNomProducto(rs.getString("nomProducto"));
				p.setImagen(rs.getString("imagen"));
				p.setPrecioUnitario(rs.getDouble("precioUnitario"));
				p.setStockTotal(rs.getInt("stockTotal"));
				lista.add(p);
			}
		}
		catch(SQLException ex){
			lista.clear();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		return lista;
	}

	@Override
	public boolean actualizarProducto(String c, Producto p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void darBajaProducto(String c) {
		// TODO Auto-generated method stub

	}

	//Obtiene un mapa de productos
	@Override
	public Map<String, Producto> getProductoMap() {
		HashMap<String,Producto> productoMap= new HashMap();
		String query= "select * from producto";
		PreparedStatement statement;
		ResultSet rs=null;
		Producto p=null;
		
		try{
			statement= connection.prepareStatement(query);
			rs= statement.executeQuery();
			while(rs.next()){
				String codProducto= rs.getString("codProducto");
				p= new Producto(codProducto);
				p.setNomProducto(rs.getString("nomProducto"));
				p.setImagen(rs.getString("imagen"));
				p.setPrecioUnitario(rs.getDouble("precioUnitario"));
				p.setStockTotal(rs.getInt("stockTotal"));
				productoMap.put(codProducto, p);
			}
		}catch(SQLException ex){
			productoMap.clear();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		
		return productoMap;
	}

	@Override
	public boolean setUp(String url, String driver, String user, String pass) {
		
		try{
			Class.forName(driver);
			connection= DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException ex){
			System.out.println("Error: No se encntró el driver para la BB.DD "+ex.getMessage());
			return false;
		}catch(SQLException ex){
			System.out.println("Error: No se pudo establecer Conexion "+ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean disconnect() {
		try{
			connection.close();
		}catch(SQLException ex){
			System.out.println("Error: "+ex.getMessage());
			return false;
		}
		return true;
	}

}
