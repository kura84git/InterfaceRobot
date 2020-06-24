package model;

import DAO.AccountDAO;
import beans.User;

public class LoginBO {

	public User execute(User user) {
		AccountDAO dao = new AccountDAO();
		User account = dao.selectUser(user);
		return account;
	}

	public User executeMail(User user) {
		// user's ID means MAIL case by 2020/06/19 S.Fujihara
		AccountDAO dao = new AccountDAO();
		User account = dao.selectMail(user);
		return account;
	}

}
