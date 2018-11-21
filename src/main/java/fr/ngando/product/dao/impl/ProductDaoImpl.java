package fr.ngando.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.commons.daofactory.DaoFactory;
import fr.ngando.product.dao.IProductDao;
import fr.ngando.product.domain.Product;

public class ProductDaoImpl implements IProductDao {
	
	private DaoFactory daoFactory;
	
	private static final String SELECT_ALL = "SELECT * FROM tbl_product";
	private static final String SELECT_BY_ID = "SELECT * FROM tbl_product WHERE id = ?";
	private static final String SELECT_BY_TAG = "SELECT * FROM tbl_product INNER JOIN tbl_category ON tbl_product.category_id = tbl_category.id WHERE tbl_category.tag = ? ";
	private static final String ADD = "INSERT INTO tbl_product(title, thumbnail, description, price, public_id, category_id) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE tbl_product SET title = ?, thumbnail = ?, description = ?, price = ?, public_id = ?, category_id = ? WHERE id = ? ";
	private static final String DELETE = "DELETE FROM tbl_product WHERE id=? ";
	private static Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	
	public ProductDaoImpl() {
		this.daoFactory = new DaoFactory();
	}

	@Override
	public List<Product> findAll() {
		ArrayList<Product> products = new ArrayList<Product>();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	        statement = connexion.createStatement();
	        resultat = statement.executeQuery(SELECT_ALL);
	        while (resultat.next()) {
	        	int id = resultat.getInt("id");
	        	String title = resultat.getString("title");
	            String thumbnail = resultat.getString("thumbnail");
	            String description = resultat.getString("description");
	            Double price = resultat.getDouble("price");
	            int public_id = resultat.getInt("public_id");
	            int categoy_id = resultat.getInt("category_id");
	            Product product = new Product(id, title, thumbnail, description, price, public_id, categoy_id);
	            products.add(product);
	        }
	    } catch (Exception e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
	    return products;
	}

	@Override
	public Product findOneById(Integer id) {
		Product result = null;
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_ID);
	        preparedStatement.setInt(1, id);
	        resultat = preparedStatement.executeQuery();
	        if(resultat.next()) {
	        	int rid = resultat.getInt("id");
	        	String title = resultat.getString("title");
	            String thumbnail = resultat.getString("thumbnail");
	            String description = resultat.getString("description");
	            Double price = resultat.getDouble("price");
	            int public_id = resultat.getInt("public_id");
	            int categoy_id = resultat.getInt("category_id");
	            result = new Product(rid, title, thumbnail, description, price, public_id, categoy_id);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return result;
	}

	@Override
	public List<Product> findAllByTag(String tag) {
		ArrayList<Product> products = new ArrayList<Product>();
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_TAG);
	        preparedStatement.setString(1, tag);
	        resultat = preparedStatement.executeQuery();
	        while(resultat.next()) {
	        	int rid = resultat.getInt("id");
	        	String title = resultat.getString("title");
	            String thumbnail = resultat.getString("thumbnail");
	            String description = resultat.getString("description");
	            Double price = resultat.getDouble("price");
	            int public_id = resultat.getInt("public_id");
	            int categoy_id = resultat.getInt("category_id");
	            Product product = new Product(rid, title, thumbnail, description, price, public_id, categoy_id);
	            products.add(product);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return products;
	}
	
	@Override
	public void add(Product product) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(ADD);	 
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getThumbnail());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getPublic_id());
			preparedStatement.setInt(6, product.getCategory_id());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LOGGER.info("Exception : ",e);
	    }	
	}

	@Override
	public void remove(Product product) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(DELETE);	 
			preparedStatement.setInt(1, product.getId());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	@Override
	public void update(Product product) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(UPDATE);	 
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getThumbnail());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getPublic_id());
			preparedStatement.setInt(6, product.getCategory_id());
			preparedStatement.setInt(7, product.getId());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
	}
}
