package fr.ngando.product.dao;

import java.util.List;

import fr.ngando.product.domain.Product;

public interface IProductDao {
	/*@return all product */
	public List<Product> findAll();
	
	/*@return the product found with the id id*/
	public Product findOneById(Integer id);
	
	/*@return the list of products with the tag : tag */
	public List<Product> findAllByTag(String tag);
	
	/* 
	 * @param product : product to add
	 * */
	public void add(Product product);
	
	/* @param product : product to remove
	 * */
	public void remove(Product product);
	
	/* @param product : product to update 
	 * */
	public void update(Product product);
	
}
