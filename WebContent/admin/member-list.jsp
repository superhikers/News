<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

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
		<title>用户列表</title>
	</head>

	<body>
		<div class="x-nav">
			<span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">用户管理</a>
            <a>
              <cite>用户列表</cite></a>
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
							<button class="layui-btn" onclick="xadmin.open('添加用户','./admin-add.html',600,400)"><i class="layui-icon"></i>添加</button>
						</div>
						<div class="layui-card-body ">
							<table class="layui-table layui-form">
								<thead>
									<tr>
										<!--<th>
                                    <input type="checkbox" name=""  lay-skin="primary">
                                  </th>-->
										<th>ID</th>
										<th>登录名</th>
										<th>密码</th>
										<th>权限</th>
										<th>状态</th>
										<th>操作</th>
								</thead>
								<tbody id="orderTable">
									<c:forEach items="${userList}" var="u">
										<tr>
											<td>${u.id}</td>
											<td>${u.username}</td>
											<td>${u.password}</td>
											<td>
												<c:choose>
													<c:when test='${u.power==0}'>
														管理员
													</c:when>
													<c:otherwise>
														普通用户                   
													 </c:otherwise>
												</c:choose>
											</td>
												<td class="td-status">
													<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
												<td class="td-manage">
													<!--<a onclick="member_stop(this,'10001')" href="javascript:;" title="启用">
														<i class="layui-icon">&#xe601;</i>
													</a>-->
													<a title="修改权限" href="member-list?id=${u.id}&power=${u.power}">
														<i class="layui-icon">&#xe642;</i>
													</a>
													<!--<a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
														<i class="layui-icon">&#xe640;</i>
													</a>-->
												</td>
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