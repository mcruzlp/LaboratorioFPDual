package edu.laboratoriofpdual.dao;

/**
 * Clase cita
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
public class Cita {

	private String codCita;
	private int codPac;
	private String notas;

	public Cita(ResultSet result) {
		try {
			this.codCita = result.getString("codCita");
			this.codPac = result.getInt("codPac");
			this.notas = result.getString("notas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
