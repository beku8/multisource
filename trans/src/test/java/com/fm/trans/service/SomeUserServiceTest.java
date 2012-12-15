package com.fm.trans.service;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fm.trans.repository.hibernate.AbstractHibernateDaoTest;

public class SomeUserServiceTest extends AbstractHibernateDaoTest {
	
	@Autowired private SomeUserService userService;
	
	/**
	 * test expected ni enehuu exception uuseh ni zui yosnii asuudal gj helj bgaa yum.
	 * session.flush uildliig hiij baij transactional test ajilladag.
	 * 
	 */
	@Test(expected = HibernateException.class)
	public void deleteByUsername(){
		userService.deleteByUsername("beku");
		sessionFactory.getCurrentSession().flush();
	}

}
