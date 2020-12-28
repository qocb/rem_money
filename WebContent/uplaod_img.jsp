<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<style type="text/css">
				#user_img{
					font-size: 2.875rem;
					color: #FFFFFF;
					background-color: #FFFFFF;
				}
				.box{
					width: 3.125rem;
					height: 5rem;
				}
				#submit{
					margin-top: 5.25rem;
					color: #FFF;
					border: none;
					background-color: pink;
					font-size: 3.75rem;
					width: 100%;
					height: 5.875rem;
				}
		  </style>
		  
	</head>
	<body>
			<form action="<%=request.getContextPath()%>/UserServlet.do?method=uploadimg&user_id=${user.user_id}" id="upload_img" method="post" enctype="multipart/form-data" >
				<input type="file" id="user_img" name="user_img">
				<input type="submit" id="submit" value="上传" id="submit"/>
			</form>
	</body>
	<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
	</script>
</html>
