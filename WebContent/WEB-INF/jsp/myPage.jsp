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
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/myPageStyle.css">
<title>My Page</title>
</head>
<body>
<div class="wrapper">
	<div class="topBox">
		<div class="top-cover">
			<div class="left-top"><img src="images/robot.jpg" class="robot"></div>
			<div class="topContent">
				<header><jsp:include page="/header.jsp" /></header>
			</div>
			<div class="right-top"><img src="images/robot2.jpg" class="robot2"></div>
		</div>
	</div>
	<div class="mainBox">
		<div class="mainContent">
			<div class="myInfo">
				<%= loginUser.getName() %>さん<br><br>
				<table class="table">
					<tr><td>ID</td><td>　<%= loginUser.getID() %></td></tr>
					<tr><td>pass</td> <td>　<%= loginUser.getPass() %></td></tr>
					<tr><td>name</td><td>　<%= loginUser.getName() %></td></tr>
					<tr><td>mail</td><td>　<%= loginUser.getMail() %></td></tr>
					<tr><td>BotName</td><td>　<%= loginUser.getBotName() %></td></tr>
				</table><br>
				<div><a href="/InterfaceRobot/UserUpdate">アカウント情報を変更する</a></div>
				<div class="boxA">
					<div class="iconBox"><img src="images/iconFriendSearch.jpeg" class="icon"></div>
					<a href="/InterfaceRobot/FriendSearch">フレンドを検索する</a>
				</div>
				<div class="boxB">
					<div class="iconBox"><img src="images/iconTeam.jpeg" class="icon"></div>
					<a href="/InterfaceRobot/FriendList">フレンド一覧</a>
				</div>
				<div class="boxC">
					<div class="iconBox"><img src="images/iconUturn.jpeg" class="icon"></div>
					<a href="/InterfaceRobot/Main">command入力へ戻る</a>
				</div>
			</div>
		</div>
	</div>
	<div class="bottomBox">
		<footer><jsp:include page="/footer.jsp" /></footer>
	</div>
</div>
</body>
</html>