<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/income_Msg.css"/>
		<script src="js/mui.js"></script>
		<script src="./js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/datePicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="./js/add_Msg.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			mui.init()
		</script>
	</head>

	<body>
		<header id="header">
			<a href="<%=request.getContextPath()%>/index.do?method=queryouts" id="back" class="mui-icon mui-icon-back"></a>
			<span id="title">
				添加交易
			</span>
			<div id="roatte">
				<a class="a1" href="add_Msg.jsp"><span id="outmoney" class="current">支出</span></a>
				<span id="getmoney" class="current2">收入</span>
			</div>
		</header>
		
		<div id="content">
			<form action="<%=request.getContextPath() %>/GetsServlet.do?method=add" id="get_form" method="post">
				<div id="content_input">
						<i id="ico_money">+￥</i><input type="number" name="money" id="input_money" value="" placeholder="收入金额"/>
					</div>
					<span class="small_title">
						分类
					</span>
					<ul id="types">
						<li>
							<div class="type_ico ico_life">
							</div>
							<span class="type_name">
								生活费
							</span>
						</li>
						<li>
							<div class="type_ico ico_yiliao">
							</div>
							<span class="type_name">
								红包
							</span>
						</li>
						<li>
							<div class="type_ico ico_eat">
							</div>
							<span class="type_name">
								转账
							</span>
						</li>
						<li>
							<div class="type_ico ico_office">
							</div>
							<span class="type_name">
								工资
							</span>
						</li>
						<li>
							<div class="type_ico ico_room">
							</div>
							<span class="type_name">
								奖学金
							</span>
						</li>
						<li>
							<div class="type_ico ico_happy">
							</div>
							<span class="type_name">
								收债
							</span>
						</li>
						<li>
							<div class="type_ico ico_activity">
							</div>
							<span class="type_name">
								经营
							</span>
						</li>
						<li>
							<div class="type_ico ico_gift">
							</div>
							<span class="type_name">
								意外
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
								其他
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
		$(function () {
			$("#get_form").submit(function () {
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
