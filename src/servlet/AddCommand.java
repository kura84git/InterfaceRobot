package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ComResPath;
import beans.User;
import model.ComResBO;
@WebServlet("/AddCommand")
public class AddCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = null;
		if(action == null) {
			path = "/WEB-INF/jsp/makeCom.jsp";
		}else if(action.equals("done")) {
			HttpSession session = request.getSession();
			ComResPath comres = (ComResPath)session.getAttribute("comres");
			User loginUser = (User)session.getAttribute("loginUser");
			ComResBO comRes = new ComResBO();
			String errorMsg = comRes.execute(loginUser, comres);
			request.setAttribute("errorMsg", errorMsg);
			path = "/WEB-INF/jsp/makeResult.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String execPath = request.getParameter("execFile");
		String newCom = request.getParameter("newCom");
		String newRes = request.getParameter("newRes");
		if(execPath.equals("")) { //実行ファイルなしの場合、コマンドとレスポンスのみをテーブルに格納する
			ComResPath comres = new ComResPath(newCom, newRes, "path");
			session.setAttribute("comres", comres);
		}else { //実行ファイルありの場合、指定された実行ファイルのパスを取得しにいく
			//SearchPathBO search = new SearchPathBO();
			//String path = search.execute(execFile);
			//if(path.length() != 0) {
				ComResPath comres = new ComResPath(newCom, newRes, execPath);
				session.setAttribute("comres", comres);
			//}else { request.setAttribute("errorMsg", "指定されたファイルが見つかりませんでした"); }
		}
		String path = "/WEB-INF/jsp/makeConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
