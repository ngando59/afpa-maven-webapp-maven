package fr.ngando.product.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.product.business.IProductBusiness;
import fr.ngando.product.dao.IProductDao;
import fr.ngando.product.dao.impl.ProductDaoImpl;
import fr.ngando.product.domain.Product;

public class ProductBusinessImpl implements IProductBusiness {

	private static final IProductDao iProductDao = new ProductDaoImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(ProductBusinessImpl.class);
	
	@Override
	public List<Product> findAll() {
		List<Product> products = iProductDao.findAll();
		return products;
	}

	@Override
	public Product findOneById(Integer id) {
		Product product = iProductDao.findOneById(id);
		return product;
	}

	@Override
	public void add(Product product) {
		iProductDao.add(product);
	}

	@Override
	public void remove(Product product) {
		iProductDao.remove(product);
	}

	@Override
	public void update(Product product) {
		iProductDao.update(product);
	}

	@Override
	public List<Product> findAllByTag(String tag) {
		List<Product> products = iProductDao.findAllByTag(tag);
		return products;
	}

}
