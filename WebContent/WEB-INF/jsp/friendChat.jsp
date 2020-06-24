<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.util.List" %>
<%@ page import="beans.User" %>
<%@ page import="beans.Chat" %>
<%
User friend = (User)session.getAttribute("friend");
List<Chat> chatList = (List<Chat>)request.getAttribute("chatList");
String msg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/myPageStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainChatStyle.css">
<title>Friend Chat Space</title>
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
			<div class="topTitle">
				<div class="title"><%= friend.getName() %>さんとのChat Space</div>
				<div class="boxA">
					<div class="boxD">
						<div class="iconBox"><img src="images/iconReload.jpeg" class="icon"></div>
						<a href="/InterfaceRobot/FriendChat">更新　　</a>
					</div>
					<div class="boxC">
						<div class="iconBox"><img src="images/iconUturn.jpeg" class="icon"></div>
						<a href="/InterfaceRobot/MyPage">MyPageへ</a>
					</div>
				</div>
				<form action="/InterfaceRobot/FriendChat?action=done" method="post" name="form" onSubmit="return check()">
					<input type="text" name="chat">
					<input type="submit" value="送信">
				</form>
			</div>
			<div class="friendChat">
				<% if(chatList.size() == 0) { %>
					<div class="title">まだ会話したことがありません！<br>会話を始めましょう！</div>
				<% } else { %>
					<% if(msg != null) { %>
						<div class="title"><%= msg %></div>
					<% } %>
					<% for(Chat chat : chatList){ %>
						<div class="cover">
						<% if (! chat.getName().equals(friend.getName()) ){%>
							<div class="rightCover">
								<div class="boxRight"><p class="text"><%= chat.getChat() %><p></div>
							</div>
						<% } else {  %>
							<div class="leftCover">
								<div class="boxLeft"><p class="text"><%= chat.getChat() %><p></div>
							</div>
						<% } %>
						</div>
					<% } %>
				<% } %>
			</div>
		</div>
	</div>
	<div class="bottomBox">
		<footer><jsp:include page="/footer.jsp" /></footer>
	</div>
</div>
</body>
</html>