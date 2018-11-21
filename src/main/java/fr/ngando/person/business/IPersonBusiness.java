package fr.ngando.person.business;

import java.util.List;

import fr.ngando.person.domain.Person;

public interface IPersonBusiness {
	/*@return all person */
	public List<Person> findAll();
	
	/*@return the person found with the id id*/
	public Person findOneById(Integer id);
	
	/*@return the person with the email : email */
	public Person findByEmail(String email);
	
	/* @param person : person to add
	 * */
	public void add(Person person);
	
	/* @param person : person to remove
	 * */
	public void remove(Person person);
	
	/* @param person : person to update 
	 * */
	public void update(Person person);
	
	/* @return true if couple (email, password) is correct  */
	public boolean isValideConnection(String email, String password);
	
	/* @return true if the email is already exists */
	public boolean exists(String email);
}
