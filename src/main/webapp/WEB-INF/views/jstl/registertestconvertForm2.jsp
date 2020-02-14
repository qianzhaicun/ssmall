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
<form  method="post" action="registerconvert">
<table>
<tr>
<td>登录名:</td>
<td><input type="text" id="username" name="username"  ></td>
</tr>
<tr>
<td>生日:</td>
<td><input type="text" id="birthday" name="birthday"  ></td>
</tr>

<tr><td><input id="submit" type="submit" value="提交"></td></tr>

</table>
</form>
</body>
</html>