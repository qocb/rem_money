<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>


	<head>
		<meta charset="utf-8">
		<title>预算</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/budget.css"/>
		<style type="text/css">
			.budgets li{
				background-color: #FFFFFF;
				font-size: 1.25rem;
				height: 5.875rem;
				width: 100%;
				border-bottom: 0.0625rem solid #CCCCCC;
				padding-left: 1.25rem;
			}
			.budgets_name{
				display: inline-block;
				margin-top: 0.8rem;
			}
			.budgets_remain{
				display: inline-block;
				margin: 5px 0;
				font-size: 0.85rem;
				color: #CF2D28;
			}
			.budgets_zhichu{
				font-size: 0.85rem;
				color: #AAAAAA;
			}
			.remove_budget{
				float: right;
				margin-right: 1.25rem;
				font-size: 1rem;
			}
		</style>
	</head> 

	<body>
		<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
			mui.init()
		</script>
		<form class="mui-input-group" id="form_budget" class="budget_form" method="post" action="<%=request.getContextPath()%>/BudgetServlet.do?method=savebudget" $()>
			<div id="box">
				<div id="yusuan">
					<input type="text" name="budget_name" id="budget_name"  value="" placeholder="预算名字"/>
					<input type="number" class="budget_money" id="budget_money" name="budget_money"  value="" placeholder="预算金额"/>
				
				</div>
				
				<input type="submit" name="" id="submit" value="保存" />
			</div>
		</form>
		<ul class="budgets">
			<%
			 List userbudget_list = (List)request.getAttribute("userbudget_list");
			
			for(int i = 0;i<userbudget_list.size();i++){
				 Map userbudget_map = (Map)userbudget_list.get(i);
			%>
			<li>
				<span class="budgets_name" ><%= userbudget_map.get("budget_name")%></span>
				<br>
				<span class="budgets_remain">剩余金额:￥<%= userbudget_map.get("budget_remain")%></span>
				<br>
				<span class="budgets_zhichu">支出￥<%= userbudget_map.get("budget_out")%></span>
				<a href="/rem_Money/BudgetServlet.do?method=remove&budget_id=<%= userbudget_map.get("budget_id")%>" class="remove_budget">删除此预算</a>
			</li>
			<%} %>
		</ul>
		
		<script type="text/javascript">
			
		 $.ajax({
			  	url : "http://127.0.0.1/admin/list/",	
	            //请求方式
	            type : "POST",
	            //请求的媒体类型
	            contentType: "application/json;charset=UTF-8",
	            data : {
	            	
	            },
	            //请求成功
	            success : function(result) {
	                console.log(result);
	            },
	            //请求失败，包含具体的错误信息
	            error : function(e){
	                console.log(e.status);
	                console.log(e.responseText);
	            }
	        });
		
		
			$(function(){
				var user = null;
				$.post("http://localhost:8089/rem_Money/UserServlet.do?method=showuser","",function(data){
					user = data;
				});
				console.log(user)
				var budget_money = $("#budget_money");
				var budget_name = $("#budget_name");
				$("#form_budget").submit(function(){
					if(user==null){
					alert("你还未登录请先登录")
					}else{
						var user_uname = user.user_uname;
						$.post("http://localhost:8089/rem_Money/BudgetServlet.do?method=savebudget",{"budget_money":budget_money,"budget_name":budget_name,"user_uname":user_uname},function(data){
					if(data==null){
						
					}else{
							
							var budget_name = data.budget_name;
							var budget_money = data.budget_money;
							console.log(budget_name)
							console.log(budget_money);
					}
				})
					}
					
					return false;
					})
				})
				
		</script>
	</body>

</html>
