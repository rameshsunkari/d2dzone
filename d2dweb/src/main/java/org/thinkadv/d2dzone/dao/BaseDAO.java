package org.thinkadv.d2dzone.dao;

import java.util.List;



import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.thinkadv.d2dzone.common.HibernateUtil;

/**
 * The Class EmployeeDAO.
 *
 * @param <T> the generic type
 */
public class BaseDAO<T> {
	
	/** The entity class. */
	private Class<T> entityClass;
	
	/**
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * Sets the entity class.
	 *
	 * @param entityClass the new entity class
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Instantiates a new base dao.
	 * 
	 * @param entityClass the entity class
	 */
	public BaseDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Save or update.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean saveOrUpdate(T entity) throws Exception {

		Transaction tx = HibernateUtil.getTransaction();
		HibernateUtil.getSession().saveOrUpdate(entity);
		tx.commit();
		HibernateUtil.close();

		return true;
	}
	
	/**
	 * Save.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean save(T entity) throws Exception {

		Transaction tx = HibernateUtil.getTransaction();
		HibernateUtil.getSession().save(entity);
		tx.commit();
		HibernateUtil.close();

		return true;
	}
	
	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean update(T entity) throws Exception {

		Transaction tx = HibernateUtil.getTransaction();
		HibernateUtil.getSession().update(entity);
		tx.commit();
		HibernateUtil.close();

		return true;
	}
	
	/**
	 * Gets the entity list.
	 *
	 * @return the entity list
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> getEntityList() throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		List<T> list = HibernateUtil.getSession()
				.createCriteria(getEntityClass().getName()).list();
		tx.commit();
		HibernateUtil.close();
		return list;
	}

	/**
	 * Delete entity.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean deleteEntity(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		Object entity = HibernateUtil.getSession().load(getEntityClass().getName(), id);
		HibernateUtil.getSession().delete(entity);
		tx.commit();
		HibernateUtil.close();
		return false;
	}
	
	/**
	 * Gets the entity by id.
	 *
	 * @param id the id
	 * @return the entity by id
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public T getEntityById(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		T entity = (T) HibernateUtil.getSession().load(
				getEntityClass().getName(), new Integer(id));
		tx.commit();
		HibernateUtil.close();
		
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public T getEntityByColumn(String column) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		T entity = (T) HibernateUtil.getSession().load(
				getEntityClass().getName(), column);
		tx.commit();
		HibernateUtil.close();
		
		return entity;
	}
	
	public T getEntityByQuery(String queryString) throws Exception {
		
		Transaction tx = HibernateUtil.getTransaction();
		Query query =  HibernateUtil.getSession().createSQLQuery(queryString).addEntity(getEntityClass().getName());
		List<T> list = query.list();
		tx.commit();
		HibernateUtil.close();
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
		
	}
	
	/**
	 * Gets the JSON by id.
	 *
	 * @param id the id
	 * @return the JSON by id
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public String getJSONById(int id) throws Exception {
		Transaction tx = HibernateUtil.getTransaction();
		T entity = (T) HibernateUtil.getSession().load(
				getEntityClass().getName(), new Integer(id));
		ObjectMapper responseMapper = new ObjectMapper();
		String empString = responseMapper.writeValueAsString(entity);
		tx.commit();
		HibernateUtil.close();
		return empString;
	}



}
