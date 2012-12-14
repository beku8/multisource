package com.fm.trans.repository.hibernate;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fm.trans.dao.hibernate.UserDao;
import com.fm.trans.domain.User;

public class UserDaoTest extends AbstractHibernateDaoTest {
	
	@Autowired private UserDao userDao;
	
	@Test
	public void testSaveOrUpdate(){
		int firstCount = userDao.findAll().size();
		
		User user = new User("naran");
		userDao.save(user);
		
		int secondCount = userDao.findAll().size();
		Assert.assertEquals(firstCount + 1, secondCount);
	}
}
