<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/more.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/jkresponsivegallery.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>所有商品</title>
</head>
<body>
	<header>
		<nav id="navbar-example" class="navbar navbar-default" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse"></button>
					<a class="navbar-brand" href="index.jsp">
					</a>
				</div>
				<div class="collapse navbar-collapse bs-js-navbar-scrollspy" id="example-navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${sessionScope.user!=null }">
							<li style="line-height: 30px;color:#fff">欢迎您，${sessionScope.user.name}</li>
						</c:if>
						<c:if test="${sessionScope.seller!=null}">
							<li style="line-height: 50px;color:#fff">欢迎您，${sessionScope.seller.name }</li>
							<li><a href="Upload" class="">发布</a></li>
						</c:if>
						<c:if test="${sessionScope.user==null && sessionScope.seller == null }">
							<li><a href="login.html">登录</a></li>
							<li><a href="register.html" class="">注册</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<section class="section-1 ">
		<div class="container">
			<h1>>三峡大学</h1>
			<h4 class="_n6">
				在这里找到您爱的东西
			</h4>
			<hr>
			<div class="nav-section">
				<ul class="nav">
					<span>分类：</span>
					<li class="active" data-filter="all">全部</li>
					<c:forEach   items="${requestScope.commodityTypes }" var="commodityType">
					   <li data-filter="${commodityType.commodity_type }">${commodityType.explains }</li>
					</c:forEach >
				</ul>
			</div>
			<hr>
			<div class="filter">
				<div class="sale-section">
					<c:forEach   items="${requestScope.commodities }" var="commodity">
						<a href="Page?id=${commodity.id }" class="filtr-item sale-one col-lg-3 col-md-4 col-sm-6 col-xs-6" data-category="${commodity.commodity_type }">
							<div class="img-section">
								<img src="${commodity.img }">
							</div>
							<div class="text-section">
								<div class="_suz">${commodity.commodity_name }</div>
								<p class="_1o">${commodity.commodity_content }</p>
								<div class="jt">
									<span id="time" class="time">${commodity.datetime }</span> 
									<span class="_jg">${commodity.commodity_money }￥ / 件</span>
								</div>
							</div>
						</a>
					</c:forEach >
				</div>
			</div>
			<hr>
		</div>
	</section>
	<footer>
		<div class="container">
			<div class="foot" style="text-align: right;">
				<p>&copy;同校优品</p>
			</div>
		</div>
	</footer>
</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script src="js/jquery.filterizr.js"></script>
	<script type="text/javascript">
		$('.filter').filterizr();
		$('.nav li').on('click', function() {
		$(this).toggleClass('active').siblings().removeClass('active');
	});
	</script>
</html>