package fr.ngando.product.controller.admin;

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
import fr.ngando.type.business.ITypeBusiness;
import fr.ngando.type.business.impl.TypeBusinnesImpl;
import fr.ngando.type.domain.Type;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IProductBusiness productsBusiness = new ProductBusinessImpl(); 
	private static final ICategoryBusiness categoryBusiness = new CategoryBusinessImpl();
	private static final ITypeBusiness typeBusiness = new TypeBusinnesImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(AddProductServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = categoryBusiness.findAll();
		List<Type> allPublics = typeBusiness.findAll();
		request.setAttribute("categories", categories);
		request.setAttribute("allPublics", allPublics);
		request.getServletContext().getRequestDispatcher("/WEB-INF/admin/view/add-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String thumbnail = request.getParameter("thumbnail");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		int public_id = Integer.valueOf(request.getParameter("public"));
		int category_id = Integer.valueOf(request.getParameter("category"));
		
		Product product = new Product(title, thumbnail, description, price, public_id, category_id);
		productsBusiness.add(product);
		response.sendRedirect("administration");
	}

}
