<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.ComResPath" %>
<%
ComResPath comres = (ComResPath)session.getAttribute("comres");
String msg = (String)request.getAttribute("errorMsg");
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
			<div class="title">この内容でよろしいですか？</div>
			<table>
			<% if(comres.getPath().equals("path")) { %>
				<tr><td>ファイルパス　　</td><td><div  class="form"></div>nonePath</td></tr>
			<% }else{ %>
				<tr><td>ファイルパス　　</td><td><div  class="form"><%= comres.getPath() %></div></td></tr>
			<% } %>
				<tr><td>new Command</td><td><div  class="form"><%= comres.getCom() %></div></td></tr>
				<tr><td>new response</td><td><div  class="form"><%= comres.getRes() %></div></td></tr>
			</table>
			<div class="boxA">
				<div class="boxB"><a href="/InterfaceRobot/AddCommand?action=done">　YES　　</a>
				</div><div class="boxB"><a href="/InterfaceRobot/AddCommand">　　NO　</a></div>
			</div>
		<% } %>
		</div>
	</div>
	<script type="text/javascript" src="js/formCheck.js"></script>
	<div class="bottomBox"><footer><jsp:include page="/footer.jsp" /></footer></div>
</div>
</body>
</html>