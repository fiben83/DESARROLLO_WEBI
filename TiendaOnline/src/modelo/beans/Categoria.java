package modelo.beans;

import java.io.Serializable;

public class Categoria implements Serializable{

	private String idCategoria;
	private String nomCategoria;
	private String descripcion;
	
	
	public Categoria() {}
		
	public Categoria(String nomCategoria, String descripcion) {
				
		this.nomCategoria = nomCategoria;
		this.descripcion = descripcion;
	}
	
	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
