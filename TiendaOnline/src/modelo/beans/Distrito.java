package modelo.beans;

import java.io.Serializable;

public class Distrito implements Serializable {

	private String codDistrito;
	private String nomDistrito;
	private String codProvincia;
	
		
	public Distrito() {
		
	}
	public Distrito(String codDistrito, String nomDistrito, String codProvincia) {
		
		this.codDistrito = codDistrito;
		this.nomDistrito = nomDistrito;
		this.codProvincia = codProvincia;
	}
	public String getCodDistrito() {
		return codDistrito;
	}
	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public String getCodProvincia() {
		return codProvincia;
	}
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}
	
	
}
