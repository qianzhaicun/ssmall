<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>测试接收json格式的数据</title>
        <script type="text/javascript" src="<c:url value="/scripts/jQuery1.11.3/jquery-1.11.3.min.js"/>" ></script>
        <link href="<c:url value="/scripts/pagination22/pagination.css"/>"  type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="<c:url value="/scripts/json2/json2.js"/>" ></script>
        <script type="text/javascript">
  			$(document).ready(function()
  		  			{
  				testRequestBody();
		  			}
  					 
  		  		);
           function testRequestBody(){
			$.ajax(
					 {
						 url:"${pageContext.request.contextPath}/json/test/testRequestBody",
						 data:JSON.stringify({"id":1,"name":"Spring mvc 企业实战"}),
						type:"post",
						dataType:"json",
						contentType:"application/json",
						async:true,
						success:function(data)
						{
						 console.log(data);
						 $("#id").html(data.id);
						 $("#name").html(data.name);
						 $("#author").html(data.author);   
						},
						error:function(){
							alert("数据发送失败");
							}
					});
               };
        </script>
</head>
<body>
编号:<span id="id"></span></br>
书名:<span id="name"></span></br>
作者:<span id="author"></span>

</body>
</html>