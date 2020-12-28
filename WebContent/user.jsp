<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="./css/user.css"/>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			img[src=""],img:not([src]){
			        opacity:0;
			    }
		</style>
	</head>

	<body>
		<script src="js/mui.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>
		<div class="mui-page-content">
			<img id="preview_photo" src="" width="200px" height="200px">
						<div class="mui-scroll-wrapper" data-scroll="2">
							<div  class="mui-scroll" style="transform: translate3d(0px, 0px, 0px) translateZ(0px);">
								<ul id="table-view" class="mui-table-view mui-table-view-chevron">
									<li class="mui-table-view-cell mui-media">
										<a id="table-view-cell" class="mui-navigate-right" href="<%=request.getContextPath() %>/UserServlet.do?method=uplaodimgpath">
											<img class="mui-media-object mui-pull-left head-img" id="head-img" src="<%=request.getContextPath() %>/UserServlet.do?method=downloadimg&user_img=${user.user_img}"><i id="upload_img" style="display: none;">点击上传头像</i>
											<input type="file" id="photoFile" style="display: none;" onchange="upload()">
											<div class="mui-media-body">
												<p id="name">name</p>
												<p class="mui-ellipsis">账号:.....</p>
											</div>
										</a>
									</li>
								</ul>
								<ul id="table-view2" class="mui-table-view mui-table-view-chevron">
									<li class="mui-table-view-cell">
										<a href="<%=request.getContextPath() %>/BudgetServlet.do?method=queryBudgetAll" class="mui-navigate-right">预算设置</a>
									</li>
								</ul>
								<ul id="table-view3" class="mui-table-view mui-table-view-chevron">
									<li class="mui-table-view-cell">
									<% //获取session对象
										HttpSession sesssion = request.getSession();
										//获取user Map
										String user_id = null;
										Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
										if(user==null){
											
										}else{
											//获取用户id
											user_id = (String) user.get("user_id");
										}
										%>
										<a href="<%=request.getContextPath()%>/UserServlet.do?method=doExportExcel&budget_user_id=<%=user_id%>" class="mui-navigate-right">导出数据为Excel</a>
									</li>
								</ul>
								<ul id="table-view3" class="mui-table-view mui-table-view-chevron">
									<li class="mui-table-view-cell">
										<a href="uppass.jsp" class="mui-navigate-right">修改密码</a>
									</li>
								</ul>
							
								<ul id="exit" class="mui-table-view">
									<li class="mui-table-view-cell" id="tuichu" style="text-align: center;display: none;">
										<a id="logout">退出登录</a>
									</li>
									<li class="mui-table-view-cell" id="denglu" style="text-align: center;display: block;">
										<a href="login.jsp">登录</a>
									</li>
								</ul>
							</div>
		<div class="tab_bottom">
			<ul class="tab_bottom_ul">
					<li class="pages">
						<a href="<%=request.getContextPath()%>/index.do?method=queryouts">
							<div class="mui-icon mui-icon-home">
								<span class="pages_name">首页</span>
							</div>
						</a>
					</li>
				<li class="pages">
						<a href="<%=request.getContextPath()%>/show.do?method=showTu">
							<div class="mui-icon mui-icon-bars">
								<span class="pages_name">统计</span>
							</div>
						</a>
					</li>
					<li class="pages">
						<a href="user.jsp">
							<div class="mui-icon mui-icon-contact">
								<span class="pages_name">个人主页</span>
							</div>
						</a>
					</li>
			</ul>
		</div>
		
		</div>
		
		<script type="text/javascript">
			$(function(){
				$.post("http://localhost:8089/rem_Money/UserServlet.do?method=showuser","",function(data){
						
						if(data==null){
							$("#upload_img").css({"display":"none"})
						}else{
							var user_uname = data.user_uname;
							var user_email = data.user_email;
							console.log(user_uname)
							console.log(user_email);
							$("#name").html(user_uname);
							$(".mui-ellipsis").html(user_email);
							$("#denglu").css({"display":"none"});
							$("#tuichu").css({"display":"block"});
							$("#upload_img").css({"display":"block"})
						}
				})
				
				$("#logout").click(function(){
					$.post("http://localhost:8089/rem_Money/UserServlet.do?method=logout","",function(data){
							window.location.href="login.jsp";
					})
					window.location.href="login.jsp";
				})
			})
			
			 function uploadPhoto() {
			        $("#photoFile").click();
			    }
			
		</script>
	</body>


</html>
