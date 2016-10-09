package modelo.beans;

import java.io.Serializable;
import java.util.UUID;

public class Tienda implements Serializable{

	private String codTienda;
	private String nomTienda;
	private String tipoTienda;
	private String direccion;
	private String telefono;
	
		
	public Tienda() {
		
	}
	
	
	public Tienda(String codTienda,String nomTienda, String tipoTienda, String direccion, String telefono) {
		this.codTienda=codTienda;
		this.nomTienda = nomTienda;
		this.tipoTienda = tipoTienda;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	
	public String getCodTienda() {
		return codTienda;
	}

	public void setCodTienda(String codTienda) {
		this.codTienda = codTienda;
	}


	public String getNomTienda() {
		return nomTienda;
	}
	public void setNomTienda(String nomTienda) {
		this.nomTienda = nomTienda;
	}
	public String getTipoTienda() {
		return tipoTienda;
	}
	public void setTipoTienda(String tipoTienda) {
		this.tipoTienda = tipoTienda;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
