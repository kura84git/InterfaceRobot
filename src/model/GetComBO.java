package model;

import java.util.List;

import DAO.CommandDAO;
import beans.Command;
import beans.User;

public class GetComBO {

	public List<Command> execute(User loginUser) {
		CommandDAO dao = new CommandDAO();
		List<Command> commandList= dao.selectCommand(loginUser);
		return commandList;
	}
}
