package fr.ngando.type.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ngando.type.business.ITypeBusiness;
import fr.ngando.type.dao.ITypeDao;
import fr.ngando.type.dao.impl.TypeDaoImpl;
import fr.ngando.type.domain.Type;

public class TypeBusinnesImpl implements ITypeBusiness {

	private static final ITypeDao typeDao = new TypeDaoImpl();
	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(TypeBusinnesImpl.class);
	
	@Override
	public List<Type> findAll() {
		List<Type> types = typeDao.findAll();
		return types;
	}

	@Override
	public Type findOneById(Integer id) {
		Type type = typeDao.findOneById(id);
		return type;
	}

	@Override
	public Type findOneByName(String name) {
		Type type = typeDao.findOneByName(name);
		return type;
	}

}
