package fr.ngando.person.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.person.business.IPersonBusiness;
import fr.ngando.person.business.impl.PersonBusinessImpl;
import fr.ngando.person.domain.Person;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IPersonBusiness personBuisness = new PersonBusinessImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(PersonServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "user");
		Person person = null;
		
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			person = personBuisness.findOneById(id);
		}
		request.setAttribute("person", person);
		request.getServletContext().getRequestDispatcher("/WEB-INF/person/view/person.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
