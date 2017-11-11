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
		function userLogin(){
		window.location.href="index.jsp";
		}
		function managerLogin(){
			window.location.href="ManagerIndex.jsp";
		}
	</script>
  </head>
  
  <body>
    	<div class="container">
			<div class="panel panel-success">
				<div class="panel-heading">
					主页
				</div>
				<h1 class="btn btn-success btn-lg btn-block">选择登录</h1>
				<div class="panel-body">
					
						  	<input type="button" value="用户" class="btn btn-success btn-block" id="user" onclick="userLogin() ">
						  	<input type="button" value="管理员" class="btn btn-success btn-block" id="manager" onclick="managerLogin()">
					
				</div>
			</div>
		</div>
    
  </body>
</html>
