<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/loginStyle.css">
	<title>Interface Robot Logout!</title>
</head>
<body>
<div class="bgImageIndex">
	<div class="topBox">
		<div class="top-cover">
			<div class="left-top">
				<img src="images/robot.jpg" class="robot">
			</div>
			<div class="topContent">
				<header>
					<jsp:include page="/header.jsp" />
				</header>
			</div>
			<div class="right-top">
				<img src="images/robot2.jpg" class="robot2">
			</div>
		</div>
	</div>
	<div class="mainBox">
		<div class="mainContent">
			<div class="title">Interface Robot Logout</div>
			<p>ログアウトしました！</p>
			<a href="/InterfaceRobot/">トップへ</a>
		</div>
	</div>
	<div class="bottomBox">
		<footer>
			<jsp:include page="/footer.jsp" />
		</footer>
	</div>
</div>
</body>
</html>