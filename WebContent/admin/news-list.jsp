<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<style>
	p {
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	overflow: hidden;
}
</style>
	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
		<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/Myjs/myJs.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
		<meta charset="utf-8">
		<title>新闻列表</title>
	</head>

	<body>
		<div class="x-nav">
			<span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">新闻列表</a>
            <a>
              <cite>新闻列表</cite></a>
          </span>
			<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
				<i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
		</div>
		<div class="layui-fluid">
			<div class="layui-row layui-col-space15">
				<div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-body ">
							<form class="layui-form layui-col-space5">

							</form>
						</div>
						<div class="layui-card-header">
							<!--<a href="send-news.jsp"><button class="layui-btn" ><i class="layui-icon"></i>添加</button></a>-->
						</div>
						<div class="layui-card-body ">
							<table class="layui-table layui-form">
								<thead>
									<tr>
										<!--<th>
                                    <input type="checkbox" name=""  lay-skin="primary">
                                  </th>-->
										<th>新闻id</th>
										<th>新闻标题</th>
										<th>新闻类型</th>
										<th>新闻内容</th>
										<th>新闻作者</th>
										<th>时间</th>
										<th>图片路径</th>
								</thead>
								<tbody id="orderTable">
									<c:forEach items="${NewsList}" var="n">
										<tr>
											<td>${n.id}</td>
											<td>${n.title}</td>
											<td>${n.type}</td>
											<td><p>${n.content}</p></td>
											<td>${n.author}</td>
											<td>${n.date}</td>
											<td>${n.img}</td>
											<td class="td-manage">
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="layui-card-body ">
							<div class="page">
								<div id="page"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>