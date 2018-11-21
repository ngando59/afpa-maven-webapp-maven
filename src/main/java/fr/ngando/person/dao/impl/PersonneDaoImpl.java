package fr.ngando.person.dao.impl;

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
import fr.ngando.person.dao.IPersonDao;
import fr.ngando.person.domain.Person;

public class PersonneDaoImpl implements IPersonDao {

	private DaoFactory daoFactory;
	
	private static final String SELECT_ALL = "SELECT * FROM tbl_person";
	private static final String SELECT_BY_ID = "SELECT * FROM tbl_person WHERE id = ? ";
	private static final String SELECT_BY_MAIL = "SELECT * FROM tbl_person WHERE email = ? ";
	private static final String ADD = "INSERT INTO tbl_person(civilite, nom, prenom, dateNaissance, email, password, telephone, numeroEtRue, ville, departement, pays) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM tbl_person WHERE id = ? ";
	private static final String UPDATE = "UPDATE tbl_person SET civilite = ?, nom = ?, prenom = ?, dateNaissance = ?, email = ?, password = ?, telephone = ?, numeroEtRue = ?, ville = ?, departement = ?, pays = ? WHERE id = ? ";
	private static Logger LOGGER = LoggerFactory.getLogger(PersonneDaoImpl.class);
	
	public PersonneDaoImpl() {
		this.daoFactory = new DaoFactory();	
	}

	@Override
	public List<Person> findAll() {
		ArrayList<Person> persons = new ArrayList<Person>();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	        statement = connexion.createStatement();
	        resultat = statement.executeQuery(SELECT_ALL);
	        while (resultat.next()) {
	        	int id = resultat.getInt("id");
	        	String civilite = resultat.getString("civilite");
	        	String nom = resultat.getString("nom");
	        	String prenom = resultat.getString("prenom");
	        	String dateNaissance = resultat.getString("dateNaissance");
	        	String email = resultat.getString("email");
	        	String password = resultat.getString("password");
	        	String telephone = resultat.getString("telephone");
	        	String numeroEtRue = resultat.getString("numeroEtRue");
	        	String ville = resultat.getString("ville");
	        	String departement = resultat.getString("departement");
	        	String pays = resultat.getString("pays");
	        	String user_grant = resultat.getString("user_grant");
	        	Person person = new Person(id, civilite, nom, prenom, dateNaissance, email, password, telephone, numeroEtRue, ville, departement, pays);
	        	person.setGrant(user_grant);
	        	persons.add(person);
	        }
	    } catch (Exception e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
	    return persons;
	}

	@Override
	public Person findOneById(Integer id) {
		Person person = null;
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_ID);
	        preparedStatement.setInt(1, id);
	        resultat = preparedStatement.executeQuery();
	        if(resultat.next()) {
	        	String civilite = resultat.getString("civilite");
	        	String nom = resultat.getString("nom");
	        	String prenom = resultat.getString("prenom");
	        	String dateNaissance = resultat.getString("dateNaissance");
	        	String email = resultat.getString("email");
	        	String password = resultat.getString("password");
	        	String telephone = resultat.getString("telephone");
	        	String numeroEtRue = resultat.getString("numeroEtRue");
	        	String ville = resultat.getString("ville");
	        	String departement = resultat.getString("departement");
	        	String pays = resultat.getString("pays");
	        	String user_grant = resultat.getString("user_grant");
	        	person = new Person(id, civilite, nom, prenom, dateNaissance, email, password, telephone, numeroEtRue, ville, departement, pays);
	        	person.setGrant(user_grant);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return person;
	}

	@Override
	public Person findByEmail(String email) {
		Person person = null;
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	    	connexion = daoFactory.getConnection();
	    	preparedStatement = connexion.prepareStatement(SELECT_BY_MAIL);
	        preparedStatement.setString(1, email);
	        resultat = preparedStatement.executeQuery();
	        if(resultat.next()) {
	        	int rid = resultat.getInt("id");
	        	String civilite = resultat.getString("civilite");
	        	String nom = resultat.getString("nom");
	        	String prenom = resultat.getString("prenom");
	        	String dateNaissance = resultat.getString("dateNaissance");
	        	String password = resultat.getString("password");
	        	String telephone = resultat.getString("telephone");
	        	String numeroEtRue = resultat.getString("numeroEtRue");
	        	String ville = resultat.getString("ville");
	        	String departement = resultat.getString("departement");
	        	String pays = resultat.getString("pays");
	        	String user_grant = resultat.getString("user_grant");
	        	person = new Person(rid, civilite, nom, prenom, dateNaissance, email, password, telephone, numeroEtRue, ville, departement, pays);
	        	person.setGrant(user_grant);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	            LOGGER.info("Exception : ",e);
	    }
		return person;
	}

	@Override
	public void add(Person person) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(ADD);	 
			preparedStatement.setString(1, person.getCivilite());
			preparedStatement.setString(2, person.getNom());
			preparedStatement.setString(3, person.getPrenom());
			preparedStatement.setString(4, person.getDateNaissance());
			preparedStatement.setString(5, person.getEmail());
			preparedStatement.setString(6, person.getPassword());
			preparedStatement.setString(7, person.getTelephone());
			preparedStatement.setString(8, person.getNumeroEtRue());
			preparedStatement.setString(9, person.getVille());
			preparedStatement.setString(10, person.getDepartement());
			preparedStatement.setString(11, person.getPays());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LOGGER.info("Exception : ",e);
	    }		
	}

	@Override
	public void remove(Person person) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(DELETE);	 
			preparedStatement.setInt(1, person.getId());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LOGGER.info("Exception : ",e);
	    }			
	}

	@Override
	public void update(Person person) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(UPDATE);	 
			preparedStatement.setString(1, person.getCivilite());
			preparedStatement.setString(2, person.getNom());
			preparedStatement.setString(3, person.getPrenom());
			preparedStatement.setString(4, person.getDateNaissance());
			preparedStatement.setString(5, person.getEmail());
			preparedStatement.setString(6, person.getPassword());
			preparedStatement.setString(7, person.getTelephone());
			preparedStatement.setString(8, person.getNumeroEtRue());
			preparedStatement.setString(9, person.getVille());
			preparedStatement.setString(10, person.getDepartement());
			preparedStatement.setString(11, person.getPays());
			preparedStatement.setInt(12, person.getId());
	        preparedStatement.executeUpdate();  
	    } catch (SQLException e) {
	        e.printStackTrace();
	        LOGGER.info("Exception : ",e);
	    }		
	}

	@Override
	public boolean isValideConnection(String email, String password) {
		Person person = findByEmail(email);
		if(person != null) {
			if(password.equals(person.getPassword())) {
				LOGGER.info("connexion réussie");
				return true;
			} else {
				LOGGER.info("connexion échouée, bon login mais mauvais mot de passe");
				return false;
			}
		} 
		LOGGER.info("connexion échouée, login inconnu");
		return false;
	}

	@Override
	public boolean exists(String email) {
		Person person = findByEmail(email);
		return (person != null);
	}

}
