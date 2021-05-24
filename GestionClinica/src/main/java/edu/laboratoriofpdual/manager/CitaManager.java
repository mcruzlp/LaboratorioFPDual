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
	 * Finds all the cities in the DB
	 * 
	 * @param con DB connection
	 * @return a {@link List} of {@link Cita}
	 */
	public List<Cita> findAll(Connection con);

	/**
	 * Find an specific cities from the DB
	 * 
	 * @param con DB connection
	 * @param id the city id
	 * @return a {@link List} of {@link Cita}
	 */
	public Cita findById(Connection con, int codCita);
}
