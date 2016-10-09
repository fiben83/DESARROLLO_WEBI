package modelo.beans;

import java.io.Serializable;
import java.util.UUID;

public class Almacen implements Serializable{

	private String codAlmacen;
	private String nomAlmacen;
	private String descripcion;
	private String direccion;
	private int cantProductos;
	private String estado;
	
		
	public Almacen() {
		
	}
		
	public Almacen(String codAlmacen,String nomAlmacen, String descripcion, String direccion, int cantProductos, String estado) {
		this.codAlmacen=codAlmacen;
		this.nomAlmacen = nomAlmacen;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.cantProductos = cantProductos;
		this.estado = estado;
	}

		
	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getNomAlmacen() {
		return nomAlmacen;
	}
	public void setNomAlmacen(String nomAlmacen) {
		this.nomAlmacen = nomAlmacen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCantProductos() {
		return cantProductos;
	}
	public void setCantProductos(int cantProductos) {
		this.cantProductos = cantProductos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
