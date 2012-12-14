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

}
