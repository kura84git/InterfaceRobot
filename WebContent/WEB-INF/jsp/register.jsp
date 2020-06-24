<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/loginStyle.css">
	<title>Interface Robot</title>
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
			<div class="title">新規登録</div>
			<% if(errorMsg != null) { %>
				<p><%= errorMsg %></p>
			<% } %>
			<form action="/InterfaceRobot/Register" method="post" name="form" onSubmit="return checkRegister()">
			<table>
				<tr><td>userID</td><td><input type="text" name="userID" pattern="^[a-zA-Z0-9]{6}$"
				title="userIDは必ず6文字、半角英数字で入力してください。" class="form"></td></tr>
				<tr><td>Password　</td><td><input type="password" name= "pass" class="form"></td></tr>
				<tr><td>name</td><td><input type="text" name="name" class="form"></td></tr>
				<tr><td>mail</td><td><input type="email" name="mail" class="form"></td></tr>
				<tr><td>Bot name　</td><td><input type="text" name="botName" class="form"></td></tr>
				<tr><td><input type="submit" value="Regiter!"></td><td><input type="reset" value="reset!"></td></tr>
			</table>
			</form>
			<br><a href="/InterfaceRobot/">Return TOP!</a>
			<script type="text/javascript" src="js/formCheck.js"></script>
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