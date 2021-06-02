package edu.laboratoriofpdual.manager;

/**
 * Conexión con la tabla cita.
 *
 * @author Cruz López Pérez
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.laboratoriofpdual.dao.Cita;

public class CitasManager {
	
	/**
	 * Crea una cita
	 *
	 *
	 */
	
	public void addCita(Connection con, String codCita, int codPac) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO cita (codCita, codPac) VALUES (?, ?)")) {
			prepStmt.setString(1, codCita);
			prepStmt.setInt(2, codPac); //TODO VERIFICAR PACIENTE EXISTENTE
			prepStmt.executeUpdate();
			System.out.println("Los datos de la cita se han almacenado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifica la fecha de la cita
	 *
	 *
	 */
	
	public void updateCita(Connection con, String codCita) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE cita SET codCita = ? WHERE codCita = ?");
		prepStmt.setString(1, codCita);
		System.out.println("Los datos de la cita se han actualizado correctamente");

		prepStmt.executeUpdate();
	}
	
	/**
	 * Borra la cita
	 *
	 *
	 */

	public void deleteCita(Connection con, String codCita) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM cita WHERE codCita = ?")) {
			prepStmt.setString(1, codCita);
			prepStmt.executeUpdate();
			System.out.println("Los datos de la cita se han borrado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Muestra todas las citas
	 *
	 *
	 */
	
	public List<Cita> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM cita");
			result.beforeFirst();

			List<Cita> citas = new ArrayList<>();

			while (result.next()) {
				citas.add(new Cita(result));
			}

			return citas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Muestra todas las citas de una fecha concreta
	 *
	 *
	 */

	public List<Cita> findByDate(Connection con, String codCita) {
		try (Statement stmt = con.createStatement()) {
	
			ResultSet result = stmt.executeQuery("SELECT * FROM cita WHERE codCita = ?");
			result.beforeFirst();

			List<Cita> c = new ArrayList<>();

			while (result.next()) {
				c.add(new Cita(result));
			}

			return c;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
