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
		$("textarea").val("");
		
		}
	</script>
	<script charset="utf-8" src="kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id',{  
                uploadJson : 'kindeditor/jsp/upload_json.jsp',  
                fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',  
                allowFileManager : true  
              });
        });
     $(function(){
	
	alert("请先上传图片");
		window.location.href="ShoppingMainIndex.jsp";});

</script>
  </head>
  
  <body>
    <div class="container">
    	<div class="panel panel-success">
    		<div class="panel-heading">
    			add
    		</div>
    		<div class="panel-body">
    			<form action="ShoppingServlet?action=addShopping" method="post" id="form">
    				<div class="input-group">
    					<span class="input-group-addon">商品名</span>
    					<input type="text" name="pname" class="form-control" id="pname" onblur=""/>
    				</div>
    				
    				<br/>
    				<div class="input-group">
    					<span class="input-group-addon">商品价格</span>
    					<input type="text" name="price" class="form-control" id="price"/>
    				</div>
    				<br/>
    				
    				<div class="input-group">
    					<span class="input-group-addon">商品信息</span>
    					 <textarea  class="" name="pinfo" id="pinfo"> </textarea>
    				</div>
    				<br/>
    				<div class="form-group">
  		<span class="input-group-addon">商品图</span>

  		</div>
    				<hr/>
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
