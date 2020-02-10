package com.zhangguo.ssmall.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloController {
		
	private static final Log logger = LogFactory.getLog(HelloController.class);
	
    @RequestMapping
    public String list(Model model){
    	model.addAttribute("message","Hello world!");
    	 //创建Map对象
        Map<String, String> map = new HashMap<String,String>();       //数据采用的哈希表结构
        //给map中添加元素
        map.put("星期一", "Monday");
        map.put("星期日", "Sunday");
        model.addAttribute("amap",map);
        logger.info("Hello 方法被调用");
        return "goods/welcome";
    }
    
}
