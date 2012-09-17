package com.fm.multisource.dao.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class HibernateTest {
	
	@Autowired protected SessionFactory sessionFactory;
	
	@Before
	public void bindSession(){
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		session.setFlushMode(FlushMode.AUTO);
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
	}
	
	@After
	public void unBindSession(){
		try{
			Session session = SessionFactoryUtils.getSession(sessionFactory, false);
			if(session != null && session.isOpen() && session.isConnected()){
			SessionHolder sessionHolder = (SessionHolder)TransactionSynchronizationManager.unbindResource(sessionFactory);
			sessionHolder.getSession().flush();		
			SessionFactoryUtils.closeSession(sessionHolder.getSession());
			}
		}
		catch(IllegalStateException ex){
			
		}
	}

}
