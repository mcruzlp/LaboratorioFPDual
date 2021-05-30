package edu.laboratoriofpdual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Paciente {

	private static int codPac;
	private String nomPac;
	private String fecNac;
	private String dniPac;
	private String emailPac;
	private int tlfnPac;
	private String dirPac;
	private String codPostal;
	private String ciudad;

	public static int getCodPac() {
		return codPac;
	}

	public String getNomPac() {
		return nomPac;
	}

	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}

	public String getFecNac() {
		return fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public String getDniPac() {
		return dniPac;
	}

	public void setDniPac(String dniPac) {
		this.dniPac = dniPac;
	}

	public String getEmailPac() {
		return emailPac;
	}

	public void setEmailPac(String emailPac) {
		this.emailPac = emailPac;
	}

	public int getTlfnPac() {
		return tlfnPac;
	}

	public void setTlfnPac(int tlfnPac) {
		this.tlfnPac = tlfnPac;
	}

	public String getDirPac() {
		return dirPac;
	}

	public void setDirPac(String dirPac) {
		this.dirPac = dirPac;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Paciente() {

	}

	public Paciente(ResultSet result) {
		try {
			this.codPac = result.getInt("codPac");
			this.nomPac = result.getString("nomPac");
			this.fecNac = result.getString("fecNac");
			this.dniPac = result.getString("dniPac");
			this.emailPac = result.getString("emailPac");
			this.tlfnPac = result.getInt("tlfnPac");
			this.dirPac = result.getString("dirPac");
			this.codPostal = result.getString("codPostal");
			this.ciudad = result.getString("ciudad");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
