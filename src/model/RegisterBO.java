package model;

import DAO.AccountDAO;
import beans.User;

public class RegisterBO {

	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		boolean isRegiter = dao.insertUser(user);
		return isRegiter;
	}

}
