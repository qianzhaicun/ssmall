package com.zhangguo.ssmall.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangguo.ssmall.entities.UserFormat;

@Controller
public class FormatterController {
	private static final Log logger = LogFactory.getLog(FormatterController.class);
	
	@RequestMapping(value="/testFormat",method=RequestMethod.POST)
	public String test(@ModelAttribute UserFormat user, Model model)
	{
		logger.info(user);
		model.addAttribute("user",user);
		return "successFormat";
	}
	
}
