package edu.laboratoriofpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.laboratoriofpdual.dao.Especialista;

public class EspecialistasManager {
	
	public void addEspecialista(Connection con, int codEsp, String nomEsp, String especialidad, String emailEsp, int tlfnEsp) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO especialista (codEsp, nomEsp, especialidad, emailEsp, tlfnEsp)) VALUES (?, ?, ?, ?, ?, ?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, codEsp);
			prepStmt.setString(2, nomEsp);
			prepStmt.setString(3, especialidad);
			prepStmt.setString(4, emailEsp);
			prepStmt.setInt(5, tlfnEsp);
			prepStmt.executeUpdate();
			System.out.println("Los datos del especialista se han almacenado correctamente");
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEspecialista(Connection con, Especialista e) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE especialista SET nomEsp = ?, especialidad = ?, emailEsp = ?, tlfnEsp = ? WHERE nomEsp = ?");
		prepStmt.setString(1, e.getNomEsp());
		prepStmt.setString(2, e.getEspecialidad());
		prepStmt.setString(3, e.getEmailEsp());
		prepStmt.setInt(4, e.getTlfnEsp());
		System.out.println("Los datos del especialista se han actualizado correctamente");

		prepStmt.executeUpdate();
		prepStmt.close();
	}

	public void deleteEspecialista(Connection con, String nomEsp) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM especialista WHERE nomEsp = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, nomEsp);
			prepStmt.executeUpdate();
			System.out.println("Los datos del especialista se han borrado correctamente");
			
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Especialista> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM especialista");
			result.beforeFirst();

			List<Especialista> especialistas = new ArrayList<>();

			while (result.next()) {
				especialistas.add(new Especialista(result));
			}

			return especialistas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Especialista findByName(Connection con, String nomEsp) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM especialista WHERE nomEsp = ?")) {

			prepStmt.setString(1, nomEsp);

			ResultSet result = prepStmt.executeQuery();

			Especialista especialistas = null;
			if (result.next()) {
				especialistas = new Especialista(result);
			}
			return especialistas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//TODO BUSCAR TODOS LOS ESPECIALISTAS QUE TRATEN A UN MISMO PACIENTE

//	public List<Especialista> findAll(Connection con, Set<String> ids) {
//		String sql = String.format("SELECT * FROM especialista",
//				ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining("\n")));
//
//		try (Statement stmt = con.createStatement()) {
//			ResultSet result = stmt.executeQuery(sql);
//			result.beforeFirst();
//
//			List<Especialista> especialistas = new ArrayList<>();
//
//			// Run through each result
//			while (result.next()) {
//				// Initializes a country per result
//				especialistas.add(new Especialista(result));
//			}
//
//			return especialistas;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
