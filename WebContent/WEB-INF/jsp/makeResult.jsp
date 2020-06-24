<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/makeComStyle.css">
<title>Insert title here</title>
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
		<% if(msg != null){ %>
			<div class="title"><%= msg %></div>
		<% } else{ %>
			<div class="title">登録が完了しました</div>
		<% } %>
			<div class="boxC">
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