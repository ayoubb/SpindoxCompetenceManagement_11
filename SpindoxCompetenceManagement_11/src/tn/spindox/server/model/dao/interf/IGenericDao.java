package tn.spindox.server.model.dao.interf;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao {

	public void create(Object entity); 
	public void update(Object entity);
	public void delete(Object entity); 
	public List<Object> findAll(Class targetClass); 
	public Object findById(Serializable id, Class targetClass);
	public List<Object> findByCriterias(String sqlWhereRequest, Class targetClass);
}
