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
import beans.User;
import model.AppPathCheckBO;
import model.ExecExternalApp;
import model.FileUtil;
import model.GetComBO;


@WebServlet("/ExternalApp")
public class ExternalApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		HttpSession session = request.getSession();
		String appPath = (String) session.getAttribute("path");
		AppPathCheckBO check = new AppPathCheckBO();
		boolean  isCheck = check.execute(appPath);
		if(isCheck) {
			//Check for existing file of pathlist (appPath)
			FileUtil objFile = new FileUtil();
			boolean isFileExists = objFile.checkFileExists(appPath);
			if ( isFileExists ) {
				ExecExternalApp app = new ExecExternalApp();
				app.exec( appPath );
			} else {
				String errorMsg = "Not exist Application module : " + appPath;
				request.setAttribute("errorMsg", errorMsg);
			}
			session.removeAttribute("path");
			User loginUser = (User)session.getAttribute("loginUser");
			GetComBO getComBO = new GetComBO();
			List<Command> commandList = getComBO.execute(loginUser);
			request.setAttribute("commandList", commandList);
			path = "/WEB-INF/jsp/main.jsp";
		}else {
			path = appPath;
		}

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
