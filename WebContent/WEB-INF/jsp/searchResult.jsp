<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%
User friend = (User)session.getAttribute("friend");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/myPageStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<title>Search Result</title>
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
			<div class="searchResult">
				検索結果<br>
				<% if(friend != null) {%>
					<%= friend.getName() %>さんをフレンドに登録しますか？<br><br>
					<a href="/InterfaceRobot/FriendSearch?action=done">YES</a>　<a href="/InterfaceRobot/FriendSearch">NO</a>
				<% } else{ %>
					合致するユーザーが見つかりませんでした。
				<% } %>
				<br><br><a href="/InterfaceRobot/FriendSearch">フレンド検索へ戻る</a><br>
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