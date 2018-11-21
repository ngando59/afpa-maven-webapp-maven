package fr.ngando.type.business;

import java.util.List;

import fr.ngando.type.domain.Type;

public interface ITypeBusiness {
	/*@return all category */
	public List<Type> findAll();
	
	/*@return the type found with the id id*/
	public Type findOneById(Integer id);
	
	/*@return the type with by the name : name */
	public Type findOneByName(String name);
}
