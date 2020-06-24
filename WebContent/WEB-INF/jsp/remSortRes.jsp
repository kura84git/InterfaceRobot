<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Remind" %>
<%@ page import="java.util.List" %>
<%
List<Remind> remSortList = (List<Remind>)request.getAttribute("remSortList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
<title>InterfaceRobot Reminder Sort Result</title>
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
							<div class="return"><a href="/InterfaceRobot/RemSort" class="link">カテゴリソート検索へ戻る</a></div>
						</div>
						<div class="returnBox">
							<div class="return"><a href="/InterfaceRobot/Reminder" class="link">リマインダーアプリトップへ戻る</a></div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-cover">
				<div class="form">
					<h2>カテゴリソート検索結果</h2>
				</div>
			</div>
			<div class="remind-cover">
				<div class="remindBox">
					<% for(Remind remind : remSortList) { %>
						<p class="remSortRes-remind"><%= remind.getRemind() %></p>
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