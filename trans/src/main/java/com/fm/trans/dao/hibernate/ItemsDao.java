package com.fm.trans.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.fm.trans.domain.Items;

@Repository
public class ItemsDao extends AbstractDao<Items> {
	
	public ItemsDao(){
		super.setClazz(Items.class);
	}

}
