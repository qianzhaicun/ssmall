package com.zhangguo.ssmall.controllers;

import java.sql.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangguo.ssmall.converter.DateEditor;
import com.zhangguo.ssmall.entities.User2;

@Controller
public class User2Controller {
	private static final Log logger = LogFactory.getLog(User2Controller.class);
	
	@RequestMapping(value="/user2/{formName}")
	public String loginForm(@PathVariable String formName)
	{
		return formName;
	}
	
	@RequestMapping(value="/register2",method=RequestMethod.POST)
	public String register(@ModelAttribute User2 user,Model model)
	{
		logger.info(user);
		model.addAttribute("user",user);
		return "success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
}
