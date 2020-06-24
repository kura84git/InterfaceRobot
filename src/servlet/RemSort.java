package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Remind;
import beans.User;
import model.RemSortBO;


@WebServlet("/RemSort")
public class RemSort extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションスコープからログインしているユーザーの情報を取得
		User loginUser = (User)session.getAttribute("loginUser");
		//カテゴリ一覧取得
		RemSortBO bo = new RemSortBO();
		Set<Remind> categoryList = bo.findCategory(loginUser);
		//カテゴリ一覧をリクエストスコープに格納
		request.setAttribute("categoryList", categoryList);
		//remSort.jspへフォワード
		String path = "/WEB-INF/jsp/remSort.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//セッションスコープからログインしているユーザーの情報を取得
		User loginUser = (User)session.getAttribute("loginUser");
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータ取得
		String specifiedCategory = request.getParameter("category");
		//ソート処理
		RemSortBO bo = new RemSortBO();
		List<Remind> remSortList = bo.sort(loginUser, specifiedCategory);
		//ソートした結果をリクエストスコープに格納
		request.setAttribute("remSortList", remSortList);
		//remSortRes.jspへフォワード
		String path = "/WEB-INF/jsp/remSortRes.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
