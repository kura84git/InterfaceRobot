<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/makeComStyle.css">
<title>make command</title>
</head>
<body>
<div class="wrapper">
	<div class="topMain">
		<div class="top-cover">
			<div class="left-top"><img src="images/robot.jpg" class="robot"></div>
			<div class="topContent"><header><jsp:include page="/header.jsp" /></header></div>
			<div class="right-top"><img src="images/robot2.jpg" class="robot2"></div>
		</div>
	</div>
	<div class="mainBox">
		<div class="mainContent">
			<div class="title">Caution!! こちらは上級者向けコンテンツになります!!</div>
			<form action="/InterfaceRobot/AddCommand" method="post" name="form" onSubmit="return checkRegister()">
			<table class="table">
				<tr><td>実行FilePath(絶対パス)　</td><td><input type="text" name="execFile"  class="form"></td></tr>
				<tr><td>new Command</td><td><input type="text" name= "newCom" class="form"></td></tr>
				<tr><td>new Response</td><td><input type="text" name="newRes" class="form"></td></tr>
				<tr><td><input type="submit" value="Add!"></td><td><input type="reset" value="reset!"></td></tr>
			</table>
			</form><br>
			<div class="boxX">
					<div class="iconBox"><img src="images/iconUturn.jpeg" class="icon"></div>
					<a href="/InterfaceRobot/Main">command入力へ戻る</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/formCheck.js"></script>
	<div class="bottomBox"><footer><jsp:include page="/footer.jsp" /></footer></div>
</div>
</body>
</html>