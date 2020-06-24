package model;

import DAO.ChatDAO;
import beans.Chat;

public class PostChatBO {

	public boolean execute(Chat c) {
		ChatDAO dao = new ChatDAO();
		boolean isPost =dao.postChat(c);
		return isPost;
	}

}
