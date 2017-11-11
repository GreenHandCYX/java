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
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
	<script>
	
		
		function check(){
				var userName = document.getElementById("userName").value;
				var passWord = document.getElementById("passWord").value;
				if(userName==""){
				
					alert("用户名不能为空！");
				
				}
				else if(passWord==""){
					alert("密码不能为空！");
				
				}
				
			}
			function check2(){
				
				var passWord = document.getElementById("passWord").value;
				if(passWord==""){
					alert("密码不能为空！");
				
				}
				
			}
	</script> 
  </head>
  
  <body>
     <div class="container">
    	<div class="panel panel-danger">
    		<div class="panel-heading">
    			管理员登录
    		</div>
    		<div class="panel-body">
    			<form action="ManagerServlet?action=ManagerLogin" method="post"">
    				<div class="input-group">
    					<span class="input-group-addon">User</span>
    					<input type="text" name="mname" id="mname" class="form-control" onblur="check()"/>
    				</div>
    				<br/>
    				<div class="input-group">
    					<span class="input-group-addon">Pass</span>
    					<input type="password" name="mpass" id="mpass" class="form-control" onblur="check2()"/>
    				</div>
    				<hr/>
    				<input type="hidden" name="uid" value="1">
    				<button type="submit" class="btn btn-danger btn-block" id="subBtn" >Login</button>
    				
    			</form>
    		</div>
    		
    </div>

  </body>
</html>
