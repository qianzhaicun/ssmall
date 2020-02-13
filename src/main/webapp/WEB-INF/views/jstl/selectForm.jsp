<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>form:select标签添加form:option</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="selectForm">
<table>
<tr>
<td>部门:</td>
<td><form:select path="deptid">
<form:option value="1">财务部</form:option>
<form:option value="2">开发部</form:option>
<form:option value="3">销售部</form:option>

</form:select>
</td>
</tr>


</table>

</form:form>
</body>
</html>