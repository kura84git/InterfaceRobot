<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Remind" %>
<%
Remind remUpd = (Remind)session.getAttribute("remUpd");
String msg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
<title>InterfaceRobot Reminder Update Confirm</title>
</head>
<body>
	<div class="background-image">
		<div class="head-cover">
			<div class="head">
				<div class="left-head"><img src="images/robot.jpg" class="robot"></div>
				<div class="center-head"><header><jsp:include page="/header.jsp" /></header></div>
				<div class="right-head"><img src="images/robot2.jpg" class="robot2"></div>
			</div>
		</div>
		<div class="main-content">
			<div class="title">
				<div class="second-head-cover">
					<div class="second-head">
						<div>To-Do</div>
						<div class="returnBox">
							<% if(msg != null){ %>
								<div class="return"></div>
							<% }else { %>
								<div class="return"><a href="/InterfaceRobot/RemUpd?action=done" class="link">更新する</a></div>
							<% } %>
						</div>
						<div class="returnBox">
			   				<div class="return"><a href="/InterfaceRobot/RemUpd" class="link">戻る</a></div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-cover">
				<div class="form">
					<h2>こちらの内容で更新してもよろしいですか？？</h2>
				</div>
			</div>
			<div class="remUpdConfirm-main-cover">
				<div class="remUpdConfirm-mainBox">
					<% if(msg != null){ %>
						<p style="color:red; font-size:1.5rem;"><%= msg %></p>
					<% }else{ %>
						<p class="word">リマインド：<%= remUpd.getRemind() %></p>
						<p class="word">カテゴリ：<%= remUpd.getCategory() %></p>
					<% } %>
				</div>
			</div>
		</div>
		<div class="footer">
			<footer><jsp:include page="/footer.jsp" /></footer>
		</div>
	</div>
</body>
</html>