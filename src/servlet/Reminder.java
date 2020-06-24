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

import beans.Remind;
import beans.User;
import model.RemindBO;


@WebServlet("/Reminder")
public class Reminder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションスコープにログインしているユーザーの情報を格納
		User loginUser = (User)session.getAttribute("loginUser");
		//リマインド一覧取得
		RemindBO bo = new RemindBO();
		List<Remind> remindList = bo.select(loginUser);
		//リマインド一覧をセッションスコープに格納
		session.setAttribute("remindList", remindList);
		//reminder.jspへフォワード
		String path = "/WEB-INF/jsp/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションスコープからログインしているユーザーの情報を取得
		User loginUser = (User)session.getAttribute("loginUser");
		String userID = loginUser.getID();
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータ取得
		String remind = request.getParameter("remind");
		String category = request.getParameter("category");
		Remind remindLatest  = new Remind(userID, remind, category);
		//リマインドを登録
		RemindBO bo = new RemindBO();
		boolean isInsert = bo.insert(remindLatest);
		if(!isInsert) {
			request.setAttribute("errorMsg", "ERROR!! *コマンドは255文字以内で入力してください*");
		}
		//リマインド一覧取得
		List<Remind> remindList = bo.select(loginUser);
		//リマインド一覧をセッションスコープに格納
		session.setAttribute("remindList", remindList);
		//reminder.jspへフォワード
		String path = "/WEB-INF/jsp/reminder.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
