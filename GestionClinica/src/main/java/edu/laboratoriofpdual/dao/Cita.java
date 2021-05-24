package edu.laboratoriofpdual.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cita /*implements Comparable<Cita>*/{

		int codCita;
		Paciente codPac;
		String notas;

		public Cita() {
			
		}
		public Cita(ResultSet result) {
			try {
				this.codCita = result.getInt("codCita");
				//this.codPac = result.getInt("codPac");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//		@Override
//		public int compareTo(Cita o) {
//			return this.codCita.compareTo(o.getCodCita());
//		}
}
