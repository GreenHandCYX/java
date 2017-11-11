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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<script type="text/javascript">
			function addKind(){
				window.location.href="addKind.jsp";
			}
		function shoppingMessage(){
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
				<h1 class="btn btn-success btn-lg btn-block">类别</h1>
				<div class="panel-body">
					
						     <c:forEach items="${kindlistM }"  var="listkind" >
						     <tr>
						     <td><input type="submit" value="${listkind.kname }" name="kname"></td>
						      <td>
						     <form action="KindServlet?action=deleteKind" method="post">						    
						      	<input type="hidden" value="${listkind.kid }" name="kid">
						     	<input type="submit" value="删除" class="btn btn-success" >						    
						     </form>
						      </td>
						  	</tr>
						  	</c:forEach>
					
					
				</div>
				 <button class="btn btn-success btn-lg" id="restore" onclick="addKind()">添加类别</button>
				  <button class="btn btn-success btn-lg" id="restore" onclick="shoppingMessage()">返回上一层</button>
			</div>
		</div>
    
  </body>
</html>
