<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/login.css"> 
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/upload.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<title>upload</title>
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
    <div class="container">
    	<h1>发布新宝贝！</h1>
    	<hr>
    </div>
	<section class="section-3">
		<div class="container container-small">
			<form action="CommodityInsert" method="post" enctype="multipart/form-data" class="form-horizontal tab-pane fade in active" id="oploadform" role="form">
				<div class="form-group">
						<label class="col-sm-2 control-label">标题:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="title"  name="commodity_name">
							<span id="titleSpan"></span>
						</div>
					</div>
				<div class="form-group">
						<label class="col-sm-2 control-label">简介:</label>
						<div class="col-sm-10">
							<textarea form="oploadform" class="form-control" id="textarea" name="commodity_content"></textarea>
							<span id="textareaSpan"></span>
						</div>
				</div>
				<div class="form-group">
						<label class="col-sm-2 control-label">价格:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="money"  name="commodity_money">
							<span id="moneySpan"></span>
						</div>
					</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">分类:</label>
					<div class="col-sm-10">
						<c:forEach items="${requestScope.commodityTypes }" var="commodityType">
							<label class="radio-inline">
								<input type="radio" name="commodity_type" id="radio1" value="${commodityType.commodity_type }" checked>	
								<span>${commodityType.explains }</span>
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
						<label  class="col-sm-2 control-label">图片:</label>
						<div class="col-sm-4" style="margin-top: 5px;">
							<input type="file" name="img" id="file" class="">
						</div>
				</div>
				<hr>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<button type="submit" class="btn btn-primary btn-block">发 布</button>
					</div>
				</div>
			</form>
            </div>
		</div>
	</section>
</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/upload.js"></script>
</html>