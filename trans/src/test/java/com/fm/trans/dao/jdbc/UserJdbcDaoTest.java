package com.fm.trans.dao.jdbc;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserJdbcDaoTest extends AbstractJdbcDaoTest{
	
	@Autowired private UserJdbcDao userJdbcDao;
	
	@Test
	public void testGetAllUsernames(){
		Assert.assertEquals(3, userJdbcDao.getAllUsernames().size());
	}
	
	@Test
	public void testCreateUser(){
		int firstCount = userJdbcDao.getAllUsernames().size();
		userJdbcDao.createUser("naran");
		int secondCount = userJdbcDao.getAllUsernames().size();
		Assert.assertEquals(firstCount + 1, secondCount);
	}
	
	
	@Test
	public void testDelete(){
		int firstCount = userJdbcDao.getAllUsernames().size();
		userJdbcDao.delete("koala");
		int secondCount = userJdbcDao.getAllUsernames().size();
		Assert.assertEquals(firstCount - 1, secondCount);
	}

}
