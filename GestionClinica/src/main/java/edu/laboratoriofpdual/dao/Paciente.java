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
	int fecNac;
	String dniPac;
	String emailPac;
	int tlfnPac;
	String dirPac;
	int codPostal;
	String ciudad;
	
	public Paciente() {
		
	}
	
	public Paciente(ResultSet result) {
		try {
			this.codPac = result.getInt("codPac");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
