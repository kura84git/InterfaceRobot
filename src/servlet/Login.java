package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import model.LoginBO;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/index.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("userID");
		String pass = request.getParameter("pass");
		//Userインスタンスの生成
		User user = new User(ID, pass);
		//Login処理
		LoginBO loginBO = new LoginBO();
		User account = loginBO.execute(user);
		//Login成功時の処理
		if(account != null) {
			//セッションスコープにユーザ情報を保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", account);
		} else {
			// user's ID means MAIL case by 2020/06/19 S.Fujihara
			User accountMail = loginBO.executeMail(user);
			System.out.println("Login Mail Case...");
			if (accountMail != null) {
				//セッションスコープにユーザ情報を保存
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", accountMail);
			}

		}
		//ログイン結果画面にフォワード
		String path = "/WEB-INF/jsp/loginResult.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}

}
