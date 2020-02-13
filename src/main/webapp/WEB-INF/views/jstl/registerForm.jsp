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
<form:form modelAttribute="user" method="post" action="register">
<table>
<tr>
<td>姓名:</td>
<td><form:input path="username" /></td>
<td><font color="red"><form:errors path="username"></form:errors></font></td>
</tr>
<tr>
<td>性别:</td>
<td><form:input path="sex" /></td>
<td><font color="red"><form:errors path="sex"></form:errors></font></td>
</tr>
<tr>
<td>年龄:</td>
<td><form:input path="age" /></td>
<td><font color="red"><form:errors path="age"></form:errors></font></td>
</tr>
<tr>
<td>密码:</td>
<td><form:hidden path="password" /></td>
</tr>
<tr>
<td>textarea:</td>
<td><form:textarea path="password" rows="5" cols="20" /></td>
</tr>
<tr><td><input type="submit" value="提交"></td></tr>

</table>
</form:form>
</body>
</html>