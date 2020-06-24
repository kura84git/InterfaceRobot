<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/myPageStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<title>Friend Search</title>
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
			<div class="searchBox">
				<h3>フレンド検索をしよう！</h3>
				<p>友達からユーザIDとロボットの名前を<br>教えてもらいましょう！</p><br>
				<form action="/InterfaceRobot/FriendSearch" method="post" name="form" onSubmit="return check()">
				<table>
					<tr><td>Friend UserID　</td><td><input type="text" name="friendID" class="input"></td></tr>
					<tr><td>ROBOT NAME　</td><td><input type="text" name="friendBotName" class="input"></td></tr>
					<tr><td><input type="submit" value="検索" class="submit"></td><td></td></tr>
				</table>
				</form><br>
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