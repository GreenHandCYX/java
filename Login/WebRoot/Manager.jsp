<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<script type="text/javascript">
		function choose(){
		window.location.href="MainLogin.jsp";
		}
		function shopping(){
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
				<h1 class="btn btn-success btn-lg btn-block">用户信息</h1>
				<div class="panel-body">
					 <form action="LoginServletSecond?action=list" method="post">
						  	<input type="submit" value="点击查看" class="btn btn-success btn-block">
					</form>
				</div>
				<h1 class="btn btn-success btn-lg btn-block">课程信息</h1>
				<div class="panel-body">
					 <form action="ShoppingServlet?action=listShopping" method="post">
						  	<input type="submit" value="点击查看" class="btn btn-success btn-block">
					</form>
						  	
					
				</div>
			</div>
			 <button class="btn btn-success btn-lg" id="rest" onclick="choose()">返回选择页</button>
		</div>
    	
  </body>
</html>
