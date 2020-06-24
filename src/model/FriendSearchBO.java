package model;

import DAO.AccountDAO;
import beans.User;

public class FriendSearchBO {

	public User execute(String friendID, String friendBotName) {
		AccountDAO dao = new AccountDAO();
		User friend = dao.searchFriend(friendID, friendBotName);
		return friend;
	}

}
