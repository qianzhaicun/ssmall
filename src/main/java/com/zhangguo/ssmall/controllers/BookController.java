package com.zhangguo.ssmall.controllers;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangguo.ssmall.entities.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
@Controller
@RequestMapping("/json")
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	//接收json
	@RequestMapping(value="/test/testRequestBody")
	public void setJson(@RequestBody Book book,HttpServletResponse response) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		logger.info(mapper.writeValueAsString(book));
		book.setAuthor("肖文姬");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(mapper.writeValueAsString(book));
	}
	
    @RequestMapping
    public String list(Model model){
        return "json2test";
    }
    @RequestMapping(value="/getjson2")
    public String list2(Model model){
        return "getjson";
    }    
    //返回json
    @RequestMapping(value="/getjson")
    @ResponseBody
    public Object getJson()
    {
    	List<Book> list = new ArrayList<Book>();
    	list.add(new Book(1,"Spring mvc 实战","肖文姬"));
    	list.add(new Book(2,"轻量级JaveEE 企业开发实战","李刚"));
    	return list;
    }
    
	
}
