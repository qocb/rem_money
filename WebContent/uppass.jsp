<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/mui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/uppass.css"/>
	</head>

	<body>
		<script src="js/mui.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>
		
		<form class="mui-input-group test_user" id="registered" action="<%=request.getContextPath() %>/UserServlet.do?method=changePassword" method="post">
			<div class="mui-input-row " id="user">
				<input type="text" class="mui-input-clear"  placeholder="请输入旧密码" name="old_pass"  id="user_input" >
				<div id="test_user"></div>
			</div>
			<div class="mui-input-row" id="password">
				<input type="password" class="mui-input-password" placeholder="请输入新密码" name="new_pass"  id="pass_input">
			</div>
			<div class="mui-button-row" id="registered_button">
				<input type="submit" name="" id="registered_submit" value="修 改" />
			</div>
		</form>
		
	</body>

</html>
