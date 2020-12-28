<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title>登陆</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="./css/login.css"/>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.regist{
				text-align: center;
				color: #000000;
				margin-top: 1.875rem;
			}
		</style>
	</head>

	<body>
		<script src="js/mui.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>
		<form class="mui-input-group" id="login" method="post">
			<div class="mui-input-row" id="user">
				<label><img src="./img/用户名.png" ></label>
				<input type="text" class="mui-input-clear user_input" placeholder="请输入用户名" value="zhangsan" id="user_name"  name="user_uname" >
			</div>
			<div class="mui-input-row" id="password">
				<label><img src="./img/密码.png" ></label>
				<input type="password" class="mui-input-password pass_input" id="userpass" value="123456" name="user_password" placeholder="请输入密码" >
			</div>
			<div class="mui-button-row" id="login_button">
				<input type="submit" id="login_submit" name="" value="登 陆"/>
			</div>
			<div class="regist">
				<a href="registered.jsp">没有账号点击注册</a>
			</div>
		</form>
		<div id="tb">
			<div id="QQ"><img src="./img/QQ.png" ></div>
			<div id="weixin"><img src="./img/微信.png" ></div>
		</div>
		
		<script type="text/javascript">
			$(function(){
				$("#login").submit(function(){
					//alert($(this).serialize())
					console.log($(this).serialize());
					$.post("http://localhost:8089/rem_Money/UserServlet.do?method=login",$(this).serialize(),function(data){
						if(data.flag==true){
							window.location = "user.jsp";
						}else{
							alert(data.errmsg);
						}
					})
					return false;
				})
			})
		</script>
	</body>

</html>
