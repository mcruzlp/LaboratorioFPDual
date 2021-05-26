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

public interface CitaManager {

	/**
	 * Encuentra todas las citas guardadas en la base de datos
	 * 
	 * @param con DB connection
	 * @return a {@link List} of {@link Cita}
	 */
	public List<Cita> findAll(Connection con); //{
//		try (Statement stmt = con.createStatement()) {
//			ResultSet result = stmt.executeQuery("SELECT * FROM Cita");
//			result.beforeFirst();//posiciona el puntero antes del dato que busco para asegurarme de que lee el intervalo completo
//			
//			List<Cita> citas = new ArrayList<>();
//			Map<Integer, String> pacientes = new HashMap();
//			
//			while (result.next()) {
//				citas.add(new Cita(result));
//				pacientes.put(result.getInt("codPac"), result.getString("dniPac"));
//			}
//			
//			fillPacientes(con, pacientes, citas);
//			return citas;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//}


	/**
	 * Find an specific citas from the DB
	 * 
	 * @param con DB connection
	 * @param id the city id
	 * @return a {@link List} of {@link Cita}
	 */
	public Cita findById(Connection con, int codCita);
}
