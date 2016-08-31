package net.rokefeler.samplespring;

public class Administrador {

	private int idAdministrador;
	private String nombre;

	public Administrador() {

	}

	public Administrador(int idAdministrador, String nombre) {
		this.idAdministrador = idAdministrador;
		this.nombre = nombre;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", nombre=" + nombre + "]";
	}

	public void ImprimirDireccion() {
		System.out.println("Encino 201");
	}
}
