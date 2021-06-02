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
 * Servlet implementation class ModificaUsuario
 */
public class ModificaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaUsuario() {
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

				String nomEsp = request.getParameter("nomEsp");
				String especialidad = request.getParameter("especialidad");
				String emailEsp = request.getParameter("emailEsp");
				int tlfnEsp = Integer.valueOf(request.getParameter("tlfnEsp"));
				String passw = request.getParameter("passw");

//						new PacientesManager().addPaciente(con, nomPac, fecNac,
//								dniPac, emailPac, tlfnPac, dirPac, codPostal, ciudad);

				try (PreparedStatement prepStmt = con.prepareStatement(
						"UPDATE especialista SET nomEsp = ?, especialidad = ?, emailEsp = ?, tlfnEsp = ?, passw = ? WHERE nomEsp = ?")) {
						prepStmt.setString(1, nomEsp);
						prepStmt.setString(2, especialidad);
						prepStmt.setString(3, emailEsp);
						prepStmt.setInt(4, tlfnEsp);
						prepStmt.setString(5, passw);
						prepStmt.executeUpdate();

					response.sendRedirect("/jsp/especialistas.jsp");

				} catch (SQLException e) {
					e.printStackTrace();

					request.setAttribute("Mensaje", "No se han podido actualizar los datos del usuario");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/especialistas.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("Mensaje", "Error en el servidor");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/especialistas.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}
	}

}
