package model;

import java.util.List;

import DAO.ChatDAO;
import beans.Chat;

public class GetFriendChatBO {
	public List<Chat> execute(List<Integer> matchID) {
		ChatDAO dao = new ChatDAO();
		List<Chat> chatList = dao.getChat(matchID);
		return chatList;
	}
}
