package com.zhangguo.ssmall.controllers;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangguo.ssmall.entities.Book;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

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
    /////////////////////////////////////////xml test
    @RequestMapping(value="/xmltest")
    public String list3(Model model){
        return "sendxml";
    } 
    
    @RequestMapping(value="/xmltest2")
    public String list4(Model model){
        return "readxml";
    }     
    
    @RequestMapping(value="/sendxml",method=RequestMethod.POST)
    public void sendxml(@RequestBody Book book) {
    	logger.info(book);
    	logger.info("接收xml成功");
    }
	
    //ResponseBody会将book自动转成xml返回
    @RequestMapping(value="/readxml",method=RequestMethod.POST)
    public @ResponseBody Book readxml() throws Exception{
    	
    	//从xml创建类
    	//通过JAXBContent的newInstance方法，传递一个class就可以返回上下文
    	JAXBContext context = JAXBContext.newInstance(Book.class);
    	//创建一个unmarshall对象
    	Unmarshaller unmar = context.createUnmarshaller();
    	logger.info(222222);
    	InputStream is = this.getClass().getResourceAsStream("/book.xml");
    	logger.info(333333);
    	//Unmarshall 对象的unmarshall方法可以进行xml到java对象的转换
    	Book book2 = (Book) unmar.unmarshal(is);
    	logger.info(444444);
    	//手动创建类
    	Book book = new  Book(2,"轻量级JaveEE 企业开发实战","李刚");
    	logger.info(book);
    	
    	return book;
    }
    
}
