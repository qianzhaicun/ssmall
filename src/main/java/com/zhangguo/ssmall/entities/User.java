package com.zhangguo.ssmall.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(String username, String sex, Integer age,String password) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", sex=" + sex + ", age=" + age + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private String username;
	private String sex;
	private Integer age;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	public boolean isReader() {
		return reader;
	}
	public void setReader(boolean reader) {
		this.reader = reader;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	private boolean reader;
	private List<String> courses;
	
	private Integer deptid;
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	
}
