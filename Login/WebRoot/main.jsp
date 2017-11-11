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
				window.location.href="Manager.jsp";
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
				
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>USERNAME</th>
								<th>PASSWORD</th>
								<th>SEX</th>
								<th>email</th>
								<th>info</th>
							
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="user">
							<tr>
								<td>${user.uid }</td>
								<td>${user.userName }</td>
								<td>${user.passWord }</td>
								<td>${user.sex}</td>
								<td>${user.email }</td>
								<td>${user.info}</td>
								
								<form action="LoginServletSecond?action=delete" method="post">
								<input type="hidden" name="uid" value="${user.uid }"/>
	  							<td><input type="submit" value="delete"></td>
	  							</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
			 <button class="btn btn-success btn-lg" id="restore" onclick="forward()">返回上一层</button>
		</div>
 
	 
  
	</body>
</html>
