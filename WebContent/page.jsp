<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/page.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>商品详情</title>
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
	<section class="head">
		<div class="container">
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7 text-section">
				<h2><div class="_suz">鞋 · ${requestScope.commodity.commodity_name }</div></h2>
				
				<div class="_l8">卖家：<span>${requestScope.seller.name }</span></div>
				<div class="_l8">价格 ：${requestScope.commodity.commodity_money }</div>
				<div class="_l8">时间 ：${requestScope.commodity.datetime }</div>
				<div class="_l8">简介 ：${requestScope.commodity.commodity_content }</div>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 img-section">
				<img src="${requestScope.commodity.img }">
			</div>
		</div>
	</section>
	<section class="mid">
		<div class="container">
			<hr>
			<div class="col-lg-7">
				<div class="comment-list">
                    <div class="comment-box">
                    	<c:forEach   items="${requestScope.comments }" var="comment">
                    		<div class="comment-content">
	                            <p class="comment-text"><span class="user">${comment.username }说：</span>${comment.content }</p>
	                            <p class="comment-time">
	                                ${comment.datetime }
	                            </p>
                       	 	</div>
						</c:forEach >
                        <div class="comment-content">
                            <p class="comment-text"><span class="user">我：</span>写的太好了。</p>
                            <p class="comment-time">
                                2014-02-19 14:36
                            </p>
                        </div>
                    </div>
                </div>
                <form action="CommentInsert" method="post" class="form-horizontal tab-pane fade in active" id="normalregister" role="form" >
                	<input type="text" style="display: none" value="${requestScope.commodity.id }" name="commodity_id">
                    <input class="comment col-lg-10 col-sm-10 col-md-10" placeholder="评论…" style="padding: 6px;" name="content" id="content">
                    <button  type="submit" class="col-lg-2 col-sm-2 col-md-2 btn btn-primary" >回复</button>
              	</form>
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