package edu.laboratoriofpdual.clinicaweb.servlet.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.laboratoriofpdual.conector.Conector;
import edu.laboratoriofpdual.dao.Especialista;
import edu.laboratoriofpdual.manager.EspecialistasManager;

/**
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forgot() {
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
		// doGet(request, response);
		try (Connection con = new Conector().getMySQLConnection()) {

			String emailEsp = request.getParameter("email");
			Especialista esp = new EspecialistasManager().findByEmail(con, emailEsp);

			if (esp != null) {
				response.sendRedirect("/clinicaweb/SendEmail.java");
			} else {
				request.setAttribute("Mensaje", "Este email no está en nuestra base de datos");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("Mensaje", "Error en el servidor");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
