<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Remind" %>
<%@ page import="java.util.List" %>
<%
List<Remind> remindList = (List<Remind>)session.getAttribute("remindList");
String msg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reminderStyle.css">
	<title>InterfaceRobot Reminder</title>
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
							<div class="return"><a href="/InterfaceRobot/Main?action=done" class="link">コマンド入力へ戻る</a></div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-cover">
				<div class="form">
					<form action="/InterfaceRobot/Reminder" method="post" name="form" onSubmit="return checkReminder()">
							リマインド内容：<input type="text" name="remind" size="32">
							カテゴリ：<input type="text" name="category">
							<input type="submit" value="リマインド内容を保存する！" id="button">
					</form>
					<input type="button" onClick="location.href='/InterfaceRobot/RemSort'" value="カテゴリソート検索" id="button">
				</div>
			</div>
			<div class="remind-cover">
				<div class="remindBox">
					<% for(Remind remind : remindList) { %>
						<% if(msg != null){ %>
							<%= msg %><br>
							<p><a href="/InterfaceRobot/Reminder">更新</a>してください</p>
						<% }else{ %>
							<div class="remind-flex">
								<div class="remind"><%= remind.getRemind() %></div>
								<div class="anotherBox">
									<div class="category"><%= remind.getCategory() %></div>
									<div class="buttonBox">
										<div class="button">
											<form action="/InterfaceRobot/RemUpd" method="post">
												<input type="hidden" name="remindID" value="<%= remind.getID() %>">
												<input type="hidden" name="userID" value="<%= remind.getUserID() %>">
												<input type="submit" value="編集" id="button">
											</form>
										</div>
										<div class="button">
											<form action="/InterfaceRobot/RemDlt" method="post">
												<input type="hidden" name="remindID" value="<%= remind.getID() %>">
												<input type="hidden" name="userID" value="<%= remind.getUserID() %>">
												<input type="submit" value="削除" id="button">
											</form>
										</div>
									</div>
								</div>
							</div>
						<% } %>
					<% } %>
				</div>
			</div>
			<script type="text/javascript" src="js/formCheck.js"></script>
		</div>
		<div class="footer">
			<footer><jsp:include page="/footer.jsp" /></footer>
		</div>
	</div>
</body>
</html>