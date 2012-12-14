package com.fm.trans.repository.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fm.trans.dao.hibernate.ItemsDao;
import com.fm.trans.domain.Items;

public class ItemsDaoTest extends AbstractHibernateDaoTest{
	
	@Autowired private ItemsDao itemsDao;
	
	@Test
	public void testFindAll(){
		List<Items> items = itemsDao.findAll();
		Assert.assertNotNull(items);
	}
	
	@Test
	public void testGetByUsername(){
		List<Items> items1 = itemsDao.getByUsername("admin");
		Assert.assertEquals(items1.size(), 1);
		
		List<Items> items2 = itemsDao.getByUsername("beku");
		Assert.assertEquals(items2.size(), 2);
		
		List<Items> items3 = itemsDao.getByUsername("koala");
		Assert.assertEquals(items3.size(), 0);
		
	}
	
	@Test
	public void testSaveOrUpdate(){
	}

}
