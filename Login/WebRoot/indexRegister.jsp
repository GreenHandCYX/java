<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
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
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">		
		function password(){
		
		var pwd1=document.getElementById("passWord").value;
		var pwd2=document.getElementById("passWord2").value;
			if(pwd1.length<3){
			$("#passWord").val("").focus();
			alert("密码必须大于3位，请重新输入");
			}
		}
		function password2(){
	
		var pwd1=document.getElementById("passWord").value;
		var pwd2=document.getElementById("passWord2").value;
			if(pwd1!=pwd2&&pwd2!=""){
			$("#passWord2").val("").focus();
			alert("两次密码输入不一致，请重新输入");
			
			}
		}
		
		function reWrite(){
		$("input[type='text']").val("");
		$("textarea").val("");
		$("input[type='file']").val("");
		}
		function sendRequest(){
			var userName = $("#userName").val();
			$.ajax({
				type:'post',
				url:"LoginServletSecond?action=query",
				data:{userName:userName},
				dataType:"json",
				async:false,
				success:function(result,state){		
				if(result=="ok"){
								alert("已经有这个用户啦！换一个用户名试试吧！");
						$("#userName").val("").focus();
					}
				},
			});
		}
		
		
		function sendadd(){
		var userName = $("#userName").val();
		var passWord = $("#passWord").val();
		
		var email = $("#email").val();
	
		var info = $("#info").val();
	
				if(userName==""||email==""||info==""){	
					if(userName=="")
					{
						$("#userName").focus();
						alert("用户名不为空");
					}
					
					else if(email=="")
					{
						$("#email").focus();
						alert("邮箱不为空");
						}
						else if(info=="")
					{
						$("#info").focus();
						alert("个人简介不为空");
						}
				
				}
			
		}
		

	
	</script>
<style>
.container{
margin-top:3%;
}
body{
		background-image: url("imac.png");
		background:#ccc url("imac.png") no-repeat fixed 50% 0%;
		background-size:64% 121%;

		}
</style>
</head>
<body>
<div class="container">

 <div class="panel panel-info">
 <div class="panel-heading">注册</div>
  <div class="panel-body">
<form class="form-horizontal" action="LoginServletSecond?action=add" method="post">
	<div class="input-group input-group-lg">
	  <span class="input-group-addon">用户名</span>
	  <input type="text" name="userName" class="form-control" id="userName" onblur="sendRequest()">
	</div><br>
  	<div class="input-group input-group-lg">
	    <span class="input-group-addon">密码</span>
	    <input  type="password" name="passWord" class="form-control" id="passWord">
	</div><br>
	<div class="input-group input-group-lg">
	  <span class="input-group-addon">再次确认</span>
	  <input type="password" name="passWord" class="form-control" id="passWord2"  onfocus="password()" onblur="password2()">
	</div><br>
	<div class="input-group input-group-lg">
	  <span class="input-group-addon">邮箱</span>
	  <input type="text" name="email" class="form-control" id="email" >
	</div><br>
    <div class="form-group">
	<span class="input-group-addon">性别</span>
    <div class="col-sm-offset-2 col-sm-10">
      <label class="radio-inline">
		  <input class="input-group"type="radio" id="sex" name="sex" value="男"> 男
		</label>
		<label class="radio-inline">
		  <input class="input-group"type="radio" id="sex" name="sex" value="女"> 女
		</label>
		<label class="radio-inline">
		  <input class="input-group"type="radio"id="sex" name="sex" value="保密"> 保密
		</label>
    </div>
 	</div><br>
  
  <div class="form-group">
  <span class="input-group-addon">个人简介</span>
  <textarea class="form-control text-info" rows="2" name="info" id="info"></textarea>
  </div>
  <div class="form-group">
  		<span class="input-group-addon">头像</span>
		<input type="button" class="btn btn-danger btn-lg btn-block"  value="已上传头像">
	<img src="onload/image/${picture }" width=50 height=50 align="middle">
		<input type="hidden"  name="picture"  value="${picture }">
  </div>

  </div>
  <div class="panel-footer  panel-info">
	<button type="submit" value="Submit"onclick="sendadd()" class="btn btn-info btn-lg btn-block">提交</button>
<button type="reset" onclick="reWrite()" class="btn btn-default btn-lg btn-block">重新输入</button>
  </div>
 </form>
</div>
</div>
</body>


</html>
