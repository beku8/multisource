package com.fm.trans.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.trans.dao.hibernate.UserDao;
import com.fm.trans.domain.User;

@Service
@Transactional("txMgr")
public class SomeUserService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private UserDao userDao;
	
	
	//doorhi mur kod ni ConstraintViolationException shideh uchir RuntimeException zaaval shalgah shaardlagagui.
//	@Transactional(value="txMgr",rollbackFor={BatchUpdateException.class, ConstraintViolationException.class})
	@Transactional("txMgr")
	public void deleteByUsername(String username){
		User user = userDao.find(username);
		logger.debug("user has been found {}", user);
		userDao.delete(user);
	}
	

}
