package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import model.FriendSearchBO;
import model.GetFriendListBO;
@WebServlet("/FriendList")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		GetFriendListBO getFriends = new GetFriendListBO();
		List<User> friendList = getFriends.execute(loginUser);
		if(!(friendList.isEmpty())) {
			request.setAttribute("friendList", friendList);
		} else { request.setAttribute("errorMsg", "まだフレンドが登録されていません"); }
		String path = "/WEB-INF/jsp/friendList.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String friendID = request.getParameter("friendID");
		String friendBotName = request.getParameter("friendBotName");
		FriendSearchBO search = new FriendSearchBO();
		User friend = search.execute(friendID, friendBotName);
		HttpSession session = request.getSession();
		session.setAttribute("friend", friend);
		String path = "/FriendChat";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
