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
	String emailPac;
	int tlfnPac;
	
	public Especialista() {
		
	}
	
	public Especialista(ResultSet result) {
		try {
			this.codEsp = result.getInt("codEsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
