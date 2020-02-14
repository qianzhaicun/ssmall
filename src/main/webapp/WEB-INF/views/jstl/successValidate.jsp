<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试JSR 303结果</title>
</head>
<body>
<h3>测试JSR 303结果</h3>
登录名：${requestScope.userValidate.loginname }<br>
密码：${requestScope.userValidate.password }<br>
用户名：${requestScope.userValidate.username }<br>
年龄：${requestScope.userValidate.age }<br>
邮箱：${requestScope.userValidate.email }<br>
生日：<fmt:formatDate value="${requestScope.userValidate.birthday}" 
	pattern="yyyy年MM月dd日"/><br>
电话：${requestScope.userValidate.phone }<br>
</body>
</html>