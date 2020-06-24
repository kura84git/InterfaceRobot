package model;

import DAO.CommandDAO;
import beans.Command;

public class PostComBO {

	public boolean execute(Command com) {
		CommandDAO dao = new CommandDAO();
		boolean isResult = dao.insertCommand(com);
		return isResult;
	}
}
