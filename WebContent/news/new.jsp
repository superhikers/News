<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<meta charset="utf-8">
		<title>新闻</title>
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/news/css/bootstrap.min.css" />
	<script src="${pageContext.request.contextPath}/news/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/news/js/bootstrap.min.js"></script>

	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<!--头部开始-->
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
							<a class="navbar-brand" href="index">News</a>
						</div>

						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
							<li class="active">
							 <c:choose>
									<c:when test="${user.username == null}">
										<a href="login.jsp">登录</a>
									</c:when>
									<c:otherwise>
										<a href="loginOut" >
											<div>用户：${user.username }</div>
										</a>
									</c:otherwise>
								</c:choose></li>
							<li><a href="#"> </a></li>

						</ul>
							<form class="navbar-form navbar-left" role="search">
								<div class="form-group">
									<input type="text" class="form-control" />
								</div>
								<button type="submit" class="btn btn-default">搜索</button>
							</form>
							<ul class="nav navbar-nav navbar-right">
								<div></div>
							</ul>
						</div>

					</nav>
					<!--头部结束-->

				</div>
				<br />
				<br /><br /><br /><br />
			</div>

			<!--具体新闻内容开始  -->
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-1 column">
							</div>
							<div class="col-md-10 column">
									<img class="img-responsive center-block" width="90%" alt=" " src="${pageContext.request.contextPath}/img/${oneNew.img}" />
	
									<h2 style="text-align: center;"  class="center-block">
										${oneNew.title}
									</h2><br /><br />
									<p style="font-size: 20px;">
										&nbsp;&nbsp;&nbsp;${oneNew.content}
									</p>
									<br /><br />
									<p >
										<h5 style="text-align:right;"  >编辑：${oneNew.author}</h5>
										<h5 style="text-align:right;"  >时间：${oneNew.date}</h5>
										
									</p>
									<br /><br />
							</div>
						</div>
						<div class="col-md-1 column">
						</div>
					</div>
				</div>
			</div>

			<!--具体新闻内容 结束 -->

			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="jumbotron">
						<h1>我是页脚！！！</h1>
						<p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
						<p>
							<a class="btn btn-primary btn-large" href="#">Learn more</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>