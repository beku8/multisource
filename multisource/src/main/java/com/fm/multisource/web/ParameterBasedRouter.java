package com.fm.multisource.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fm.multisource.dao.hibernate.ItemDao;
import com.fm.multisource.datasource.CustomerContextHolder;

@Controller
@RequestMapping("/param")
public class ParameterBasedRouter {
	
	@Autowired private ItemDao itemDao;
	@Autowired private UserDetailsService userDetailsService;
	
	
	private	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping
	public String get(@RequestParam(value="source", defaultValue="1") Integer source, Model model){
		CustomerContextHolder.setCustomerType(source);
		logger.debug("setting source to {}", source);
		model.addAttribute("items", itemDao.findAll());
		model.addAttribute("source", source);
		return "param";
	}
	
	@RequestMapping("/switch")
	public String get(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.debug("switching for user {}", username);
		
		UserDetails userDetails;
		
		if(username.equalsIgnoreCase("koala")){
			userDetails = userDetailsService.loadUserByUsername("admin");
		}
		else{
			userDetails = userDetailsService.loadUserByUsername("koala");
		}
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), 
									userDetails.getPassword(), userDetails.getAuthorities());
		logger.debug("re-authenticating...");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/user";
	}

}
