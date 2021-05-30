package edu.laboratoriofpdual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cita {

	private String codCita;
	private int codPac;
	private String notas;

	public int getCodPac() {
		return codPac;
	}

	public void setCodPac(int codPac) {
		this.codPac = codPac;
	}

	public String getCodCita() {
		return codCita;
	}

	public void setCodCita(String codCita) {
		this.codCita = codCita;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Cita() {

	}

	public Cita(ResultSet result) {
		try {
			this.codCita = result.getString("codCita");
			this.setCodPac(result.getInt(Paciente.getCodPac()));
			this.notas = result.getString("notas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
