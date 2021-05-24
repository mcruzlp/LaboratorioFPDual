package edu.laboratoriofpdual.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import edu.laboratoriofpdual.conector.Conector;
import edu.laboratoriofpdual.dao.Cita;
import edu.laboratoriofpdual.dao.Paciente;
import edu.laboratoriofpdual.manager.CitaManager;
import edu.laboratoriofpdual.manager.impl.CitaManagerImpl;

public class CitaController {

	private CitaManager citaManager;

	public CitaController(CitaManagerImpl citaManagerImpl) {
		this.citaManager = citaManagerImpl;
	}

	public List<Cita> getAllCitas() throws ClassNotFoundException, SQLException {
		try (Connection con = new Conector().getMySQLConnection()) {
			List<Country> countries = new ArrayList<>();
			Country conun = new Country();
			Consumer<Cita> consu = data -> {
				countries.add(data.getCountry());
				System.out.println(conun);
			};
			citaManager.findAll(con).forEach(consu);

			return citaManager.findAll(con);
		}
	}
}
