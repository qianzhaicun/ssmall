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
<form:form modelAttribute="employee" method="post" action="checkboxesForm2">
<table>
<tr>
<td>选择课程:</td>
<td><form:checkboxes path="depts" items="${deptList}" itemLabel ="name" itemValue = "id" />&nbsp;


</td>
</tr>


</table>

</form:form>
</body>
</html>