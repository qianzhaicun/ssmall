package com.zhangguo.ssmall.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0 
 * 
 */

public class UserValidate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message="登录名不能为空")
	private String loginname;
	
	@NotBlank(message="密码不能为空")
	@Length(min=6,max=8,message="密码长度在6到8之间")
	private String password;
	
	@NotBlank(message="用户名不能为空")
	private String username;
	
	@Range(min=15, max=60,message="年龄必须在15到60岁之间")
	private int age;
	
	@NotBlank(message="邮箱不能为空")
	@Email(message="必须是合法的邮箱地址")
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="生日必须是一个过去的日期")
	private Date birthday;
	
	@Pattern(regexp="[1][3,8][3,6,9][0-9]{8}",message="无效的电话号码")
	private String phone;


	public UserValidate() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "User [loginname=" + loginname + ", password=" + password
				+ ", email=" + email + ", username="
				+ username + ", birthDate=" + birthday + ", phone=" + phone
				+ "]";
	}

	
	
	
	
}
