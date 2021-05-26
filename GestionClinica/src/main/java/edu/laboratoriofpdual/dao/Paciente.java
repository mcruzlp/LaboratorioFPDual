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
	
	int codPac;
	String nomPac;
	String ape1Pac;
	String ape2Pac;
	String fecNac;
	String dniPac;
	String emailPac;
	int tlfnPac;
	String dirPac;
	String codPostal;
	String ciudad;
	
	public Paciente() {
		
	}
	
	public Paciente(ResultSet result) {
		try {
			this.codPac = result.getInt("codPac");
			this.nomPac = result.getString("nomPac");
			this.ape1Pac = result.getString("ape1Pac");
			this.ape2Pac = result.getString("ape2Pac");
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


	public int getCodPac() {
		return this.codPac;
	}
}
