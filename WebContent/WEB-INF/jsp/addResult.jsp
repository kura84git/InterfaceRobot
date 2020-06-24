<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%
User friend = (User)session.getAttribute("friend");
String msg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/myPageStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<title>Add Friend Result</title>
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
			<div class="addResult">
				<% if(msg != null){ %>
					<%= msg %><br>
				<% } else{ %>
					<%= friend.getName() %>さんをフレンドに追加しました！<br><br>
					今すぐ<%= friend.getName() %>さんとのチャットを行いますか？<br>
					<a href="/InterfaceRobot/FriendChat">チャットを開始する！</a><br>
				<% } %>
				<br><a href="/InterfaceRobot/FriendSearch">フレンド検索に戻る</a>
				<div class="boxC">
					<div class="iconBox"><img src="images/iconUturn.jpeg" class="icon"></div>
					<a href="/InterfaceRobot/MyPage">MyPageへ</a>
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