<%@ page language="java" contentType="text/html;charset=utf-8" 
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
	
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/xadmin.css">
<script
	src="${pageContext.request.contextPath}/admin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/Myjs/myJs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
<script src="js/jquery.min.js"></script>
<meta charset="utf-8">
<title>新闻列表</title>
	<script src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
　　<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/HtmlBox/htmlbox.colors.js"></script>
　　<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/HtmlBox/htmlbox.styles.js"></script>
　　<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/HtmlBox/htmlbox.syntax.js"></script>
　　<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/HtmlBox/htmlbox.undoredomanager.js"></script>
　　<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/HtmlBox/htmlbox.min.js"></script>
</head>

<body>
	<br /><br /><br />
	
	<div class="layui-row">
		<div class="layui-col-xs3">
			<div class="grid-demo grid-demo-bg1"> &nbsp;</div>
		</div>
		<div class="layui-col-xs6">
			<div class="grid-demo grid-demo-bg1">
				<!--form-->
				<h2>新闻发布</h2><br />
				<form class="layui-form" action="sendNews" method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<label class="layui-form-label">新闻标题</label>
						<div class="layui-input-block">
							<input type="text" name="title" lay-verify="title"
								autocomplete="off" placeholder="请输入标题" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">新闻类型</label>
						<div class="layui-input-block">
							<input type="text" name="type" lay-verify="type"
								autocomplete="off" placeholder="请输入新闻类型" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">新闻内容</label>
						<div class="layui-input-block">
							<textarea placeholder="新闻内容" name="content" class="layui-textarea" id="htmlbox_icon_set_green"></textarea>
							<!--<script language="Javascript" type="text/javascript">
								var hb_icon_set_green = $("#htmlbox_icon_set_green").css("height","400").css("width","583").
								htmlbox({toolbars:[["cut","copy","paste","separator_dots","bold","italic","underline","strike",
								"sub","sup","separator_dots","undo","redo","separator_dots","left","center","right","justify",
								"separator_dots","ol","ul","indent","outdent","separator_dots","link","unlink","image"],  
								["code","removeformat","striptags","separator_dots","quote","paragraph","hr","separator_dots",    
								{icon:"new.gif",tooltip:"New",command:function(){hb_icon_set_green.set_text("<p></p>");}},    
								{icon:"open.gif",tooltip:"Open",command:function(){alert('Open')}},    
								{icon:"save.gif",tooltip:"Save",command:function(){alert('Save')}}]], 
								icons:"default", skin:"green"});</script>-->
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">作者</label>
						<div class="layui-input-block">
							<input type="text" name="author" lay-verify="author"
								autocomplete="off" placeholder="作者" class="layui-input">
						</div>
					</div>
					${sendInfo}
					<div class="layui-form-item">
						<label class="layui-form-label">图片上传</label>
						<div class="layui-input-block">
							<input type="file" name="img" lay-verify="title" accept=".png,.jpg"
								autocomplete="off"  class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="submit" class="layui-btn">发布</button>
						</div>
					</div>
				</form>


			</div>
		</div>
		<div class="layui-col-xs3">
			<div class="grid-demo">&nbsp;</div>
		</div>
	</div>



	<!--<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label for="username" class="layui-form-label"> <span
						class="x-red">*</span>新闻标题
					</label>
					<div class="layui-input-inline">
						<input type="text" id="title" name="title" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>
					</div>
				</div>
				<div class="layui-form-item">
					<label for="phone" class="layui-form-label"> <span
						class="x-red">*</span>新闻类型
					</label>
					<div class="layui-input-inline">
						<input type="text" id="type" name="type" required=""
							lay-verify="phone" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span id="checkPhone" class="x-red">*</span>
					</div>
				</div>
				<div class="layui-form-item">
					<label for="s_age" class="layui-form-label"> <span
						class="x-red">*</span>新闻内容
					</label>
					<div class="layui-input-inline">
						<textarea placeholder="新闻内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>新闻作者
					</label>
					<div class="layui-input-inline">
						<input type="text" id="author" name="author" required=""
							lay-verify="repass" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> <span
						class="x-red">*</span>图片
					</label>
					<div class="layui-input-inline">
						<input type="file" id="img" name="img" accept=".png,.jpg"
							required="" lay-verify="repass" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
				</div>
			</form>
			<button id="staffAdd" class="layui-btn">发布</button>
		</div>
	</div>-->

</body>

</html>