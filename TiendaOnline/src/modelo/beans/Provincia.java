package modelo.beans;

import java.io.Serializable;

public class Provincia implements Serializable {

	private String codProvincia;
	private String nomProvincia;
	private String codDepartamento;
	
		
	public Provincia() {
		
	}
	public Provincia(String codProvincia, String nomProvincia, String codDepartamento) {
		
		this.codProvincia = codProvincia;
		this.nomProvincia = nomProvincia;
		this.codDepartamento = codDepartamento;
	}
	public String getCodProvincia() {
		return codProvincia;
	}
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}
	public String getNomProvincia() {
		return nomProvincia;
	}
	public void setNomProvincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}
	public String getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	
}
