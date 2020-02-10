<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>测试返回json格式的数据</title>
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
						 url:"${pageContext.request.contextPath}/json/getjson",
						type:"post",
						dataType:"json",
						contentType:"application/json",
						async:true,
						success:function(data)
						{
							$.each(data,
							function(){
								 var tr = "<tr align='center' />"; 
								 tr = tr + "<td>" + this.id + "</td>";
								 tr = tr + "<td>" + this.name + "</td>";
								 tr = tr + "<td>" + this.author + "</td>";
								 tr = tr + "</tr>";
								 $("#booktable").append(tr);
								}
							)
									
			
						},
						error:function(){
							alert("数据接收失败");
							}
					});
               };
        </script>
</head>
<body>
<table id="booktable" border="1" stype="border-collapse:collapse;">
	<tr align="center">
	<th>编号</th>
	<th>书名</th>
	<th>作者</th>
	
	
	</tr>
</table>

</body>
</html>