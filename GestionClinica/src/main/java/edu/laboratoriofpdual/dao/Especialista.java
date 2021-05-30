package edu.laboratoriofpdual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Especialista {

	private int codEsp;
	private String nomEsp;
	private String especialidad;
	private String emailEsp;
	private int tlfnEsp;
	
	

	public int getCodEsp() {
		return codEsp;
	}

	public void setCodEsp(int codEsp) {
		this.codEsp = codEsp;
	}

	public String getNomEsp() {
		return nomEsp;
	}

	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getEmailEsp() {
		return emailEsp;
	}

	public void setEmailEsp(String emailEsp) {
		this.emailEsp = emailEsp;
	}

	public int getTlfnEsp() {
		return tlfnEsp;
	}

	public void setTlfnEsp(int tlfnEsp) {
		this.tlfnEsp = tlfnEsp;
	}

	public Especialista() {

	}

	public Especialista(ResultSet result) {
		try {
			this.codEsp = result.getInt("codEsp");
			this.nomEsp = result.getString("nomEsp");
			this.especialidad = result.getString("especialidad");
			this.emailEsp = result.getString("emailEsp");
			this.tlfnEsp = result.getInt("tlfnEsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
