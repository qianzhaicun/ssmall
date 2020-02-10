package com.zhangguo.ssmall.controllers;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangguo.ssmall.entities.Book;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
@Controller
@RequestMapping("/json")
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	
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
	
}
