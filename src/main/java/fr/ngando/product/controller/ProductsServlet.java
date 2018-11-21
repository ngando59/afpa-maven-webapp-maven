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

import fr.ngando.category.business.ICategoryBusiness;
import fr.ngando.category.business.impl.CategoryBusinessImpl;
import fr.ngando.category.domain.Category;
import fr.ngando.product.business.IProductBusiness;
import fr.ngando.product.business.impl.ProductBusinessImpl;
import fr.ngando.product.domain.Product;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IProductBusiness productBuisness = new ProductBusinessImpl();
	private static final ICategoryBusiness categoryBusiness = new CategoryBusinessImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(ProductsServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "products");
		List<Product> products = null;
		List<Category> categories = null;
		
		products = productBuisness.findAll();
		categories = categoryBusiness.findAll();
		String itemsTitle = "Tous nos produits";
		
		if(request.getParameter("url") != null) {
			String tag = request.getParameter("url");
			products = productBuisness.findAllByTag(tag);
			itemsTitle = categoryBusiness.findOneByTag(tag).getName();	
			
		}	
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("itemsTitle", itemsTitle);
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.getServletContext().getRequestDispatcher("/WEB-INF/product/view/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
