package com.zhangguo.ssmall.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class DateEditor extends PropertyEditorSupport {
	
	//将传入的字符串转换成日期
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(text);
			setValue(date);
		}
		catch(ParseException  e){
			e.printStackTrace();
		}
	}

}
