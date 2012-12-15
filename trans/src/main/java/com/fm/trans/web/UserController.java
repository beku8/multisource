package com.fm.trans.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fm.trans.dao.hibernate.UserDao;
import com.fm.trans.domain.User;
import com.fm.trans.service.SomeUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserDao userDao;
	@Autowired private SomeUserService someUserService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping
	public String get(Model model){
		model.addAttribute("users", userDao.findAll());
		return "users";
	}
	
	@RequestMapping(value="/delete/{name}")
	public String delete(Model model, @PathVariable("name") String username){
		try {
			someUserService.deleteByUsername(username);
		} 
		catch (DataIntegrityViolationException e) {
			logger.debug("DataIntegrityViolationException caught");
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value="/add/{name}")
	public String add(Model model, @PathVariable("name") String username){
		userDao.save(new User(username));
		return "redirect:/user";
	}
	

}
