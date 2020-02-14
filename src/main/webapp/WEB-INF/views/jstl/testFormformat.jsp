<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试表单数据格式化</title>
</head>
<body>

<form action="testFormat" method="post">
<table>
<tr>
<td>日期类型:</td>
<td><input type="text" id="birthday" name="birthday"></td>
</tr>
<tr>
<td>整数类型:</td>
<td><input type="text" id="total" name="total"></td>
</tr>
<tr>
<td>百分数类型:</td>
<td><input type="text" id="discount" name="discount"></td>
</tr>
<tr>
<td>货币类型:</td>
<td><input type="text" id="money" name="money"></td>
</tr>
<tr><td><input id="submit" type="submit" value="提交"></td></tr>
</table>
</form>

</body>
</html>