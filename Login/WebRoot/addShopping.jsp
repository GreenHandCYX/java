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
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="bootstrap/css/default.css">
    <link href="bootstrap/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
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
    					<span class="input-group-addon">课程名</span>
    					<input type="text" name="pname" class="form-control" id="pname" onblur=""/>
    				</div>
    				
    				<br/>
    				<div class="input-group">
    					<span class="input-group-addon">课程价格</span>
    					<input type="text" name="price" class="form-control" id="price"/>
    				</div>
    				<br/>
    				
    				<div class="input-group">
    					<span class="input-group-addon">课程信息</span>
    					 <input type="text"  class="" name="pinfo" id="pinfo">
						          
						</div>	
    				<br/>
    				<div class="form-group">
  		<span class="input-group-addon">课程图</span>
		<input type="button" class="btn btn-danger btn-lg btn-block" value="已上传图片">
		<img src="onload/image/${picture }" width=50 height=50 align="middle">
		<input type="hidden"  name="purl"  value="${picture }">
  		</div>
    				<hr/>
    				<div class="panel-footer">
						<input type="submit" value="提交" class="btn btn-success btn-block">
						<button  class="btn btn-success btn-block" type="reset" onclick="reWrite()">重置</button>
				
					</div>
    			</form>
    		<form enctype="multipart/form-data">
                <div class="form-group">
                    <input id="file-5" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="#" data-preview-file-icon="">
                </div>
            </form>
    		</div>    		
    	</div>
    </div>
    <script src="bootstrap/js/fileinput.js" type="text/javascript"></script>
    <script src="bootstrap/js/fileinput_locale_zh.js" type="text/javascript"></script>
    <script>
	    $(document).ready(function() {
	        $("#test-upload").fileinput({
	            'showPreview' : false,
	            'allowedFileExtensions' : ['jpg', 'png','gif'],
	            'elErrorContainer': '#errorBlock'
	        });
	        /*
	        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
	            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
	        });
	        */
			var timer=setInterval(function(){
				var source=$("input[type='file']").val();
				if(source){
					console.log(source);
					$("#pinfo").val(source);
					clearInterval(timer);
				}
			},100);
	    });
		</script>
  </body>
</html>
