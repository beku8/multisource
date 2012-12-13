package com.fm.trans.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T extends Serializable> {
	
	@Autowired private SessionFactory sessionFactory;
	private Class< T > clazz;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public T find(Long id){
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public T find(String id){
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
	}
	
	public void delete(T entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public void save(T entity){
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	

}
