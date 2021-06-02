package edu.laboratoriofpdual.dao;

/**
 * Clase paciente
 *
 * @author Cruz López Pérez
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente {

	private int codPac;
	private String nomPac;
	private String fecNac;
	private String dniPac;
	private String emailPac;
	private int tlfnPac;
	private String dirPac;
	private String codPostal;
	private String ciudad;

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
