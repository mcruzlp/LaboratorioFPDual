package edu.laboratoriofpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.laboratoriofpdual.dao.Cita;
import edu.laboratoriofpdual.dao.Paciente;
import edu.laboratoriofpdual.manager.CitaManager;

public class CitaManagerImpl implements CitaManager{

	/**
	 * En cuentra todas las citas en la BBDD
	 * 
	 * @param con DB connection
	 * @return a {@link List} of {@link Cita}
	 */
	public List<Cita> findAll(Connection con) {
		// Create general statement
		try (Statement stmt = con.createStatement()) {
			// Queries the DB
			ResultSet result = stmt.executeQuery("SELECT * FROM Cita");
			// Set before first registry before going through it.
			result.beforeFirst();

			// Initializes variables
			List<Cita> citas = new ArrayList<>();
			Map<Integer, String> pacientes = new HashMap();

			// Run through each result
			while (result.next()) {
				// Initializes a cita per result
				citas.add(new Cita(result));
				// Groups the pacientes by cita
				pacientes.put(result.getInt("codPac"), result.getString("codPac"));
			}

			// Fills the country of each city
			fillPacientes(con, pacientes, citas);

			return citas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Find an specific cities from the DB
	 * 
	 * @param con DB connection
	 * @param id the city id
	 * @return a {@link List} of {@link City}
	 */
	public Cita findById(Connection con, int id) {
		//prepare SQL statement
		String sql = "select * " 
	               + "from cita a, Paciente b "
				   + "where a.codCita = ? "
				   + "and a.codPac = b.codPac";

		// Create general statement
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			//Add Parameters
			stmt.setInt(1, id);
			// Queries the DB
			ResultSet result = stmt.executeQuery();
			// Set before first registry before going through it.
			result.beforeFirst();

			// Initialize variable
			Cita cita = null;

			// Run through each result
			while (result.next()) {
				// Initializes a city per result
				cita = new Cita(result);
				Paciente paciente = new Paciente(result);
				cita.setPaciente(paciente);
			}

			return cita;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Fills all the countries for each city.
	 * 
	 * @param con       the Db connection
	 * @param countries the map of cities and countries.
	 * @param cities    the list of cities to update.
	 */
	private void fillPacientes(Connection con, Map<Integer, String> pacientes, List<Cita> citas) {
		// Obtains all the country codes to search
		Set<String> codPac = new HashSet<>(pacientes.values());

		// Looks for all pacientes and groups them by id.
		Map<Integer, Paciente> pacientesMap = new PacienteManagerImpl().findAllById(con, codPac).stream()
				.collect(Collectors.toMap(Paciente::getCodPac, data -> data));

		// Associates the corresponding Paciente to each Cita
		citas.forEach(cita -> {
			cita.getCodPac(cita);
			Paciente foundPaciente = pacientesMap.get(codPac);
			cita.setPaciente(foundPaciente);
		});

	}


}
