<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
登录名:"${requestScope.user.username}"<br>
登录名:"${requestScope.user.birthday}"<br>
生日:<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日" /></br>
</body>
</html>