package net.rokefeler.samplespring;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {

	private int idAdministrador;
	private String nombre;
	
	@Autowired
	private Direccion direccion;

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

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", direccion=" + direccion
				+ "]";
	}

	public void ImprimirDireccion() {
		System.out.println("Encino 201");
	}
}
