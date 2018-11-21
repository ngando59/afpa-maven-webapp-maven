package fr.ngando.type.dao.impl;

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
import fr.ngando.type.business.impl.TypeBusinnesImpl;
import fr.ngando.type.dao.ITypeDao;
import fr.ngando.type.domain.Type;

public class TypeDaoImpl implements ITypeDao {	
	
	private DaoFactory daoFactory;
	
	private static final String SELECT_ALL = "SELECT * FROM tbl_public";
	private static final String SELECT_BY_ID = "SELECT * FROM tbl_public WHERE id = ?";
	private static final String SELECT_BY_NAME = "SELECT * FROM tbl_public WHERE name = ?";
	private static Logger LOGGER = LoggerFactory.getLogger(TypeBusinnesImpl.class);
	
	public TypeDaoImpl() {
		this.daoFactory = new DaoFactory();
	}
	
	@Override
	public List<Type> findAll() {
		ArrayList<Type> types = new ArrayList<Type>();
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
	        	types.add(new Type(id, name));
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }  
		return types;
	}

	@Override
	public Type findOneById(Integer id) {
		Type result = null;
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
	        	String name = resultat.getString("name");
	            result = new Type(rid, name);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return result;
	}

	@Override
	public Type findOneByName(String name) {
		Type result = null;
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_NAME);
	        preparedStatement.setString(1, name);
	        resultat = preparedStatement.executeQuery();
	        if(resultat.next()) {
	        	int rid = resultat.getInt("id");
	        	String rname = resultat.getString("name");
	            result = new Type(rid, rname);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return result;
	}

}
