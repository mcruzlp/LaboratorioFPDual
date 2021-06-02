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
 * Servlet implementation class NuevoUsuario
 */
public class NuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NuevoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try (Connection con = new Conector().getMySQLConnection()) {

			String nomEsp = request.getParameter("inputName");
			String especialidad = request.getParameter("inputEspecialidad");
			String emailEsp = request.getParameter("inputEmail");
			int tlfnEsp = Integer.valueOf(request.getParameter("inputTlfn"));
			String passw = request.getParameter("inputPassword");

			try (PreparedStatement prepStmt = con.prepareStatement(
					"INSERT INTO especialista (nomEsp, especialidad, emailEsp, tlfnEsp, passw) VALUES (?, ?, ?, ?, ?)")) {
				prepStmt.setString(1, nomEsp);
				prepStmt.setString(2, especialidad);
				prepStmt.setString(3, emailEsp);
				prepStmt.setInt(4, tlfnEsp);
				prepStmt.setString(5, passw);
				prepStmt.executeUpdate();

				response.sendRedirect("/clinicaweb/jsp/index.jsp");

			} catch (SQLException e) {
				e.printStackTrace();

				request.setAttribute("Mensaje", "El usuario no ha podido crearse");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clinicaweb/jsp/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("Mensaje", "Error en el servidor");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clinicaweb/jsp/index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
