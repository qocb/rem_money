<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="js/mui.min.js"></script>
	<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/index.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/mobile-keyboard.min.js" type="text/javascript" charset="utf-8"></script>
	
	<link href="css/mui.min.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="css/all.css"/>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
    </script>
	<style type="text/css">
		.rotate{
			height: 3.125rem;
		}
		.rotate h4{
			text-align: center;
			float: left;
			padding: 0.625rem 4rem;
		}
		.current{
			border-bottom: 0.125rem solid #000000;
		}
	</style>
</head>
<body>
	<header id="index_head">
		<span id="index_title">日常记账本</span>
	</header>
	<br />
	<br />
	<br />
	<br />
	<div id="monthMsg">
		<span id="out_span">
			本月支出:
		</span>
		<i id="outmoney">￥<%=request.getAttribute("monthoutnum") %></i>
		<br>
		<br>
		<span id="get_span">
			本月收入:
		</span>
		<i id="getmoney">￥<%=request.getAttribute("monthgetnum") %></i>
	</div>
	<div id="todayMsg" class="Msgstyle">
		<h3  id="todayMsg_title">交易记录</h3>
		<div class="rotate">
			<h4 id="zhichu" ><a href="http://localhost:8089/rem_Money/index.do?method=queryouts">支出</a></h4>
			<h4 class="current" id="shouru"><a href="http://localhost:8089/rem_Money/index.do?method=query">收入</a></h4>
		</div>
		
		<ul id="todayMsg_content">
		
		<% List gets_list = (List)request.getAttribute("gets_list");
		 	for(int i = 0;i<gets_list.size();i++){
		 		
		 		Map gets_map =(Map)gets_list.get(i);
		 	
	 		%>
			<li class="content_li">
				<span class="content_title"><%=gets_map.get("get_name") %></span>
				<span class="content_money"><%="+￥"+gets_map.get("get_money") %></span>
				<br>
				<i class="content_type">收入</i>
				<i class="content_time"><%=gets_map.get("get_date") %></i>
			</li>
			<%} %>
			
		</ul>
	</div>
	
	<div id="allMsg" class="Msgstyle">
		<ul>
		
			<li class="content_li">
				<span class="content_title">今日</span>
				<span class="content_money">+￥<%=request.getAttribute("daygetnum") %></span>
				<br>
			</li>
			<li class="content_li">
				<span class="content_title">本月</span>
				<span class="content_money">+￥<%=request.getAttribute("monthgetnum") %></span>
				<br>
			</li>
			<li class="content_li">
				<span class="content_title">本年</span>
				<span class="content_money">+￥<%=request.getAttribute("yeargetnum") %></span>
				<br>
			</li>
		</ul>
	</div>
	<button type="button"  id="addMsg"><a href="income_Msg.jsp">+</a></button>
	
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
</body>
	<script type="text/javascript">
		$(function(){
			var user = null;
			$.post("http://localhost:8089/rem_Money/UserServlet.do?method=showuser","",function(data){
					user = data;
			});
			$("#shouru").click(function(){
				if(user==null){
					alert("你还未登录请先登录");
				}else{
				}
			});
		})
	</script>
</html>