package com.zhangguo.ssmall.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangguo.ssmall.entities.Dept;
import com.zhangguo.ssmall.entities.Employee;
import com.zhangguo.ssmall.entities.User;
import com.zhangguo.ssmall.validator.UserValidator;

@Controller
public class UserController {
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String RegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "registerForm";
	}
	@InitBinder
	public void initBinder(DataBinder binder)
	{
		binder.setValidator(new UserValidator());
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Validated User user,Errors errors) {
		if (errors.hasFieldErrors())
			return "registerForm";
		return "registerForm";
	}
	
	
	@RequestMapping(value="checkboxForm",method=RequestMethod.GET)
	public String registerFormcheck(Model model)
	{
		User user = new User();
		user.setAge(22);
		user.setPassword("123456");
		user.setSex("男");
		user.setUsername("孙悟空");
		
		user.setReader(true);
		List<String> list = new ArrayList<String>();
		list.add("JAVAEE");
		list.add("Spring");
		user.setCourses(list);
		
		model.addAttribute("user",user);
		return "checkboxForm";
	}
	
	@RequestMapping(value="checkboxesForm",method=RequestMethod.GET)
	public String registerFormCheckboxes(Model model)
	{
		User user = new User();
		List<String> list = new ArrayList<String>();
		list.add("JAVAEE");
		list.add("Spring");
		user.setCourses(list);
		
		List<String> courseList = new ArrayList<String>();
		courseList.add("JAVAEE");
		courseList.add("Spring");
		courseList.add("Mybatis");
		
		model.addAttribute("user",user);
		model.addAttribute("courseList",courseList);
		return "checkboxesForm";
		
	}
	
	@RequestMapping(value="check2boxesForm",method=RequestMethod.GET)
	public String registerFormCheckboxes2(Model model)
	{
		User user = new User();
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("3");
		user.setCourses(list);
		
		Map<String,String> courseMap = new HashMap<String,String>();
		courseMap.put("1","JAVAEE");
		courseMap.put("2","Spring");
		courseMap.put("3","Mybatis");
		
		model.addAttribute("user",user);
		model.addAttribute("courseMap",courseMap);
		return "checkboxesForm2";
		
	}	
	
	@RequestMapping(value="check3boxesForm",method=RequestMethod.GET)
	public String registerFormCheckboxes3(Model model)
	{
		Employee employee = new Employee();
		Dept dept = new Dept(1,"开发部");
		
		List<Dept> list = new ArrayList<Dept>();
		list.add(dept);
		
		employee.setDepts(list);
		
		List<Dept> depts = new ArrayList<Dept>();
		depts.add(dept);
		depts.add(new Dept(2,"销售部"));
		depts.add(new Dept(3,"财务部"));
		
		model.addAttribute("employee",employee);
		model.addAttribute("deptList",depts);
		
		return "checkboxesForm3";
		
	}		
	
	@RequestMapping(value="radiobuttonForm",method=RequestMethod.GET)
	public String registerFormCheckboxes4(Model model)
	{
		User user = new User();
		user.setSex("男");
		model.addAttribute("user",user);
		
		
		return "radiobuttonForm";
		
	}
	
	
	@RequestMapping(value="radio2buttonForm",method=RequestMethod.GET)
	public String registerFormCheckboxes5(Model model)
	{
		User user = new User();
		user.setSex("男");
		
		List<String> sexlist = new ArrayList<String>();
		sexlist.add("男");
		sexlist.add("女");
		
		
		model.addAttribute("user",user);
		model.addAttribute("sexlist",sexlist);
		
		return "radiobuttonForm2";
		
	}	
	
	@RequestMapping(value="/selectForm",method=RequestMethod.GET)
	public String selectForm(Model model)
	{
		User user = new User();
		user.setDeptid(2);
		
		model.addAttribute("user",user);
		return "selectForm";
	}
	
	@RequestMapping(value="/selectForm2",method=RequestMethod.GET)
	public String selectForm2(Model model)
	{
		User user = new User();
		user.setDeptid(2);
		
		//页面展现的下拉内容
		Map<Integer,String> deptMap = new HashMap<Integer,String>();
		deptMap.put(1, "财务部");
		deptMap.put(2, "开发部");
		deptMap.put(3, "销售部");
		model.addAttribute("user",user);
		model.addAttribute("deptMap",deptMap);
		
		return "selectForm2";
	}	
	
	@RequestMapping(value="/selectForm4",method=RequestMethod.GET)
	public String selectForm4(Model model)
	{
		User user = new User();
		user.setDeptid(2);
		
		//页面展现的下拉内容
		List<Dept> list = new ArrayList<Dept>();
		list.add(new Dept(1,"销售部"));
		list.add(new Dept(2,"开发部"));
		list.add(new Dept(3,"财务部"));
		
		model.addAttribute("user",user);
		model.addAttribute("deptList",list);
		
		return "selectForm4";
	}		
	
}
