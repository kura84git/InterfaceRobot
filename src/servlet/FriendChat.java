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

import beans.Chat;
import beans.User;
import model.FriendMatchBO;
import model.GetFriendChatBO;
import model.PostChatBO;
@WebServlet("/FriendChat")
public class FriendChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User friend = (User)session.getAttribute("friend");
		User loginUser = (User)session.getAttribute("loginUser");
		FriendMatchBO friendMatch = new FriendMatchBO();
		List<Integer> matchID = friendMatch.execute(loginUser, friend);
		GetFriendChatBO getChat = new GetFriendChatBO();
		List<Chat> chatList = getChat.execute(matchID);
		request.setAttribute("chatList", chatList);
		String path = "/WEB-INF/jsp/friendChat.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		User friend = (User)session.getAttribute("friend");
		User loginUser = (User)session.getAttribute("loginUser");
		String userID = loginUser.getID();
		FriendMatchBO friendMatch = new FriendMatchBO();
		List<Integer> matchID = friendMatch.execute(loginUser, friend);;
		String chat = request.getParameter("chat");
		if(action ==null) { //FriendList.javaのdoPostから
			GetFriendChatBO getChat = new GetFriendChatBO();
			List<Chat> chatList = getChat.execute(matchID);
			request.setAttribute("chatList", chatList);
		} else if(action.equals("done")) {
			if(chat != null) {
				Chat c = new Chat(userID, matchID.get(0), chat);
				PostChatBO postChat = new PostChatBO();
				boolean isPost = postChat.execute(c);
				if(isPost) {
					GetFriendChatBO getChat = new GetFriendChatBO();
					List<Chat> chatList = getChat.execute(matchID);
					request.setAttribute("chatList", chatList);
				}else {
					request.setAttribute("errorMsg", "送信に失敗しました");
				}
			} else {
				request.setAttribute("errorMsg", "何か入力して下さい");
			}
		}
		String path = "/WEB-INF/jsp/friendChat.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
