package com.zhangguo.ssmall.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangguo.ssmall.entities.Usertestconvert;;

@Controller
public class UsertestconvertController {
	private static final Log logger = LogFactory.getLog(UsertestconvertController.class);
	
	@RequestMapping(value="/registerconvert",method=RequestMethod.POST)
	public String register(@ModelAttribute Usertestconvert user,Model model)
	{
		logger.info(user);
		model.addAttribute("user",user);
		return "successconvert";
	}
	
	
}
