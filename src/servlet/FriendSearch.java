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
import model.AddFriendBO;
import model.FriendMatchBO;
import model.FriendSearchBO;
@WebServlet("/FriendSearch")
public class FriendSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String action = request.getParameter("action");
		if(action == null) {
			path = "/WEB-INF/jsp/friendSearch.jsp";
		}else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User friend = (User)session.getAttribute("friend");
			User loginUser = (User)session.getAttribute("loginUser");
			FriendMatchBO friendMatch = new FriendMatchBO();
			List<Integer> matchID = friendMatch.execute(loginUser, friend);
			if(matchID.get(0) == 0 || matchID.get(1) == 0) {
				if(loginUser.getID().equals(friend.getID())) {
					request.setAttribute("errorMsg", "自身をフレンドには登録できません...");
				}else {
					AddFriendBO addFriend = new AddFriendBO();
					boolean isResult = addFriend.execute(friend, loginUser);
					if(isResult == false) {
						request.setAttribute("errorMsg", "登録に失敗しました...");
					}
				}
			}else {
				request.setAttribute("errorMsg", "すでに登録されたユーザーです...");
			}
			path = "/WEB-INF/jsp/addResult.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String friendID = request.getParameter("friendID");
		String friendBotName = request.getParameter("friendBotName");
		FriendSearchBO search = new FriendSearchBO();
		User friend = search.execute(friendID, friendBotName);
		if(friend != null) {
			HttpSession session = request.getSession();
			session.setAttribute("friend", friend);
		}
		String path = "/WEB-INF/jsp/searchResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
