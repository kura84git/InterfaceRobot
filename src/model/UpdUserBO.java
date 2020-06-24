package model;

import DAO.AccountDAO;
import beans.User;

public class UpdUserBO {
	public boolean execute(User loginUser, User user) {
		AccountDAO dao = new AccountDAO();
		return dao.updateUser(loginUser, user); //引数には変更前情報, 変更後情報
	}
}
