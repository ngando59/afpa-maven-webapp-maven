package fr.ngando.person.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.person.business.IPersonBusiness;
import fr.ngando.person.dao.IPersonDao;
import fr.ngando.person.dao.impl.PersonneDaoImpl;
import fr.ngando.person.domain.Person;

public class PersonBusinessImpl implements IPersonBusiness {
	private static final IPersonDao iPersonDao = new PersonneDaoImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(PersonBusinessImpl.class);
	
	@Override
	public List<Person> findAll() {
		List<Person> persons = iPersonDao.findAll();
		return persons;
	}

	@Override
	public Person findOneById(Integer id) {
		Person person = iPersonDao.findOneById(id);
		return person;
	}

	@Override
	public Person findByEmail(String email) {
		Person person = iPersonDao.findByEmail(email);
		return person;
	}

	@Override
	public void add(Person person) {
		iPersonDao.add(person);
	}

	@Override
	public void remove(Person person) {
		iPersonDao.remove(person);
	}

	@Override
	public void update(Person person) {
		iPersonDao.update(person);
	}

	@Override
	public boolean isValideConnection(String email, String password) {
		boolean isValid = iPersonDao.isValideConnection(email, password);
		return isValid;
	}

	@Override
	public boolean exists(String email) {
		boolean isValid = iPersonDao.exists(email);
		return isValid;
	}

}
