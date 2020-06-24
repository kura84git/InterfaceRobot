<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
	<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/userUpdateStyle.css">
<title>Interface Robot UserUpdate</title>
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
		<div class="titleBox"><div class="title">アカウント情報変更</div></div>
		<div class="main">
			<div class="errorMsg">
			<% if(errorMsg != null) { %>
				<%= errorMsg %>
			<% } %>
			</div>
		 	<form action="/InterfaceRobot/UserUpdate" method="post" name="form" onSubmit="return checkRegister()">
			<table class="table">
				<tr><td>userID</td><td><input type="text" name="userID" value="<%= loginUser.getID() %>"
				pattern="^[a-zA-Z0-9]{6}$" title="userIDは必ず6文字、半角英数字で入力してください。"></td></tr>
				<tr><td>Password　</td><td><input type="password" name= "pass" value="<%= loginUser.getPass() %>"></td></tr>
				<tr><td>name</td><td><input type="text" name="name" value="<%= loginUser.getName() %>"></td></tr>
				<tr><td>mail</td><td><input type="email" name="mail" value="<%= loginUser.getMail() %>"></td></tr>
				<tr><td>Bot name　</td><td><input type="text" name="botName" value="<%= loginUser.getBotName() %>"></td></tr>
				<tr><td><input type="submit" value="Regiter!" id="button"></td><td><input type="reset" value="reset!" id="button"></td></tr>
			</table>
			</form>
		</div>
		<div class="link"><a href="/InterfaceRobot/MyPage">マイページへ戻る</a></div>
		<script type="text/javascript" src="js/formCheck.js"></script>
		<div class="footer">
				<footer><jsp:include page="/footer.jsp" /></footer>
		</div>
	</div>
</body>
</html>