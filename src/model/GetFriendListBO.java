package model;

import java.util.List;

import DAO.AccountDAO;
import beans.User;

public class GetFriendListBO {

	public List<User> execute(User loginUser) {
		AccountDAO dao = new AccountDAO();
		List<User> friendList = dao.getFriends(loginUser);
		return friendList;
	}

}
