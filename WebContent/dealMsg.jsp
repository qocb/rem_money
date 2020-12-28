<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/mui.min.css"/>
		<style type="text/css">
			#MSG{
				position: relative;
				padding: 2.25rem 3rem 0 1.25rem;
				width: 95%;
				height: 31.25rem;
				margin: 1.75rem auto;
				background-color: #FFFFFF;
				border-radius: 0.9375rem;
				font-size: 1.875rem;
			}
			.time{
				font-size: 2.8125rem;
			}
			h2{
				display: inline-block;
				font-size: 5rem;
			}
			.type{
				font-size: 2.5rem;
				float: right;
				display: block;
			}
			#money{
				font-size: 2.8125rem;
				color: red;
			}
			.time{
				display: inline-block;
				margin-top: 3.25rem;
				color: ;
			}
			#delete{
				position: absolute;
				bottom: 2.25rem;
				right: 1.875rem;
				font-size: 2.8125rem;
			}
			.kind{
				font-size: 2.8125rem;
			}
			#eidit{
				position: absolute;
				bottom: 2.25rem;
				left: 1.875rem;
				font-size: 2.8125rem;
			}
			#mark{
				margin-top: 2.25rem;
				font-size: 1.875rem;
				line-height: 2.875rem;
			}
		</style>
	</head>
	
	<body>
		<div id="MSG">
		<%Map outmsg =(Map)request.getAttribute("outmsg"); %>
			<h2><%= outmsg.get("out_name")%></h5>
			<br>
			<i class="time"><%= outmsg.get("out_date")%></i>
			<i class="kind">支出：</i>
			<span id="money">
				-￥<%= outmsg.get("out_money")%>
			</span>
			<p id="mark"><%= outmsg.get("out_name")%></p>
			<a href="<%=request.getContextPath()%>/dealmsg.do?method=delete&out_id=<%=outmsg.get("out_id") %>" id="delete">删除此记录</a>
			<a href="" id="eidit">修改记录</a>
		</div>
	</body>
</html>
