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
			function update(){
				window.location.href="updateshopping.jsp";
			}
			
		</script>
	</head>

	<body>
		<div class="container">
			<div class="panel panel-success">
				<div class="panel-heading">
					主页
				</div>
				<h1 class="btn btn-success btn-lg btn-block">课程信息</h1>
				<div class="panel-body">
				
					<table class="table">
						<thead>
							<tr>
								<th>课程编号</th>
								<th>课程名称</th>
								<th>课程价格</th>
								<th>课程信息</th>
								<th>更新时间</th>
								<th>课程图片</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionShopping}" var="shopping">
							<tr>
								<td>${shopping.pid }</td>
								<td>${shopping.pname }</td>
								<td>${shopping.price }</td>
								<td>${shopping.pinfo }</td>
								<td>${shopping.pTime }</td>
								<td><img src="onload/image/${shopping.purl}" width=50 height=50>${shopping.purl}</td>
								
							<form action="ShoppingServlet?action=deleteshopping" method="post">
								<input type="hidden" name="pid" value="${shopping.pid }"/>
	  							<td><input type="submit" value="删除"></td>
	  							</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
				</div>
			</div>
	
			 <a href="addShopping2.jsp" class="btn btn-success btn-lg" id="restore" >添加课程</a>

			 <button class="btn btn-success btn-lg" id="restore" onclick="update()">修改课程信息</button>
			 <form action="KindServlet?action=listAllKindManager" method="post">
			  <button type="submit"class="btn btn-success btn-lg">查看课程类别</button>
			  </form>
			  <button class="btn btn-success btn-lg" id="restore" onclick="forward()">返回上一层</button>
			 
		</div>
 
	 
  
	</body>
</html>
