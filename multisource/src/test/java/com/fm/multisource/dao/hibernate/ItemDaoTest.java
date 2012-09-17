package com.fm.multisource.dao.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fm.multisource.datasource.CustomerContextHolder;
import com.fm.multisource.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test-context.xml" })
public class ItemDaoTest extends HibernateTest{
	
	@Autowired private ItemDao itemDao;
	
	@Test
	public void testSource1(){
		CustomerContextHolder.setCustomerType(1);
		List<Item> osItems = itemDao.findAll();
		Assert.assertEquals(3, osItems.size());
		System.out.println("os items: " + osItems);
	}
	
	@Test
	public void testSource2(){
		CustomerContextHolder.setCustomerType(2);
		List<Item> avItems = itemDao.findAll();
		Assert.assertEquals(2, avItems.size());
		System.out.println("av items: " + avItems);
	}
	
	@Test
	public void testSource3(){
		CustomerContextHolder.setCustomerType(3);
		List<Item> ideItems = itemDao.findAll();
		Assert.assertEquals(4, ideItems.size());
		System.out.println("ide items: " + ideItems);
	}
	
	@Test
	public void testSource1Again(){
		CustomerContextHolder.setCustomerType(1);
		List<Item> osItems = itemDao.findAll();
		Assert.assertEquals(3, osItems.size());
		System.out.println("os items: " + osItems);
	}

}
