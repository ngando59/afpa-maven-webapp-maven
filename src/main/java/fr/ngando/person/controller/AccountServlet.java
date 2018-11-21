package fr.ngando.person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.person.dao.IPersonDao;
import fr.ngando.person.dao.impl.PersonneDaoImpl;
import fr.ngando.person.domain.Person;


/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IPersonDao personDao = new PersonneDaoImpl(); 
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(AccountServlet.class);
		
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "account");
		Person person = null;

		HttpSession session = request.getSession();	
		if(session.getAttribute("connectedId") != null) {
			int userid = (Integer) session.getAttribute("connectedId");
			person = personDao.findOneById(userid);
		} 

		request.setAttribute("person", person);
		request.getServletContext().getRequestDispatcher("/WEB-INF/person/view/account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
