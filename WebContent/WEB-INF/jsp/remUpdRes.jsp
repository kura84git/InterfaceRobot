<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% boolean remRes = (boolean)request.getAttribute("remRes"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
<title>InterfaceRobot Reminder Update Result</title>
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
			<div class="remUpdRes-main-cover">
				<div class="remUpdRes-mainBox">
					<% if(remRes) { %>
						<p class="word">更新が完了しました！！</p>
					<% } else { %>
						<p class="word">更新に失敗しました・・・</p>
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