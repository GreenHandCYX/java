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

		<title>校园学习网</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script> 
		<link rel="stylesheet" type="text/css"
			href="bootstrap/css/bootstrap.min.css">
			<link rel="stylesheet" type="text/css"
			href="bootstrap/css/scrollstyle.css">
		<script type="text/javascript">
			function forward(){
				window.location.href="index.jsp";
			}
			function shoppingcart(){
				window.location.href="MyCart.jsp";
			}
			
			$(function(){
			
			$.ajax({
			url:"LoginServletFirst?action=show",
			type:"post",
			data:{},
			datatype:"json",
			success:function(data){
			
			var obj="onload/image/"+eval("("+data+")");
			
			$("#picture").attr("src",obj);
			
			}
			});
		});
		
		</script>
		<style>
body{
	padding-top:50px;
	}
nav{	
    font-family:"黑体";
    }
	.carousel{
		
		height:500px;
		}
	.carousel .item{
	
        height:500px;
		}
	.carousel img{
		width:100%;
		padding-top:15px;  
		}
    .carousel-caption p{
            font-size:20px;
			margin-bottom:20px;
	
        }
	.col-lg-3 p{
		text-align:center;
		}
			hr .divider{
		margin:40px 0;
		}
	.feature{
		padding:30px 0;
		}
	.feature-heading{
		font-size:50px;
		color:#09F;
		margin-top:120px;
		}
	.feature-heading .text-muted{
		font-size:28px;
		color:#999;
</style>
<script type="text/javascript">
		window.onload=function(){
			var btn=document.getElementById("btn");
					//获取当前可视界面高度，当滚轮上间距高于屏幕可视高度
				//var clientHeight=document.documentElement.clientHeight;
				
				var isTop=true;
				var timer=null
				//滚动条滚动时触发
				window.onscroll=function(){
				var scroTop=document.body.scrollTop||document.documentElement.scrollTop;
					if(!isTop){
					clearInterval(timer);
					}
					isTop=false;
					if(scroTop>=455){
					btn.style.display="block";
					
					}
					else{
					btn.style.display="none";
					}
				}
			btn.onclick=function(){
	
					
				timer=setInterval(function(){
				scroTop=document.body.scrollTop||document.documentElement.scrollTop;
				
				var oTop=Math.floor(scroTop/6);
					document.body.scrollTop=scroTop-oTop;
					isTop=true;
					console.log(scroTop-oTop);
					if(scroTop>=clientHeight){
						btn.style.display="block";
					}
					if(scroTop==5){
						clearInterval(timer);
					}
				},30);
				
			}
			//滚动条滚动事件使滚动
			
		}
	</script>
	</head>


<body>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">校园学习网</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="active"><form class="navbar-form "><input type="botton" class="btn btn-default btn-lg disabled" value="首页"></form></li>
        <li >
           <form class="navbar-form" action="ShoppingCartServlet?action=listShoppingCart" method="post">
			 	<input type="hidden" class="btn btn-primary"name="uid1" value="${sessionuser }"/>
				<input  type="submit"   class="btn btn-default btn-lg" onclick="mydate()" value="我的收藏夹"/>
			</form> 
        </li>
        <li><form class="navbar-form" action="KindServlet?action=listAllKind" method="post">
				<input  type="submit" class="btn btn-default btn-lg" value="查看类别"/>
			</form></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          尊敬的用户：
          <img class="img-circle" alt="#" id="picture" width=50 height=50><b>${sessionuserall.userName }</b>&nbsp&nbsp您好!
		 
        </div>
       
      </form>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


  <!---轮播图--->

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
      	  <!-- 底部轮播点 -->

          <ol class="carousel-indicators " >
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active" style="background-color:gray;"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1" style="background-color:gray;"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2" style="background-color:gray;"></li>
          	 <li data-target="#carousel-example-generic" data-slide-to="3" style="background-color:gray;"></li>
          </ol>

          <!-- 轮播图片 -->

          <div class="carousel-inner" role="listbox" >
            <div class="item active">
              <img src="image2/1.PNG" align="middle"alt="1 slide" style="height:100%;width:100%">
              
            </div>
            <div class="item">
              <img src="image2/2.PNG"  alt="2 slide" style="height:100%;width:100%">
              
            </div>
            <div class="item">
              <img src="image2/3.PNG" alt="3 slide" style="height:100%;width:100%">
              
            </div>
			<div class="item">
              <img src="image2/4.PNG" alt="4 slide" style="height:100%;width:100%">
              
            </div>
          </div>

          <!-- 轮播按钮 -->

          <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">上一页</span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">下一页</span>
          </a>
	</div>
	<br>
	<hr>
	<!----四栏简介布局---->
    <div class="container">
		<div class="page-header">
			  <h1><span class="label label-success">New</span>精品好课<small>from here</small></h1>
		</div>
    	<div class="row">
		<c:forEach items="${sessionShopping }" var="shopping">
        	<div class="col-lg-3">
            	<img class="img-rounded" alt="#" src="onload/image/${shopping.purl}" width=200 height=200>
                <p><span><h2>${shopping.pname }&nbsp&nbsp<b style="color:red;">${shopping.price }</b>RMB</h2></span></p>
                <h3>${shopping.pinfo }</h3>
               
					<form action="ShoppingCartServlet?action=addShoppingCart" method="post">
								<input type="hidden" name="uid" value="${sessionuser }"/>
								<input type="hidden" name="pid" value="${shopping.pid }"/>
	  			<p><i  style="float:left;display:inline-block;width:75px;height:20px;line-height:20px;overflow:hidden;">${shopping.pTime }</i><input style="float:right;margin:-10px 20px 20px -10px;" class="btn btn-default btn-lg" type="submit" value="点我收藏"></p>
					</form>
            </div>
          </c:forEach>
        </div>
		
    </div>
    <hr/>
    <!---标签页--->
     
    <div class="container">
    	<div class="page-header">
			  <h1><span class="label label-danger">Hot</span>热门职业 <small>following</small></h1>
		</div>
    	<!-- 标签 -->
    	<ul class="nav nav-tabs" role="tablist">
        	<li role="presentation" class="active">
            	<a href="#1" role="tab" data-toggle="tab">Web</a>
            </li>
            <li role="presentation">
            	<a href="#2" role="tab" data-toggle="tab">Php</a>
            </li>
            <li role="presentation">
            	<a href="#3" role="tab" data-toggle="tab">Android</a>
            </li>
        
         </ul>
         
         <!-- 标签所指内容 -->
        
    <div class="tab-content">
         <div class="tab-pane active" id="1" role="tabpanel">
         	<div class="row feature">
            	<div class="col-md-5">
            	   <h2 class="feature-heading">WEB前端工程师 
                    <span class="text-muted">Web Developer</span>
                    </h2>
                    <p class="lead">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/Flash等各种Web技术进行客户端产品的开发。完成客户端程序（也就是浏览器端）的开发，开发JavaScript以及Flash模块，同时结合后台开发技术模拟整体效果，进行丰富互联网的Web开发，致力于通过技术改善用户体验。</p>
                </div>
                <div class="col-md-7">
                	<img  src="image2/5.jpg" alt="Chrome" style="width:500px;height:500px;">
                </div>
         	</div>
         </div>
         <div class="tab-pane" id="2" role="tabpanel">
         	<div class="row feature">
            	<div class="col-md-7">
            	
                	  <h2 class="feature-heading">PHP工程师
                    <span class="text-muted">PHPer</span></h2>
                	<p class="lead">PHP技术人才，正迎合了目前的互联网的发展趋势；PHP作为非常优秀的、简便的Web开发语言，和Linux，Apache，MySQL紧密结合，形成LAMP的开源黄金组合，不仅降低使用成本，还提升了开发速度，满足最新的互动式网络开发的应用，这使得php软件工程师成为一个发展迅速的职业。
</p>
                </div>
                <div class="col-md-5">
               	<img  src="image2/6.jpg" alt="Chrome" style="width:500px;height:500px;">
                </div>
         	</div>
         </div>
         <div class="tab-pane" id="3" role="tabpanel">
         	<div class="row feature">
            	<div class="col-md-5">
            	<img  src="image2/7.jpg" alt="Chrome" style="width:500px;height:500px;">
                	
                </div>
                <div class="col-md-7">
                	 <h2 class="feature-heading">Android工程师
                    <span class="text-muted">移动应用开发者
</span></h2>
                	<p class="lead">Android工程师是指从事Android移动应用操作系统、游戏和各种Android平台功能的应用、 以手机开发为主要对象，包括但不限于手机操作系统、手机游戏、手机其他多种功能的开发和优化人员。Android工程师是移动应用开发者，希望将自己的应用移植到该平台上或者在该平台上开发应用。</p>
                </div>
         	</div>
         </div>
     </div>
      <hr/>
		 <button class="btn btn-default btn-lg btn-block" id="restore" onclick="forward()">注销登录</button>
		 <a href="javascript:;" id="btn" title="回到顶部"></a>
</body>
</html>
