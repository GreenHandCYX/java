<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addShopping.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
			function reWrite(){
		$("input[type='text']").val("");
		
		}
	</script>
	
  </head>
  
  <body>
    <div class="container">
    	<div class="panel panel-success">
    		<div class="panel-heading">
    			addKind
    		</div>
    		<div class="panel-body">
    			<form action="KindServlet?action=addShoppingKind" method="post" ">
    				<div class="input-group">
    					<span class="input-group-addon">请输入类别名</span>
    					<input type="text" name="kname" class="form-control" id="kname" />
    				</div>

    				<div class="panel-footer">
	
						<input type="submit" value="提交" class="btn btn-success btn-block">
						<button  class="btn btn-success btn-block" type="reset" onclick="reWrite()">重置</button>
				
					</div>
    			</form>
    		</div>    		
    	</div>
    </div>
  </body>
</html>
