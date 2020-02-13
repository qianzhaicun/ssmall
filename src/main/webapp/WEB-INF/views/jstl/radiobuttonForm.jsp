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
<form:form modelAttribute="user" method="post" action="radiobuttonForm">
<table>
<tr>
<td>性别:</td>
<td><form:radiobutton path="sex" value="男" />男&nbsp;
	<form:radiobutton path="sex" value="女" />女
</td>
</tr>


</table>

</form:form>
</body>
</html>