 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<script type="text/javascript">
			function sforward(){
				window.location.href="MyHome.jsp";
			}
		
		</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#table1{width:20%;float:left;}
		#table2{width:80%;float:left;}
		#table1 td{font-size:20px;}
	</style>
  </head>
  
  <body>
  <div class="container">
  
			<div class="panel panel-warning">
				<div class="panel-heading">
					收藏夹
				</div>
				<h1 class="btn btn-warning btn-lg btn-block">收藏信息</h1>
				<div class="panel-body">
  				<table class="table" id="table1">
  				<thead>
							<tr>
								<th>收藏时间</th>
								
							</tr>
				</thead>
					<tbody>
							<c:forEach items="${listSC }" begin="1" var="listSC" step="2">
							<tr>
								<td>
									${listSC.fdate }
								</td>
							</tr>
							</c:forEach>
					</tbody>		
  				</table>
  				<table class="table" id="table2">
						<thead>
							<tr>
								
								<th>商品名</th>
								<th>商品价格</th>
								<th>商品图片</th>
								
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listSC }" var="listSC" step="2">
								<tr>
								<td>
									${listSC.pname }
								</td>
								<td>
									${listSC.price }
								</td>
								<td>
									<img src="onload/image/${listSC.purl}" width=50 height=50>
								</td>
								<form action="ShoppingCartServlet?action=deleteEachShoppingInCart" method="post">
								<td>
								<input type="hidden"   name="pid" value="${listSC.pid}"/>
								<input type="hidden"   name="uid1" value="${sessionuser}"/>
								<input type="submit"   value="删除 "/>
								</td>
								</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>  
					
					</div>
			</div>
				
			 <button class="btn btn-warning btn-lg" id="restore" onclick="sforward()">返回上一层</button>
			 <form action="ShoppingCartServlet?action=clearShoppingCart" method="post">
					<input type="hidden"   name="uid1" value="${sessionuser}"/>
					<input type="submit" class="btn btn-warning btn-lg" value="清空收藏夹"></button>
							
			</form>
		</div>

	</body>
</html>
