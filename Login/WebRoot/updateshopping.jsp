<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>信息页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script> 
		<link rel="stylesheet" type="text/css"
			href="bootstrap/css/bootstrap.min.css">
		<script type="text/javascript">
			function forward(){
				window.location.href="shoppingMessage.jsp";
			}
		
			
		</script>
	</head>

	<body>
		<div class="container">
			<div class="panel panel-success">
				<div class="panel-heading">
					主页
				</div>
				<h1 class="btn btn-success btn-lg btn-block">修改商品信息</h1>
				<div class="panel-body">
				
					<table class="table">
						<thead>
							<tr>
							<th>商品编号</th>
								
								<th>商品价格</th>
								<th>商品信息</th>		
								
																
								<th>修改</th>
							</tr>
						</thead>
						<tbody>
							
							
						
							<c:forEach items="${sessionShopping}" var="shopping">
								<tr>
								<form action="ShoppingServlet?action=updateshopping" method="post">
								
								<td><input type="text" name="pname" value="${shopping.pname}" onfocus="if(value='${shopping.pid}'){value=''}"></td>
								<td><input type="text" name="price" value="${shopping.price}" onfocus="if(value='${shopping.price}'){value=''}"></td>
								<td><input type="text" name="pinfo" value="${shopping.pinfo}" onfocus="if(value='${shopping.pinfo}'){value=''}"></td>
								
	  							<td><input type="hidden" name="pid" value="${shopping.pid}" ><input type="submit"  value="修改"></td>
	  							</form>
	  							</tr>
	  							</c:forEach>
	  						
	  						
							
							
						</tbody>
					</table>
				
				
					
				</div>
			</div>
	
		
			 
			 <button class="btn btn-success btn-lg" id="restore" onclick="forward()">返回</button>
		</div>
 
	 
  
	</body>
</html>
