package edu.laboratoriofpdual.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.laboratoriofpdual.dao.Cita;
import edu.laboratoriofpdual.dao.Paciente;

public class CitasManager {
	
	public void addCita(Connection con, String codCita, int nomPac) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO cita (codCita, nomPac) VALUES (?, ?)")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, codCita);
			prepStmt.setInt(2, nomPac); //TODO VERIFICAR PACIENTE EXISTENTE
			prepStmt.executeUpdate();
			System.out.println("Los datos de la cita se han almacenado correctamente");
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCita(Connection con, Cita c) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE cita SET codCita = ? WHERE codCita = ?");
		prepStmt.setString(1, c.getCodCita());
		System.out.println("Los datos de la cita se han actualizado correctamente");

		prepStmt.executeUpdate();
		prepStmt.close();
	}
	
	public void updateCita(Connection con, Paciente p) throws SQLException {
		PreparedStatement prepStmt = con
				.prepareStatement("UPDATE cita SET codPac = ? WHERE codPac = ?");
		prepStmt.setInt(1, p.getCodPac());
		System.out.println("Los datos de la cita se han actualizado correctamente");

		prepStmt.executeUpdate();
		prepStmt.close();
	}

	public void deleteCita(Connection con, String codCita) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM cita WHERE codCita = ?")) {
			con.setAutoCommit(false);
			prepStmt.setString(1, codCita);
			prepStmt.executeUpdate();
			System.out.println("Los datos de la cita se han borrado correctamente");
			
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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

	public Cita findByDate(Connection con, String codCita) {
		try (PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM cita WHERE codCita = ?")) {

			prepStmt.setString(1, codCita);

			ResultSet result = prepStmt.executeQuery();

			Cita citas = null;
			if (result.next()) {
				citas = new Cita(result);
			}
			return citas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public List<Cita> findAll(Connection con, Set<String> ids) {
//		String sql = String.format("SELECT * FROM cita",
//				ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining("\n")));
//
//		try (Statement stmt = con.createStatement()) {
//			ResultSet result = stmt.executeQuery(sql);
//			result.beforeFirst();
//
//			List<Cita> citas = new ArrayList<>();
//
//			while (result.next()) {
//				citas.add(new Cita(result));
//			}
//
//			return citas;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
