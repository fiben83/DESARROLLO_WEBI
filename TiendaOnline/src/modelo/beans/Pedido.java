package modelo.beans;

import java.io.Serializable;
import java.util.Calendar;

public class Pedido implements Serializable{

	private String codPedido;
	private Calendar fechaPedido;
	private String direccion;
	private String Ciudad;
	private String estado;
	private String idCliente;
	
	
	public Pedido() {}
	
	
	public Pedido(String codPedido, Calendar fechaPedido, String direccion, String ciudad, String estado,
			String idCliente) {
		
		this.codPedido = codPedido;
		this.fechaPedido = fechaPedido;
		this.direccion = direccion;
		Ciudad = ciudad;
		this.estado = estado;
		this.idCliente = idCliente;
	}



	public String getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	public Calendar getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Calendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
