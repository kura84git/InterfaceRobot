package model;

import java.util.List;

import DAO.FriendDAO;
import beans.User;

public class FriendMatchBO {

	public List<Integer> execute(User loginUser, User friend) {
		FriendDAO dao = new FriendDAO();
		List<Integer> matchID = dao.findFriend(loginUser, friend);
		return matchID;
	}

}
