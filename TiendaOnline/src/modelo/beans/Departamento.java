package modelo.beans;

public class Departamento {

	private String codDepartamento;
	private String nomDepartamento;
		
	public Departamento() {
		
	}
	public Departamento(String codDepartamento, String nomDepartamento) {
		
		this.codDepartamento = codDepartamento;
		this.nomDepartamento = nomDepartamento;
	}
	public String getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	public String getNomDepartamento() {
		return nomDepartamento;
	}
	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}
	
}
