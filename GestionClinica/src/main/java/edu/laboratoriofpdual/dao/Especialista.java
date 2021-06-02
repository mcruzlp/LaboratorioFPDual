package edu.laboratoriofpdual.dao;

/**
 * Clase especialista
 *
 * @author Cruz López Pérez
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialista {

	private int codEsp;
	private String nomEsp;
	private String especialidad;
	private String emailEsp;
	private int tlfnEsp;
	private String passw;

	@Override
	public String toString() {
		return "Usuario [" + codEsp + "]: " + nomEsp + "\n Especialidad: " + especialidad + "\n Email: "
				+ emailEsp + "\n Teléfono: " + tlfnEsp + "\n Contraseña: " + passw;
	}

	public Especialista(ResultSet result) {
		try {
			this.codEsp = result.getInt("codEsp");
			this.nomEsp = result.getString("nomEsp");
			this.especialidad = result.getString("especialidad");
			this.emailEsp = result.getString("emailEsp");
			this.tlfnEsp = result.getInt("tlfnEsp");
			this.passw = result.getString("passw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
