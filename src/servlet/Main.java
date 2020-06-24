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

import beans.Command;
import beans.Robot;
import beans.User;
import model.GetComBO;
import model.PostComBO;
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action == null) {
		}else if(action.equals("done")) {
			session.removeAttribute("path");
		}
		User loginUser = (User)session.getAttribute("loginUser");
		GetComBO getComBO = new GetComBO();
		List<Command> commandList = getComBO.execute(loginUser);
		request.setAttribute("commandList", commandList);
		String path = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		//セッションスコープのユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		Command com = new Command(loginUser.getName(), command);
		PostComBO postComBO = new PostComBO();
		boolean isPostCom = postComBO.execute(com);
		if(isPostCom) {
			Robot robot = new Robot();
			robot = robot.execute(loginUser, command);
			if(robot.getPath() != null) {
				session.setAttribute("path", robot.getPath());
			} else if(robot.getResID() == 0) {
				request.setAttribute("errorMsg", "入力されたコマンドは設定されていません");
			}
		}else {
			request.setAttribute("errorMsg", "ERROR!! *コマンドは255文字以内で入力してください*");
		}
		GetComBO getComBO = new GetComBO();
		List<Command> commandList = getComBO.execute(loginUser);
		request.setAttribute("commandList", commandList);
		String path = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
