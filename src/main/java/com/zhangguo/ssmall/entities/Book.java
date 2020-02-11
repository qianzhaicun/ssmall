package com.zhangguo.ssmall.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
//
@XmlRootElement
public class Book implements Serializable {
	
	public Book() {
		super();
	};
	
	public Book(Integer id,String name,String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	};
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	public Integer getId() {
		return id;
	}
	
	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	private Integer id;
	private String name;
	private String author;
	
}
