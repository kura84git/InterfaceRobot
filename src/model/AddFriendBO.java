package model;

import DAO.FriendDAO;
import beans.User;

public class AddFriendBO {

	public boolean execute(User friend, User loginUser) {
		FriendDAO  dao = new FriendDAO();
		boolean isResult = dao.addFriend(friend, loginUser);
		return isResult;
	}

}
