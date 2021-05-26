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

		int codCita;
		Paciente codPac;
		String notas;

		public Cita() {
			
		}
		public Cita(ResultSet result) {
			try {
				this.codCita = result.getInt("codCita");
				//this.codPac = result.getPaciente("codPac");
				this.notas = result.getString("notas");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public int getCodCita() {
			return codCita;
		}
		public Paciente getCodPac(Cita apointment) {
			return this.codPac;
		}
		public void setPaciente(Paciente paciente) {
			this.codPac=codPac;
		}

		
}
