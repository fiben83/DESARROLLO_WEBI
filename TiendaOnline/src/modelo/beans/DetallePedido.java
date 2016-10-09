package modelo.beans;

import java.io.Serializable;

public class DetallePedido implements Serializable{

	private String codPedido;
	private String codProducto;
	private int cantidad;
	private double precioLista;
	
		
	public DetallePedido() {
		
	}
		
	public DetallePedido(String codPedido, String codProducto, int cantidad, double precioLista) {
		
		this.codPedido = codPedido;
		this.codProducto = codProducto;
		this.cantidad = cantidad;
		this.precioLista = precioLista;
	}


	public String getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(double precioLista) {
		this.precioLista = precioLista;
	}
	
	
}
