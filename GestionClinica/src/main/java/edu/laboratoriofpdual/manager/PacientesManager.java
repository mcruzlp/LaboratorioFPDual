package edu.laboratoriofpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.laboratoriofpdual.dao.Paciente;

public class PacientesManager {

	public void addPaciente(Connection con, int codPac, String nomPac, String fecNac,
			String dniPac, String emailPac, int tlfnPac, String dirPac, String codPostal, String ciudad) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO paciente (codPac, nomPac, fecNac, dniPac, emailPac, tlfnPac, dirPac, codPostal, ciudad)) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, codPac);
			prepStmt.setString(2, nomPac);
			prepStmt.setString(3, fecNac);
			prepStmt.setString(4, dniPac);
			prepStmt.setString(5, emailPac);
			prepStmt.setInt(6, tlfnPac);
			prepStmt.setString(7, dirPac);
			prepStmt.setString(8, codPostal);
			prepStmt.setString(9, ciudad);
			prepStmt.executeUpdate();
			System.out.println("Los datos del paciente se han almacenado correctamente");
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePaciente(Connection con, Paciente pacientes) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE paciente SET nomPac = ?, fecNac = ?, dniPac = ?, emailPac = ?, tlfnPac = ?, dirPac = ?, codPostal = ?, ciudad = ? WHERE nomPac = ?");
		prepStmt.setString(1, pacientes.getNomPac());
		prepStmt.setString(2, pacientes.getFecNac());
		prepStmt.setString(3, pacientes.getDniPac());
		prepStmt.setString(4, pacientes.getEmailPac());
		prepStmt.setInt(5, pacientes.getTlfnPac());
		prepStmt.setString(6, pacientes.getDirPac());
		prepStmt.setString(7, pacientes.getCodPostal());
		prepStmt.setString(8, pacientes.getCiudad());
		System.out.println("Los datos del paciente se han actualizado correctamente");

		prepStmt.executeUpdate();
		prepStmt.close();
	}

	public void deletePaciente(Connection con, String nomPac) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM paciente WHERE nomPac = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, nomPac);
			prepStmt.executeUpdate();
			System.out.println("Los datos del paciente se han borrado correctamente");
			
			con.commit();

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
