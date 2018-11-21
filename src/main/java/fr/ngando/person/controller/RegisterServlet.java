package fr.ngando.person.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.person.dao.IPersonDao;
import fr.ngando.person.dao.impl.PersonneDaoImpl;
import fr.ngando.person.domain.Person;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IPersonDao personDao = new PersonneDaoImpl(); 
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(RegisterServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "login");
		if(request.getAttribute("adduser") != null) {
			if((Boolean)request.getAttribute("adduser")) {
				request.setAttribute("adduser", true);
			}
		} 
		if(request.getAttribute("ErrorAlreadyExistsUser") != null) {
			if((Boolean)request.getAttribute("ErrorAlreadyExistsUser")) {
				request.setAttribute("ErrorAlreadyExistsUser", true);
			}
		} 
		request.getServletContext().getRequestDispatcher("/WEB-INF/person/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String civilite = request.getParameter("civilite");
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String adress = request.getParameter("adress");
		String town = request.getParameter("town");
		String department = request.getParameter("department");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");

		Person person = new Person(civilite, name, firstname, birthday, email, password, phone, adress, town, department, country);
		if(personDao.exists(email)) {
			request.setAttribute("ErrorAlreadyExistsUser", true);
		} else {
			personDao.add(person);
			request.setAttribute("adduser", true);
		}
	
		doGet(request, response);
	}

}
