package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Remind;
import model.RemDltBO;
import model.RemSelcBO;


@WebServlet("/RemDlt")
public class RemDlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションスコープから削除リマインド情報を取得
		Remind remDlt = (Remind) session.getAttribute("remDlt");
		//リマインド削除処理
		RemDltBO bo = new RemDltBO();
		boolean remRes = bo.execute(remDlt);
		//リクエストスコープに実行結果格納
		request.setAttribute("remRes", remRes);
		//remDltRes.jspへフォワード
		String path = "/WEB-INF/jsp/remDltRes.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取得
		int remindID = Integer.parseInt(request.getParameter("remindID"));
		String userID = request.getParameter("userID");
		Remind ID = new Remind(remindID, userID);
		RemSelcBO bo = new RemSelcBO();
		Remind remDlt = bo.execute(ID);
		HttpSession session = request.getSession();
		//セッションスコープに現在のリマインド情報を格納
		session.setAttribute("remDlt", remDlt);
		//remDltConfirm.jspへフォワード
		String path = "/WEB-INF/jsp/remDltConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
