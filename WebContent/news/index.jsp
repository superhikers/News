<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/news/css/bootstrap.min.css" />
	<script src="${pageContext.request.contextPath}/news/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/news/js/bootstrap.min.js"></script>
<style>
	p {
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 5;
	overflow: hidden;
}
h3{
display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	overflow: hidden;
}
</style>
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
											<a href="loginOut">
												<div>用户：${user.username }</div>
											</a>
										</c:otherwise>
									</c:choose>
								</li>
								<li>
									<a href="#"> </a>
								</li>

							</ul>
							<!--<form class="navbar-form navbar-left" role="search">
								<div class="form-group">
									<input type="text" class="form-control" />
								</div>
								<button type="submit" class="btn btn-default">搜索</button>
							</form>-->

							<ul class="nav navbar-nav navbar-right">

							</ul>
						</div>

					</nav>
					<!--头部结束-->

					<!--轮播图开始-->
					<div class="carousel slide" id="carousel-787698">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel-787698" class="active"></li>
							<li data-slide-to="1" data-target="#carousel-787698"></li>
							<li data-slide-to="2" data-target="#carousel-787698"></li>
							<li data-slide-to="3" data-target="#carousel-787698"></li>
						</ol>
						<div class="carousel-inner" style="height: 450px;">
							<div class="item active">
								<img alt="" src="${pageContext.request.contextPath}/img/banner_4.png" />
								<div class="carousel-caption">
									<h4>交通部：1月1日起全国487个高速省界收费站全部撤销 助力节能减排，降本增效          </h4>
									<p>中新网客户端北京1月1日电 (记者 程春雨)2019年12月31日晚，取消高速公路省界收费站工程并网切换如期进行，深化收费公路制度改革取消高速公路省界收费站工作领导小组组长、交通运输部部长李小鹏指挥切换并宣布，取消高速公路省界收费站工程并网切换圆满成功。深化收费公路制度改革取消高速公路省界收费站，是关系人民群众切实利益的民生工程，具有巨大的经济社会效益。取消高速公路省界收费站以后，全国高速公路一张网将有效提高综合交通运输体系运转效率，缓解拥堵、改善人民群众出行体验，助力节能减排，降本增效。</p>
								</div>
							</div>
							<c:forEach items="${bannerList}" var="b">

								<div class="item " align="center">
									<img alt="" src="${pageContext.request.contextPath}/img/${b.img}" />
									<div class="carousel-caption" align="center" style="text-align: center;">
										<h3>${b.title}</h3>
										<p>${b.content} </p>
									</div>
								</div>
							</c:forEach>
						</div>
						<a class="left carousel-control" href="#carousel-787698" data-slide="prev">
							<img class="glyphicon glyphicon-chevron-left" src="${pageContext.request.contextPath}/news/img/icon/上一页 .png" />
						</a>
						<a class="right carousel-control" href="#carousel-787698" data-slide="next">
							<img class="glyphicon glyphicon-chevron-right" src="${pageContext.request.contextPath}/news/img/icon/下一页.png">
						</a>
					</div>
					<!--轮播图结束-->
					<br />

					<!--具体新闻页面开始-->
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="row">
								<c:forEach items="${allList}" var="all">
									<div class="col-md-4">
										<a href="new?id=${all.id}">
											<div class="thumbnail">
												<img style="height: 220px; width: auto;" alt=" " src="${pageContext.request.contextPath}/img/${all.img}" />
												<div class="caption">
													<h3>${all.title}</h3>
													<p>${all.content}</p>
													<p>
														<!--<a class="btn btn-primary" href="#">查看</a> <a class="btn"
													href="#">查看</a>-->
													</p>
												</div>
											</div>
										</a>
									</div>
								</c:forEach>
								

							</div>
						</div>
					</div>

					<!--具体新闻页面结束-->

				</div>
			</div>
			<div class="jumbotron text-center" style="margin-bottom:0">
				<!--页脚开始、-->
				<div class="foot">
					<div style="height: 20px;"></div>
					<a href="#"><img class="imgg" width="30px" src="${pageContext.request.contextPath}/news/img/foot/wx01.png"></a>&nbsp;&nbsp;
					<a href="#"><img class="imgg" width="30px" src="${pageContext.request.contextPath}/news/img/foot/wb.png"></a>&nbsp;&nbsp;
					<a href="#"><img class="imgg" width="28px" src="${pageContext.request.contextPath}/news/img/foot/qq.png"></a>
					<p>©2004-2019 linbo版权所有。<br> 由gzgs主持的html
					</p>
				</div>
				<!--页脚结束-->
			</div>
		</div>
	</body>

</html>