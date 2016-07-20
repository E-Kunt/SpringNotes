<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户登录与注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>
		用户登录<sup>E-Kunt</sup>
	</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header" style="width: 100%; text-align: center;font-size:xx-large;">
				<span>操作结果</span>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--结果信息-->
			<div class="web_login" id="web_login">
				<br/>
				<br/>
				<br/>
				<div  style="width: 100%; text-align: center;font-size:medium;color: red;">
					抱歉，注册失败！请稍后再试！
				</div>
			</div>
			<!--结果信息end-->
		</div>

	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>