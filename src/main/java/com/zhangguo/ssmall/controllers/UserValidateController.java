package com.zhangguo.ssmall.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zhangguo.ssmall.entities.UserValidate;


/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */


@Controller
public class UserValidateController{
	
	@GetMapping(value="/registerFormValidate")
	 public String registerForm(Model model){
		UserValidate userValidate = new UserValidate();
		userValidate.setAge(99);
		model.addAttribute("userValidate",userValidate);
		// 跳转到注册页面
		return "registerValidate";
	}
	 
	// 数据校验使用@Valid，后面跟着Errors对象保存校验信息
	 @PostMapping(value="/login")
	 public String login(
			 @Valid @ModelAttribute  UserValidate user,
			 Errors  errors,
			 Model model) {
		 System.out.println(user);
		 if(errors.hasErrors()){
			 return "registerValidate";
		 }
		 model.addAttribute("user", user);
	     return "successValidate";
	 }

}

