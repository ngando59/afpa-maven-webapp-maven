package fr.ngando.category.business;

import java.util.List;

import fr.ngando.category.domain.Category;

public interface ICategoryBusiness {
	/*@return all category */
	public List<Category> findAll();
	
	/*@return the category found with the id id*/
	public Category findOneById(Integer id);
	
	/*@return the category with the tag : tag */
	public Category findOneByTag(String tag);
}
