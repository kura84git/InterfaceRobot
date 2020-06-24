<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%@ page import="beans.Command" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
//String path = (String)request.getAttribute("path");
String path = (String)session.getAttribute("path");
String msg = (String)request.getAttribute("errorMsg");
List<Command> commandList = (List<Command>)request.getAttribute("commandList");
String botName = loginUser.getBotName();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface Robot Main</title>
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/reset.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/style.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="/InterfaceRobot/css/mainChatStyle.css">

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
	<div class="main">
		<div class="left-contents">
			<div class="robotCoverBox">
			<div class="mainTitleBox">
				<div class="mainTitle">Interface Robot Main</div>
			</div>
			<div class="userInfoBox">
				<div class="userInfo">
					<a href="/InterfaceRobot/MyPage"><%= loginUser.getName() %></a>さん
					<a href="/InterfaceRobot/Logout">ログイン中</a>
				</div>
			</div>
				<div class="robotCover">
					<div class="robotTop"></div>
					<div class="robotMiddle">
					<!--  test block start
						<div class="robotMsg">
							<div class="yesno">
								<a href="/InterfaceRobot/ExternalApp"><img src="images/yes.jpg" class="yesnoImg"></a>
							</div>
							<div class="yesno">
								<a href="/InterfaceRobot/Main?action=done"><img src="images/no.jpg" class="yesnoImg"></a>
							</div>
						</div>
					      test block end -->
					<% if(msg != null){ %>
						<div class="robotMsg"><%= msg %></div>
					<% } %>
					<% if(path != null){ %>
						<div class="robotMsg">
							<div class="yesno">
								<a href="/InterfaceRobot/ExternalApp"><img src="images/yes.jpg" class="yesnoImg"></a>
							</div>
							<div class="yesno">
								<a href="/InterfaceRobot/Main?action=done"><img src="images/no.jpg" class="yesnoImg"></a>
							</div>
						</div>
					<% } %>
					</div>
					<div class="robotBottom">
						<div class="robotName"><%= loginUser.getBotName() %></div>
					</div>
				</div>
			</div>
		</div>
		<div class="right-contents">
			<div class="txBox">
				<div class="formCover">
					<div class="coverA">
						<div class="reload"><a href="/InterfaceRobot/AddCommand">Command追加</a></div>
						<div class="reload"><a href="/InterfaceRobot/Main">更新</a></div>
						<div>
							<form action="/InterfaceRobot/Main" method="post" name="form" onSubmit="return checkMain()">
								<input type="text" name="command" cols="40" class="input">
								<% if(path == null){ %>
									<input type="submit" value="Command">
								<% }else{ %>
									<input type="submit" value="Command" disabled>
								<% } %>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="commandBox">
			<% for(Command command : commandList){ %>
				<div class="cover">
				<% if ( command.getName().equals( botName ) ) {%>
					<div class="rightCover">
						<div class="boxRight"><p class="text"><%= command.getCommand() %><p></div>
					</div>
				<% } else {  %>
					<div class="leftCover">
						<div class="boxLeft"><p class="text"><%= command.getCommand() %><p></div>
					</div>
				<% } %>
				</div>
			<% } %>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/formCheck.js"></script>
	<div class="bottomBox"><footer><jsp:include page="/footer.jsp" /></footer></div>
</div>
</body>
</html>