package modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.UUID;

public class Producto implements Serializable {
	private String codProducto;
	private String nomProducto;
	private String descripcion;
	private String imagen;
	private Double precioUnitario;
	private int stockReal;
	private int stockTotal;
	private String idCategoria;
	private int idProveedor;
		
			
	public Producto() {
		
	}

	public Producto(String cod) {
		this.codProducto= cod;
	}
		
	public Producto(String codProducto,String nomProducto, String descripcion, String imagen, Double precioUnitario, int stockReal, int stockTotal) {
		this.codProducto=codProducto;
		this.nomProducto = nomProducto;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precioUnitario = precioUnitario;
		this.stockTotal = stockTotal;
		this.stockReal = stockReal;
	}

	
	
	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
		
	public String getPriceAsString(){
		return precioUnitario.toString();
	}
	
	public String getPriceAsFormattedString(){
		NumberFormat n= NumberFormat.getInstance();
		double doublePrecio= precioUnitario.doubleValue();
		return n.format(doublePrecio);
	}
	
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStockReal() {
		return stockReal;
	}

	public void setStockReal(int stockReal) {
		this.stockReal = stockReal;
	}

	public int getStockTotal() {
		return stockTotal;
	}
	public void setStockTotal(int stockTotal) {
		this.stockTotal = stockTotal;
	}
	
		
	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
}
