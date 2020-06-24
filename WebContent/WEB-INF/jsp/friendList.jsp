<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
List<User> friendList = (List<User>)request.getAttribute("friendList");
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
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/friendStyle.css">
<title>Friend List Page</title>
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
			<div class="friendListBox">
				<div class="friendList">
					<% if(msg != null){ %>
						<%= msg %>
					<% } else { %>
						<table class="table">
						<% for(User friend : friendList){ %>
							<form action="/InterfaceRobot/FriendList" method="post" name="form" onSubmit="return check()">
								<input type="hidden" name="friendID" value="<%= friend.getID() %>">
								<input type="hidden" name="friendBotName" value="<%= friend.getBotName() %>">
									<tr><td><%= friend.getName() %></td><td>　<input type="submit" value="チャットを始める！"  class="submit"></td></tr>
							</form>
						<% } %>
						</table>
					<% } %>
				</div>
				<div class="boxC">
					<div class="boxD">
						<div class="iconBox"><img src="images/iconUturn.jpeg" class="icon"></div>
						<a href="/InterfaceRobot/MyPage">MyPageへ</a>
					</div>
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