package fr.ngando.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.product.business.IProductBusiness;
import fr.ngando.product.business.impl.ProductBusinessImpl;
import fr.ngando.product.domain.Product;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IProductBusiness productsBusiness = new ProductBusinessImpl(); 
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(HomeServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "home");
		String user = "";	
		if( request.getParameter("user") != null ) {
			user = request.getParameter("user");
		}
		List<Product> products = productsBusiness.findAllByTag("fast-food");		
		request.setAttribute("user", user);
		request.setAttribute("products", products);
		request.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
