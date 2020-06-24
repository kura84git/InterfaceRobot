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
import model.UpdUserBO;

@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String action = request.getParameter("action");
		if(action == null){
			path = "/WEB-INF/jsp/userUpdate.jsp";
		}else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user"); //変更後情報
			User loginUser = (User)session.getAttribute("loginUser"); //変更前情報
			UpdUserBO bo = new UpdUserBO();
			boolean isRegister = bo.execute(loginUser, user); //変更前情報, 変更後情報
			if(isRegister) {
				path = "/WEB-INF/jsp/registerResult.jsp";
				session.setAttribute("loginUser", user);
				session.removeAttribute("user");
			}else {
				request.setAttribute("errorMsg", "そのIDは既に使用されています。別のIDを入力してください。");
				path = "/WEB-INF/jsp/userUpdate.jsp";
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("userID");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String botName = request.getParameter("botName");
		User user = new User(ID, pass, name, mail, botName);
		HttpSession session = request.getSession();
		session.setAttribute("user", user); //変更後情報
		String path = "/WEB-INF/jsp/registerConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
