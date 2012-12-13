package com.fm.trans.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.dao.CleanupFailureDataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

public class HibernateFilter extends OpenSessionInViewFilter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		//set the FlushMode to auto in order to save objects.
		session.setFlushMode(FlushMode.AUTO);
		logger.debug("getting session {}", session.hashCode());
		return session;
	}

	@Override
	protected void closeSession(Session session, SessionFactory sessionFactory) {
		logger.debug("closing session {}", session.hashCode());
	try{
		if (session != null && session.isOpen() && session.isConnected()) {
			try {
				session.flush();
			}
			catch (HibernateException e) {
				throw new CleanupFailureDataAccessException("Failed to flush session before close: " + e.getMessage(), e);
			}
			catch(Exception e){
			}
		}
	}
	finally{
		super.closeSession(session, sessionFactory);
	}
	}
	}