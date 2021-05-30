package edu.laboratoriofpdual.main;

import java.sql.Connection;
import java.sql.SQLException;
import edu.laboratoriofpdual.conector.Conector;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connects to the DB
		Connection con = new Conector().getMySQLConnection();
		try {
//			Comprueba que está conectada a la base de datos
//			System.out.println(con.getCatalog());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
