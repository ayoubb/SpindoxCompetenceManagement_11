package tn.spindox.server.model.dao.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tn.spindox.server.model.dao.interf.IGenericDao;



public class GenericDaoImpl implements IGenericDao  {

	
	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@Override
	public void create(Object entity) {
	
		initConnection();
		entityManager.persist(entity);
		endConnection();
	}


	@Override
	public void update(Object entity) {
		
		initConnection();
		
		entityManager.merge(entity);
		endConnection();
	}

	@Override
	public void delete(Object entity) {

		initConnection();
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
		endConnection();
	}

	@Override
	public List<Object> findAll(Class targetClass) {

		initConnection();
		String request = "select obj from " + targetClass.getSimpleName() + " obj";
		List<Object> listResults; 
		listResults = executeRequest(request, targetClass);
		endConnection();
		return listResults;
		
	}


	@Override
	public Object findById(Serializable id, Class targetClass) {
		
		initConnection();
		Object object = entityManager.find(targetClass, id);
		endConnection();
		
		return object;
	}

	@Override
	public List<Object> findByCriterias(String sqlWhereRequest, Class targetClass) {
		
		initConnection();
		List<Object> listResult;
		String request = "select obj from " + targetClass.getSimpleName() + " obj " + sqlWhereRequest;
		listResult=executeRequest(request, targetClass);
		endConnection();
		
		return listResult;
	}

	private List <Object> executeRequest(String request, Class targetClass) {
        Query query = entityManager.createQuery(request);
        List<Object> results = (List<Object>) query.getResultList();
        if (results == null) {
            System.out.println("No result found for class " + targetClass.getSimpleName());
		} else {
            System.out.println("success for getting results from class " + targetClass.getSimpleName());
		}
        return results;
		
	}

	
	private void initConnection() 
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("mybase");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	private void endConnection() 
	{
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 entityManagerFactory.close();
	}
	
	

}


