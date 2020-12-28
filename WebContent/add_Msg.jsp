<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/add_Msg.css"/>
		<script src="js/mui.js"></script>
		<script src="./js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/datePicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="./js/add_Msg.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			mui.init()
		</script>
		<style type="text/css">
			.selected{
				background-color: #CCCCCC;
				height: 2.7rem;
			}
			#budget_select{
				width: 100%;
				font-size: 1.25rem;
				color: #777777;
			}
			.budget_content{
				padding: 0.625rem 0 0.625rem 1.25rem;
			}
			#budget_name{
				font-size: 1.5rem;
				margin: 1.25rem 0 1.25rem 1.25rem;
				display: block;
			}
			.budget_remain{
				font-size: 1.125rem;
				color: red;
				display: block;
				margin: 1.25rem 0 1.25rem 1.25rem;
			}
			
		</style>
	</head>

	<body>
		<header id="header">
			<a href="<%=request.getContextPath()%>/index.do?method=queryouts" id="back" class="mui-icon mui-icon-back"></a>
			<span id="title">
				添加交易
			</span>
			<div id="roatte">
				<span id="outmoney" class="current">支出</span>
				<a class="a1" href="income_Msg.jsp"><span id="getmoney">收入</span></a>
			</div>
		</header>
		
		<div id="content">
			<form action="<%=request.getContextPath() %>/OutsServlet.do?method=add" id="out_form" method="post">
				<div id="content_input">
						<i id="ico_money">-￥</i><input type="number" name="money" id="input_money" value="" placeholder="支出金额"/>
					</div>
					<span class="small_title">
						分类
					</span>
					<ul id="types">
						<li>
							<div class="type_ico ico_car">
							</div>
							<span class="type_name">
								交通
							</span>
						</li>
						<li>
							<div class="type_ico ico_yiliao">
							</div>
							<span class="type_name">
								医疗
							</span>
						</li>
						<li>
							<div class="type_ico ico_eat">
							</div>
							<span class="type_name">
								餐饮
							</span>
						</li>
						<li>
							<div class="type_ico ico_office">
							</div>
							<span class="type_name">
								办公
							</span>
						</li>
						<li>
							<div class="type_ico ico_room">
							</div>
							<span class="type_name">
								住房
							</span>
						</li>
						<li>
							<div class="type_ico ico_happy">
							</div>
							<span class="type_name">
								娱乐
							</span>
						</li>
						<li>
							<div class="type_ico ico_activity">
							</div>
							<span class="type_name">
								活动
							</span>
						</li>
						<li>
							<div class="type_ico ico_gift">
							</div>
							<span class="type_name">
								礼物
							</span>
						</li>
						<li>
							<div class="type_ico ico_TZ">
							</div>
							<span class="type_name">
								投资
							</span>
						</li>
						<li>
							<div class="type_ico ico_daily">
							</div>
							<span class="type_name">
								日常
							</span>
						</li>
					</ul>
				
				<div id="time">
					<input id="demo1" name="time" placeholder="选择时间"> 
				</div>
				<div id="beizhu">
					<input type="text" name="type" id="mark" value="" placeholder="类别"/>
					<input type="text" name="mark" id="mark1" value="" placeholder="备注"/>
				</div>
				<div class="selected">
					<select id="budget_select" name="budget_id">
						<option value ="">未选择预算</option>
					</select>
				</div>
				<div id="budget_content" style="display: none;">
					<span id="budget_name"></span>
					<span class="budget_remain">预算剩余：￥<i id="budget_remainmoney">123</i></span>
					
				</div>
				<br>
				<br>
				<input type="submit" name="" id="submit" value="保存" />
			</form>
			
		</div>
		
	</body>
<script>
	var calendar = new datePicker();
calendar.init({
	'trigger': '#demo1', /*按钮选择器，用于触发弹出插件*/
	'type': 'date',/*模式：date日期；datetime日期时间；time时间；ym年月；*/
	'minDate':'1900-1-1',/*最小日期*/
	'maxDate':'2100-12-31',/*最大日期*/
	'onSubmit':function(){/*确认时触发事件*/
		var theSelectData=calendar.value;
	},
	'onClose':function(){/*取消时触发事件*/
	}
});
	</script>
	<script type="text/javascript">
		
		$(function(){
				var budget = null;
				$.ajax({
				//请求方式
				type : "GET",
				//请求的媒体类型
				contentType: "application/json;charset=UTF-8",
				//请求地址
				url : "http://localhost:8089/rem_Money/BudgetServlet.do?method=getallbudgetname",
				//数据，json字符串
				data : "",
				//请求成功
				success : function(data) {
					budget = data;
					console.log(data);
					var budget_select = $("#budget_select");
					for(key in data){
							budget_select.append("<option value='"+data[key].budget_id+"'>"+data[key].budget_name+"</option>");
					}
					
				},
				//请求失败，包含具体的错误信息
				error : function(e){
					console.log(e.status);
					console.log(e.responseText);
				}
			});
				$("#budget_select").change(function(){
					 var budgetid = $(this).val();
					 console.log(budget)
					for(key in budget){
						if( budget[key].budget_id == budgetid ){
							$("#budget_content").css({"display":"block"});
							$("#budget_name").html(budget[key].budget_name);
							$("#budget_remainmoney").html(budget[key].budget_remain)
						}
					}
				})
				$("#out_form").submit(function () {
					if($("#demo1").val() == "" ){
						alert("您还未输入时间");
						return false;
					}
					if($("#input_money").val() == ""){
						alert("你还未输入金钱");
						return false;
					}
					if($("#mark").val() == ""){
						alert("你还未选择类型");
						return false;
					}
				});
				
				
		})
	
		
	</script>
</html>
