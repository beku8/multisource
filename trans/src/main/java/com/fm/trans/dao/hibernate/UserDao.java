package com.fm.trans.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.fm.trans.domain.User;

@Repository
public class UserDao extends AbstractDao<User> {
	
	public UserDao(){
		super.setClazz(User.class);
	}


}
