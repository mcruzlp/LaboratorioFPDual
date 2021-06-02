package edu.laboratoriofpdual.clinicaweb.servlet.bajas;

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
 * Servlet implementation class BorrarPaciente
 */
public class BorrarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarPaciente() {
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
		//doGet(request, response);
		try (Connection con = new Conector().getMySQLConnection()) {

			String nomPac = request.getParameter("nomPac");
			String dniPac = request.getParameter("dniPac");
			String emailPac = request.getParameter("emailPac");
		
//			new PacientesManager().deletePaciente(con, nomPac, dniPac, emailPac);
			

			try (PreparedStatement prepStmt = con.prepareStatement(
					"DELETE FROM paciente WHERE nomPac = ? and dniPac = ? and emailPac = ?")) {
				prepStmt.setString(1, nomPac);
				prepStmt.setString(2, dniPac);
				prepStmt.setString(3, emailPac);
				prepStmt.executeUpdate();

				response.sendRedirect("/jsp/pacientes.jsp");

			} catch (SQLException e) {
				e.printStackTrace();

				request.setAttribute("Mensaje", "No se han podido borrar los datos del paciente");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/pacientes.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("Mensaje", "Error en el servidor");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/pacientes.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
