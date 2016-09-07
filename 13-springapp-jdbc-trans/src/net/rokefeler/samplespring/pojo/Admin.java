package net.rokefeler.samplespring.pojo;

import java.sql.Timestamp;


public class Admin {

	private int idAd;
	private String nombre;
	private String cargo;
	private Timestamp fechacreacion;
	
	public Admin() {
		super();
	}
	

	public Admin(int idAd, String nombre, String cargo, Timestamp fechacreacion) {
		this.idAd = idAd;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechacreacion = fechacreacion;
	}


	public Admin(String nom, String car, Timestamp ts) {
		nombre=nom;
		cargo=car;
		fechacreacion=ts;
	}

	public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechacreacion="
				+ fechacreacion + "]\n";
	}

}
