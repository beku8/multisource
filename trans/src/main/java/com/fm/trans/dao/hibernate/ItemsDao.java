package com.fm.trans.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fm.trans.domain.Items;

@Repository
public class ItemsDao extends AbstractDao<Items> {
	
	public ItemsDao(){
		super.setClazz(Items.class);
	}
	
	public List<Items> getByUsername(String username){
		Query query = getSessionFactory().getCurrentSession().createQuery("from Items i where i.user.username = :username");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Items> items = query.list();
		return items;
	}

}
