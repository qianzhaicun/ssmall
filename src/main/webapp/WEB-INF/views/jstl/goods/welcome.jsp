<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<p>${message}</p>
	<c:forEach var="map" items="${amap}" varStatus="status">
<p><c:out value="${status.current.key}"/>=<c:out value="${status.current.value}"/> </p>

</c:forEach>

</body>
</html>