<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
	<title>Interface Robot</title>
</head>
<body>
<div class="bgImageIndex">
	<div class="topBox">
		<div class="top-cover">
			<div class="left-top">
				<img src="images/robot.jpg" class="robot">
			</div>
			<div class="topContent">
				<header>
					<jsp:include page="/header.jsp" />
				</header>
			</div>
			<div class="right-top">
				<img src="images/robot2.jpg" class="robot2">
			</div>
		</div>
	</div>
	<div class="mainBox">
		<div class="mainContent">
			<p class="login">ログインしてください</p>
			<form action="/InterfaceRobot/Login" method="post" name="form" onSubmit="return checkIndex()">
			<table>
			<!--
				<tr><td>userID</td><td><input type="text" class="userID" name="userID" pattern="^[a-zA-Z0-9]{6}$" title="userIDは必ず6文字、半角英数字で入力してください。"></td></tr>
			-->
				<tr><td>ID</td><td><input type="text" class="userID" name="userID"
				pattern="^[a-zA-Z0-9]{6}$|[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
				title="IDはuserID(6文字、半角英数字)もしくはメールアドレスで入力してください。"></td></tr>
				<tr><td>Password</td><td><input type="password" class="pass" name= "pass"></td></tr>
				<tr><td><input type="submit" value="Login!"></td><td><input type="reset" value="reset!"></td></tr>
			</table>
			</form>
			<p  class="register"><a href="/InterfaceRobot/Register" class="register">新規登録はこちら</a></p>
			<script type="text/javascript" src="js/formCheck.js"></script>
		</div>
	</div>
	<div class="bottomBox">
		<footer>
			<jsp:include page="/footer.jsp" />
		</footer>
	</div>
</div>
</body>
</html>