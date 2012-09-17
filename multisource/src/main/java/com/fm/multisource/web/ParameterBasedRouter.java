package com.fm.multisource.web;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping
	public String get(@RequestParam(value="source", defaultValue="1") Integer source, Model model){
		CustomerContextHolder.setCustomerType(source);
		model.addAttribute("items", itemDao.findAll());
		return "param";
	}

}
