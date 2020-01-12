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
							<h2>新闻内容修改</h2>
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
										<th>操作</th>
								</thead>
								<tbody id="orderTable">${changeInfo}
									<c:forEach items="${NewsList}" var="n">
										<form class="layui-form" action="change-news" method="post">
										<tr>
											<td>
												<input readonly  unselectable="on" type="text" name="id" lay-verify="title"autocomplete="off" value="${n.id}" class="layui-input">
												
												</td>
											<td>
												<input type="text" name="title" lay-verify="title"autocomplete="off" value="${n.title}" class="layui-input">
											</td>
											<td>
												<input type="text" name="type" lay-verify="title"autocomplete="off" value="${n.type}" class="layui-input">
												
											</td>
											<td><p>
												<textarea value="" name="content" class="layui-textarea" id="htmlbox_icon_set_green">${n.content}</textarea>
											</p></td>
											<td>
												<input type="text" name="author" lay-verify="title"autocomplete="off" value="${n.author}" class="layui-input">
											</td>
											<td>
												${n.date}
											</td>
											<td>
												${n.img}
											</td>
											<td class="td-manage">
													<!--<a onclick="member_stop(this,'10001')" href="javascript:;" title="启用">
														<i class="layui-icon">&#xe601;</i>
													</a>-->
													<!--<a title="修改内容" href="">-->
														<input type="submit" class="layui-btn" />
														<!--<i class="layui-icon">&#xe642;</i>
													</a>-->
													<a title="删除"  href="deleteNews?id=${n.id}">
														<i class="layui-icon">&#xe640;</i>
													</a>
												</td>
										</tr>
										</form>
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