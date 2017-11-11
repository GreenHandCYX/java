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
	
	</script>
  </head>
  
  <body>
    	<div class="container">
			<div class="panel panel-success">
				<div class="panel-heading">
					主页
				</div>
				<h1 class="btn btn-success btn-lg btn-block">选择类别</h1>
				<div class="panel-body">
					<form action="KindServlet?action=listKindShopping" method="post">
						     <c:forEach items="${kindlist }"  var="listkind" >
						     <tr>
						     <td><input type="submit" value="${listkind.kname }" name="kname" class="btn btn-success btn-block"></td>
						  	</tr>
						  	</c:forEach>
					</form>	  
					
				</div>
			</div>
		</div>
    
  </body>
</html>
