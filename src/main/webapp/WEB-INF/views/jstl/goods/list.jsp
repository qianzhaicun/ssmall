<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />

<title>商品管理</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>商品管理</span></h2>
        <a type="button" class="abtn"  onclick="showpdf(this);">预览</a>
        <form action="deletes" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>编号</th>
                <th>产品名</th>
                <th>价格</th>
                <th>类型</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entity" items="${goods}">
                <tr>
                    <th><input type="checkbox" name="id" value="${entity.id}"></th>
                    <td>${entity.id}</td>
                    <td>${entity.name}</td>
                    <td><img src="<c:url value="/images/${entity.picture}"/>" height="40"/></td>
                    <td>${entity.price}</td>
                    <td>
                    <a href="delete/${entity.id}" class="abtn">删除</a>
                    <a href="edit/${entity.id}" class="abtn">编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div id="pager"></div>
        <p>
            <a href="goods/add" class="abtn out">添加</a>
            <input type="submit"  value="批量删除" class="btn out"/>
        </p>
        <p style="color: red">${message}</p>
        
        
        
        <!-- 模态框（Modal） -->

	   <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel">
	    <div class="modal-dialog" role="document"  style="width: 1024px;height:100%;">
		<div class="modal-content"  >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					pdf
				</h4>
			</div>
			<div class="modal-body">
				
				<embed  id="pdfid" src="" width="100%" height="100%">
				
				</embed>
	

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
        
        

    </form>
    </div>
    
         <!--分页 -->
<%--         <script type="text/javascript" src="<c:url value="/scripts/jQuery1.11.3/jquery-1.11.3.min.js"/>" ></script> --%>
        
        
        <script src="https://code.jquery.com/jquery-3.4.1.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        

        <link href="<c:url value="/scripts/pagination22/pagination.css"/>"  type="text/css" rel="stylesheet" />
        
        
                
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
        
        
        
        <script type="text/javascript" src="<c:url value="/scripts/pagination22/jquery.pagination2.2.js"/>" ></script>
        <script type="text/javascript">
           //初始化分页组件
           var count=${count};
           var size=${size};
           var pageNO=${pageNO};
           $("#pager").pagination(count, {
              items_per_page:size,
               current_page:pageNO-1,
               next_text:"下一页",
               prev_text:"上一页",
               num_edge_entries:2,
               load_first_page:false,
              callback:handlePaginationClick
            });
           
           //回调方法
           function handlePaginationClick(new_page_index, pagination_container){
               location.href="list?pageNO="+(new_page_index+1);
           }
           
           var defaultSrc="<c:url value="/images/default.jpg"/>";
           
/*            $(".tab img").bind("error",function(){
               $(this).prop("src",defaultSrc);
           }); */

           function showpdf(obj)
           {

           	var input_dict = {};

           	 $.ajax({
           			 url: '/SSMall/goods/showpdf/',
           					 type: 'POST',
           					 data: input_dict,
           					 dataType: 'JSON',
           					 success: function (args) {
           							 if(args.status == 'success'){
           							 	 $("#pdfid").attr("src",args.pdffile);	
           								 $('#myModal').modal("show");
           							 }else{
           								 alert('fail');
           							}
           					 }
           				})



           }

           
        </script>   
    
</body>
</html>