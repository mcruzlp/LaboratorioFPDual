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
	
	int codEsp;
	String nomEsp;
	String ape1Esp;
	String ape2Esp;
	String especialidad;
	String emailEsp;
	int tlfnEsp;
	
	public Especialista() {
		
	}
	
	public Especialista(ResultSet result) {
		try {
			this.codEsp = result.getInt("codEsp");
			this.nomEsp = result.getString("nomEsp");
			this.ape1Esp = result.getString("ape1Esp");
			this.ape2Esp = result.getString("ape2Esp");
			this.especialidad = result.getString("especialidad");
			this.emailEsp = result.getString("emailEsp");
			this.tlfnEsp = result.getInt("tlfnEsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getCodEsp() {
		return this.codEsp;
	}
}
