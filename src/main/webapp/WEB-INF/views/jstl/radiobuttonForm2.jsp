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
<form:form modelAttribute="user" method="post" action="radio2buttonForm">
<table>
<tr>
<td>性别:</td>
<td><form:radiobuttons path="sex" items="${sexlist}" />
</td>
</tr>


</table>

</form:form>
</body>
</html>