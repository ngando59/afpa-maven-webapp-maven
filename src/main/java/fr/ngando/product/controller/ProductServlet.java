package fr.ngando.product.controller;

import java.io.IOException;
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
 * Servlet implementation class Product
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final IProductBusiness productBusiness = new ProductBusinessImpl();
    @SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(ProductServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "products");
		Product product = null;
		if(request.getParameter("ref") != null) {
			product = productBusiness.findOneById(Integer.parseInt(request.getParameter("ref")));
		}
		request.setAttribute("product", product);
		request.getServletContext().getRequestDispatcher("/WEB-INF/product/view/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
