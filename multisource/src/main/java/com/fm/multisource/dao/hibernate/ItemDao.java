package com.fm.multisource.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.fm.multisource.domain.Item;

@Repository
public class ItemDao extends AbstractDao<Item> {
	
	public ItemDao(){
		super.setClazz(Item.class);
	}

}
