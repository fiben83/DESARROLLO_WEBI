package persistencia.Producto;

public class ProductoPersistFactory {

	public static ProductoDAO getProductoDAO(String persistencia){
		if(persistencia.equals("jdbc")){
			return ProductoDAOJDBCImpl.getProductoDAOJDBCImpl();
		}else{return null;}
	}
}
