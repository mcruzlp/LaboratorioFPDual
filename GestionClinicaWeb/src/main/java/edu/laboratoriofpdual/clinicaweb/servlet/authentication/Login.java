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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		try (Connection con = new Conector().getMySQLConnection()) {

			String email = request.getParameter("inputEmail");
			String passw = request.getParameter("inputPassword");
			Especialista esp = new EspecialistasManager().findByUser(con, email, passw);

			if (esp != null) {
				response.sendRedirect("/clinicaweb/jsp/citas.jsp");
			} else {
				request.setAttribute("Mensaje", "Usuario incorrecto");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("Mensaje", "Error en el servidor");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
