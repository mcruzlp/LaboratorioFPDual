package edu.laboratoriofpdual.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import edu.laboratoriofpdual.dao.Paciente;

public class PacienteManagerImpl {

	public List<Paciente> findAllById(Connection con, Set<String> ids) {
		String sql = String.format("SELECT * FROM Paciente WHERE codPac in (%s)",
				ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining("\n")));
		
		try (Statement stmt = con.createStatement()){
			ResultSet result = stmt.executeQuery(sql);
			result.beforeFirst();
			
			List<Paciente> pacientes = new ArrayList<>();

			// Run through each result
			while (result.next()) {
				// Initializes a country per result
				pacientes.add(new Paciente(result));
			}

			return pacientes;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*public List<Paciente> findByEspecialista(Connection con, int codEsp) throws SQLException {

		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM Paciente where codCita = ANY (SELECT
			codEsp FROM Cita where codEsp between ? and ?")) {
			prepStmt.setInt(1, codEsp);
			
			return prepareReturn(prepStmt.executeQuery());
		}

	}
	
	private List<Paciente> prepareReturn(ResultSet result) throws SQLException{

		List<Paciente> pacientes = new ArrayList<>();
		
		while(result.next()) {
			pacientes.add(new Paciente(result));
		}
		
		return pacientes;
	}*/
 
}
