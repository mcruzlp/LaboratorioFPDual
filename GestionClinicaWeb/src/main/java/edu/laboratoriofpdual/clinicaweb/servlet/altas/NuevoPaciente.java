package edu.laboratoriofpdual.clinicaweb.servlet.altas;

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
 * Servlet implementation class NuevoPaciente
 */
public class NuevoPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPaciente() {
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
			String fecNac = request.getParameter("fecNac");
			String dniPac = request.getParameter("dniPac");
			String emailPac = request.getParameter("emailPac");
			int tlfnPac = Integer.valueOf(request.getParameter("tlfnPac"));
			String dirPac = request.getParameter("dirPac");
			int codPostal = Integer.valueOf(request.getParameter("codPostal"));
			String ciudad = request.getParameter("ciudad");
		
//			new PacientesManager().addPaciente(con, nomPac, fecNac,
//					dniPac, emailPac, tlfnPac, dirPac, codPostal, ciudad);
			

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

				response.sendRedirect("/jsp/pacientes.jsp");

			} catch (SQLException e) {
				e.printStackTrace();

				request.setAttribute("Mensaje", "No se han podido guardar los datos del paciente");
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
