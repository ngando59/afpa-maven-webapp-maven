package fr.ngando.admin.controller;

import java.io.IOException;
import java.util.List;

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
import fr.ngando.product.business.IProductBusiness;
import fr.ngando.product.business.impl.ProductBusinessImpl;
import fr.ngando.product.domain.Product;

/**
 * Servlet implementation class AdministrationServlet
 */
@WebServlet("/administration")
public class AdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IProductBusiness productBuisiness = new ProductBusinessImpl();
	private static final IPersonBusiness personBusiness = new PersonBusinessImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(AdministrationServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "admin");
		List<Person> persons = personBusiness.findAll();
		List<Product> products = productBuisiness.findAll();
		request.setAttribute("persons", persons);
		request.setAttribute("products", products);
		request.getServletContext().getRequestDispatcher("/WEB-INF/admin/view/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
