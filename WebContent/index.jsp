<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>同校优品</title>
</head>
<body>
	<header>
		<nav id="navbar-example" class="navbar navbar-default" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse"></button>
					<a class="navbar-brand" href="index.html">
					</a>
				</div>
				<div class="collapse navbar-collapse bs-js-navbar-scrollspy" id="example-navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${sessionScope.user!=null }">
							<li style="line-height: 30px;color:#fff">欢迎您，${sessionScope.user.name}</li>
						</c:if>
						<c:if test="${sessionScope.user==null }">
							<li><a href="login.html">登录</a></li>
							<li><a href="register.html" class="">注册</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<section class="middle">
		<div class="container">
			<h1>>在同校优品淘到心仪的宝贝</h1>
			<hr>
			
			<div class="col-lg-6 ctgu">
				<div class="card-group">
					<h3>三峡大学</h3>
					<p>来三峡大学二手市场逛逛</p>
					<button onclick="location.href='more.html'" class="btn btn-primary">进入</button>
				</div>				
			</div>
			<div class="col-lg-6 ctgu">
				<div class="card-group">
					<h3>三峡大学科技学院</h3>
					<p>来科院找找喜欢的宝贝</p>
					<button onclick="location.href='more.html'" class="btn btn-primary">进入</button>
				</div>				
			</div>
			<div class="col-lg-6 htgp">
				<div class="card-group">
					<h3>三峡职业技术学院</h3>
					<p>三职欢迎您：）</p>
					<button onclick="location.href='more.html'" class="btn btn-primary">进入</button>
				</div>				
			</div>
			<div class="col-lg-6 cteu">
				<div class="card-group">
					<h3>三峡电力职业学校</h3>
					<p>三电的好东西</p>
					<button onclick="location.href='more.html'" class="btn btn-primary">进入</button>
				</div>				
			</div>
		</div>
	</section>
	<section class="section-2">
		<div class="container">
			<hr>
			<h1>>服务</h1>
			<hr>
			<div class="col-lg-4">
				<div class="card-group">
					<h3>发布新玩意!</h3>
					<p>让更多人看见更多喜欢的东西</p>
					<button class="btn btn-primary">立刻发布</button>
				</div>
			</div>
			<div class="col-lg-4 habbit">
				<div class="card-group">
					<h3>加入我们!</h3>
					<p>发现你的兴趣</p>
					<button class="btn btn-primary">联系我们</button>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="card-group">
					<h3>选择一个您有的社交账号</h3>
					<p>都可以联系我们：</p>
					<div class="a-group">
						<ul>
							<li class="wb"><a class="fa fa-weibo" href="" target="_blank"></a></li>		
							<li class="qq"><a class="fa fa-qq" href="http://www.qq.com/" target="_blank"></a></li>
							<li class="wx"><a class="fa fa-wechat" href="http://weixin.qq.com/" target="_blank"></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="container">
			<hr>
			<div class="foot" style="text-align: right;">
				<p>&copy;同校优品</p>
			</div>
		</div>
	</footer>
</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</html>