package edu.laboratoriofpdual.clinicaweb.servlet.modificaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.laboratoriofpdual.conector.Conector;

/**
 * Servlet implementation class ModificaCita
 */
public class ModificaCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCita() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	// doGet(request, response);
			try (Connection con = new Conector().getMySQLConnection()) {

				String codCita = request.getParameter("codCita");

				try (PreparedStatement prepStmt = con.prepareStatement(
						"UPDATE cita SET codCita = ? WHERE codCita = ?")) {
					prepStmt.setString(1, codCita);
					
					prepStmt.executeUpdate();

					response.sendRedirect("/clinicaweb/jsp/citas.jsp");

				} catch (SQLException e) {
					e.printStackTrace();

					request.setAttribute("Mensaje", "No se han podido actualizar los datos del paciente");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clinicaweb/jsp/citas.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("Mensaje", "Error en el servidor");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clinicaweb/jsp/citas.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}
	}

}
