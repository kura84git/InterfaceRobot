<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Remind" %>
<%
Remind remUpd = (Remind)session.getAttribute("remUpd");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
<title>InterfaceRobot Reminder Update</title>
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
							<div class="return"><a href="/InterfaceRobot/Reminder" class="link">リマインダーアプリトップへ戻る</a></div>
						</div>
					</div>
				</div>
			</div>
			<div class="title-cover">
				<div class="titleBox">
					<div><h2>編集</h2></div>
					<div><h3>編集内容を入力してください</h3></div>
				</div>
			</div>
			<div class="remUpd-main-cover">
				<div class="remUpd-mainBox">
					<form action="/InterfaceRobot/RemUpd?action=done" method="post" name="form" onSubmit="return checkReminder()">
						リマインド：<input type="text" name="remind"  value="<%= remUpd.getRemind() %>">
						カテゴリ：<input type="text" name="category" value="<%= remUpd.getCategory() %>">
						<input type="submit" value="更新！" id="button">
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/formCheck.js"></script>
		<div class="footer">
				<footer><jsp:include page="/footer.jsp" /></footer>
		</div>
	</div>
</body>
</html>