package fr.ngando.category.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.category.dao.ICategoryDao;
import fr.ngando.category.domain.Category;
import fr.ngando.commons.daofactory.DaoFactory;

public class CategoryDaoImpl implements ICategoryDao {
	private DaoFactory daoFactory;
	
	private static final String SELECT_ALL = "SELECT * FROM tbl_category";
	private static final String SELECT_BY_ID = "SELECT * FROM tbl_category WHERE id = ?";
	private static final String SELECT_BY_TAG = "SELECT * FROM tbl_category WHERE tag = ?";
	private static Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);

	
	public CategoryDaoImpl() {
		this.daoFactory = new DaoFactory();
	}
	
	@Override
	public List<Category> findAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	        statement = connexion.createStatement();
	        resultat = statement.executeQuery(SELECT_ALL);
	        while (resultat.next()) {
	        	int id = resultat.getInt("id");
	        	String name = resultat.getString("name");
	        	String tag = resultat.getString("tag");
	            categories.add(new Category(id, name, tag));
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }  
		return categories;
	}

	@Override
	public Category findOneById(Integer id) {
		Category result = null;
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
	        	String fullname = resultat.getString("name");
	        	String tag = resultat.getString("tag");
	            result = new Category(rid, fullname, tag);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return result;
	}

	@Override
	public Category findOneByTag(String tag) {
		Category result = null;
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_TAG);
	        preparedStatement.setString(1, tag);
	        resultat = preparedStatement.executeQuery();
	        if(resultat.next()) {
	        	int id = resultat.getInt("id");
	        	String fullname = resultat.getString("name");
	        	String rtag = resultat.getString("tag");
	            result = new Category(id, fullname, rtag);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return result;
	}

}
