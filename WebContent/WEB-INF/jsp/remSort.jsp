<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Remind" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%
Set<Remind> categoryList = (Set<Remind>)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
<title>InterfaceRobot Reminder Sort</title>
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
			<div class="form-cover">
				<div class="form">
					<form action="/InterfaceRobot/RemSort" method="post" name="form" onSubmit="return checkReminderSort()">
						ソートしたいカテゴリを入力してください：<input type="text" name="category">
						<input type="submit" value="このカテゴリでソートする！" id="button">
					</form>
					<div class="remSort-category-title-cover">
						<div class="remSort-category-title">カテゴリ一覧</div>
					</div>
				</div>
			</div>
			<div class="remind-cover">
				<div class="remindBox">
					<% for(Remind category : categoryList) { %>
						<p class="remSort-category"><%= category.getCategory() %></p>
					<% } %>
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