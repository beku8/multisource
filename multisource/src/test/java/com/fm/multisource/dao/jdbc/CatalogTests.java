package com.fm.multisource.dao.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fm.multisource.datasource.CustomerContextHolder;
import com.fm.multisource.domain.Item;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test-context.xml" })
public class CatalogTests {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private Catalog catalog;
	
	@Test
	public void testDataSourceRouting(){
		CustomerContextHolder.setCustomerType(1);
		List<Item> osItems = catalog.getItems();
		Assert.assertEquals(3, osItems.size());
		System.out.println("os items: " + osItems);
		
		
		CustomerContextHolder.setCustomerType(2);
		List<Item> avItems = catalog.getItems();
		Assert.assertEquals(2, avItems.size());
		System.out.println("av items: " + avItems);
		
		CustomerContextHolder.setCustomerType(3);
		List<Item> ideItems = catalog.getItems();
		Assert.assertEquals(4, ideItems.size());
		System.out.println("ide items: " + ideItems);
		
		logger.debug("items");
	}

}
