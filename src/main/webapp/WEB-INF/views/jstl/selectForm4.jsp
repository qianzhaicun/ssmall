<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>form:select标签form:options的属性绑定</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="selectForm2">
<table>


<tr>
<td>学历:</td>
<td><form:select path="deptid" >
<form:options items="${deptList}" itemLabel="name" itemValue="id" />
</form:select>
</td>
</tr>
</table>

</form:form>
</body>
</html>