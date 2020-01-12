<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
<!-- <link rel="stylesheet" href="./css/theme5.css"> -->
<script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/Myjs/myJs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
<meta charset="utf-8">
<title>新闻后台管理系统</title>
</head>
<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.html">新闻后台管理系统</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>

		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item">
			<a  >
				管理员：${adminUser.username }
			</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					
					<dd >
						<a href="adminLogout">退出</a>
					</dd>
					
				</dl></li>
			<li class="layui-nav-item to-index"><a href="../news/index">前台首页</a></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="用户管理">&#xe6b8;</i> <cite>用户管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('用户列表','member-list')">
								<i class="iconfont">&#xe6a7;</i> <cite>用户列表</cite>
						</a></li>
						<!--<li><a onclick="xadmin.add_tab('用户删除','member-del.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>用户删除</cite>
						</a></li>-->
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="新闻管理">&#xe723;</i> <cite>新闻管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('新闻列表','news-list')">
								<i class="iconfont">&#xe6a7;</i> <cite>新闻列表</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('新闻发布','send-news.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>新闻发布</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('新闻修改','news-change')">
								<i class="iconfont">&#xe6a7;</i> <cite>新闻修改</cite>
						</a></li>
					</ul>
					
					</li>
				<!--<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="管理员管理">&#xe726;</i> <cite>管理员管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('管理员列表','admin-list.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>管理员列表</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('管理员列表','admin-del.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>管理员删除列表</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('角色管理','admin-role.jsp')">
								<i class="iconfont">&#xe6a7;</i> <cite>角色管理</cite>
						</a></li>
					</ul></li>-->
				
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='./welcome.html' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<style id="theme_style"></style>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
</body>
</html>