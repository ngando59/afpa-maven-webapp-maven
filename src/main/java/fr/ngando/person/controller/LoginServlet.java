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

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final IPersonDao personDao = new PersonneDaoImpl();   
    @SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "login");
		request.getServletContext().getRequestDispatcher("/WEB-INF/person/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(personDao.isValideConnection(login, password)) {
			int connectedId = personDao.findByEmail(login).getId();
			session.setAttribute("connectedId", connectedId);
			session.setAttribute("login", login);
			session.setAttribute("isConnected", true);
			session.setAttribute("uGrant", personDao.findByEmail(login).getGrant());
			request.setAttribute("connexionFail", false);
			response.sendRedirect("account");
		} else {
			session.setAttribute("isConnected", false);
			request.setAttribute("connexionFail", true);
			doGet(request, response);
		}
	
	}

}
