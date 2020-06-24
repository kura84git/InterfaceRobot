<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%
User user = (User)session.getAttribute("user");
User account = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/loginStyle.css">
	<title>registerConfirm</title>
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
			<div class="title">この内容で登録しますか？</div>
			<table class="table">
				<tr><td>userID</td><td><div class="userInfo"><%= user.getID() %></div></td></tr>
				<tr><td>pass</td><td><div class="userInfo"><%= user.getPass() %></div></td></tr>
				<tr><td>name</td><td><div class="userInfo"><%= user.getName() %></div></td></tr>
				<tr><td>mail</td><td><div class="userInfo"><%= user.getMail() %></div></td></tr>
				<tr><td>RobotName　</td><td><div class="userInfo"><%= user.getBotName() %></div></td></tr>
			</table>
			<% if(account != null){ %>
				<a href="/InterfaceRobot/UserUpdate">return!</a>　
				<a href="/InterfaceRobot/UserUpdate?action=done">Register!</a>
			<% }else{ %>
				<a href="/InterfaceRobot/Register">return!</a><br>
				<a href="/InterfaceRobot/Register?action=done">Register!</a>
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