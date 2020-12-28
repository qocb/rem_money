<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title>注册</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="./css/registered.css"/>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<script src="js/mui.js" type="text/javascript" charset="utf-8"></script>
		<form class="mui-input-group test_user" id="registered" method="post">
			<div class="mui-input-row " id="user">
				<label><img src="./img/用户名.png" ></label>
				<input type="text" class="mui-input-clear email_input" placeholder="请输入邮箱" id="email" name="user_email">
				<div id="test_user"></div>
			</div>
			<div class="mui-input-row " id="password">
				<label><img src="./img/用户名.png" ></label>
				<input type="text" class="mui-input-clear user_input" placeholder="请输入用户名" id="username" name="user_uname">
				<div id="test_user"></div>
			</div>
			
			<div class="mui-input-row" id="password2">
				<label><img src="./img/密码.png" ></label>
				<input type="password" class="mui-input-password pass_input" placeholder="请输入密码" id="ipassword" name="user_password">
			</div>
			<div class="mui-button-row" id="registered_button">
				<input type="submit" name="submit" id="registered_submit" value="注册" />
			</div>

		</form>
	</body>
<script type="text/javascript">
		
	$(function(){
		//表单提交
		$("#registered").submit(function () {
		   if(checkEmail() && checkUsername() && checkPassword()){
			   $.post("http://localhost:8089/rem_Money/UserServlet.do?method=regist",$(this).serialize(),function(data){
					location.href="sendEmail.jsp";
					if(data.flag){
						
					}else {
						
					}
			   })
		   }
		   return false;
		});
		//检验邮箱
		function checkEmail() {
			var value = $("#email").val();
			var reg_email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			var flag = reg_email.test(value);
			if(flag){
				
			}else{
				alert("邮箱格式有误请输入正确邮箱");
			}
			return flag;
		}
		//检测账号
		function checkUsername() {
			var value = $("#username").val();
			var reg_username = /^\w{6,16}$/;
			var flag = reg_username.test(value);
			if(flag){
				
			}else{
				alert("用户名格式有误请输入6-16位数的密码");
			}
			return flag;
		}
		//检测密码
		function checkPassword(){
			var value = $("#ipassword").val();
			var reg_password = /^\w{6,16}$/;
			var flag = reg_password.test(value);
			if(flag){
				
			}else{
				alert("密码格式有误请输入6-16位数的密码");
			}
			return flag;
		}
	})
</script>

</html>
