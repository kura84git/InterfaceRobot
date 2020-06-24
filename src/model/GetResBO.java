package model;

import DAO.AppPathDAO;
import DAO.BotResDAO;
import beans.Robot;

public class GetResBO {

	public Robot execute(int resID) {
		BotResDAO resDAO = new BotResDAO();
		String response = resDAO.selectRes(resID);
		AppPathDAO appDAO = new AppPathDAO();
		String path = appDAO.selectPath(resID);
		if(path != null) {
			Robot robot = new Robot(response, path);
			return robot;
		}else {
			Robot robot = new Robot(response);
			return robot;
		}
	}

}
