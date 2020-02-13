<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>form:select标签items的属性绑定</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="selectForm2">
<table>
<tr>
<td>部门:</td>
<td><form:select path="deptid" items="${deptMap}">
</form:select>
</td>
</tr>

<tr>
<td>学历:</td>
<td><form:select path="deptid" >
<form:options items="${deptMap}" />
</form:select>
</td>
</tr>
</table>

</form:form>
</body>
</html>