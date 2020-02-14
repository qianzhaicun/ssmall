package com.zhangguo.ssmall.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 动态页面跳转控制器
 * */
@Controller
public class FormController{

	@GetMapping(value="/loginFormBook")
	 public String loginForm(){
		// 跳转到登录页面
		return "loginFormBook";
	}

}

