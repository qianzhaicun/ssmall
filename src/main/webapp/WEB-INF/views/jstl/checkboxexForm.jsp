<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>test form</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="checkboxForm">
<table>
<tr>
<td>选择课程:</td>
<td><form:checkboxex path="courses" items="${courseList}" />&nbsp;


</td>
</tr>


</table>
<form:checkbox path="reader" value="true" />已经阅读相关协议
</form:form>
</body>
</html>