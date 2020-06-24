<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/loginStyle.css">
	<title>Login Result</title>
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
			<div class="title">Interface Robot login！</div>
			<% if(loginUser != null){ %>
				<p class="login">ログインに成功しました！</p>
				<p class="login">ようこそ<%= loginUser.getName() %>さん</p>
				<a href="/InterfaceRobot/Main" class="b_button">コマンド入力へ</a>
				<br><a href="/InterfaceRobot/Logout" class="b_button">Logout!</a>
			<% }else{ %>
				<p class="login">ログインに失敗しました！</p>
				<a href="/InterfaceRobot/" class="b_button">TOPへ</a>
			<% } %>
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