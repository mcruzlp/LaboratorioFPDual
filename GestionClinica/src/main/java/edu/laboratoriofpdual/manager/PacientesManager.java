package edu.laboratoriofpdual.manager;

/**
 * Conexión con la tabla paciente.
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

import edu.laboratoriofpdual.dao.Paciente;

public class PacientesManager {

	public void addPaciente(Connection con, String nomPac, String fecNac,
			String dniPac, String emailPac, int tlfnPac, String dirPac, int codPostal, String ciudad) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO paciente (nomPac, fecNac, dniPac, emailPac, tlfnPac, dirPac, codPostal, ciudad)) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			prepStmt.setString(1, nomPac);
			prepStmt.setString(2, fecNac);
			prepStmt.setString(3, dniPac);
			prepStmt.setString(4, emailPac);
			prepStmt.setInt(5, tlfnPac);
			prepStmt.setString(6, dirPac);
			prepStmt.setInt(7, codPostal);
			prepStmt.setString(8, ciudad);
			prepStmt.executeUpdate();
			System.out.println("Los datos del paciente se han almacenado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePaciente(Connection con, String nomPac, String fecNac,
			String dniPac, String emailPac, int tlfnPac, String dirPac, int codPostal, String ciudad) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE paciente SET nomPac = ?, fecNac = ?, dniPac = ?, emailPac = ?, tlfnPac = ?, dirPac = ?, codPostal = ?, ciudad = ? WHERE nomPac = ?");
		prepStmt.setString(1, nomPac);
		prepStmt.setString(2, fecNac);
		prepStmt.setString(3, dniPac);
		prepStmt.setString(4, emailPac);
		prepStmt.setInt(5, tlfnPac);
		prepStmt.setString(6, dirPac);
		prepStmt.setInt(7, codPostal);
		prepStmt.setString(8, ciudad);
		System.out.println("Los datos del paciente se han actualizado correctamente");

		prepStmt.executeUpdate();
	}

	public void deletePaciente(Connection con, String nomPac, String dniPac, String emailPac) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM paciente WHERE nomPac = ? and dniPac = ? and emailPac = ?")) {
			prepStmt.setString(1, nomPac);
			prepStmt.setString(2, dniPac);
			prepStmt.setString(3, emailPac);
			prepStmt.executeUpdate();
			System.out.println("Los datos del paciente se han borrado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Paciente> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM paciente");
			result.beforeFirst();

			List<Paciente> pacientes = new ArrayList<>();

			while (result.next()) {
				pacientes.add(new Paciente(result));
			}

			return pacientes;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente findByName(Connection con, String nomPac) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM paciente WHERE nomPac = ?")) {

			prepStmt.setString(2, nomPac);

			ResultSet result = prepStmt.executeQuery();

			Paciente pacientes = null;
			if (result.next()) {
				pacientes = new Paciente(result);
			}
			return pacientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//TODO BUSCAR PACIENTE POR ESPECIALISTA
}
