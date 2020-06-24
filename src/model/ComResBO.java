package model;

import DAO.AppPathDAO;
import DAO.BotActionDAO;
import DAO.BotResDAO;
import beans.ComResPath;
import beans.User;

public class ComResBO {

	public String execute(User loginUser, ComResPath comres) {
		String errorMsg = null;
		BotActionDAO dao = new BotActionDAO();
		int resID = dao.getResID();
		boolean isInsertCom = dao.insertAction(loginUser, comres, resID);
		if(isInsertCom) {
			BotResDAO daoRes = new BotResDAO();
			boolean isInsertRes = daoRes.insertResponse(loginUser, comres, resID);
			if(isInsertRes) {
				if(!comres.getPath().equals("path")) {
					AppPathDAO daoPath = new AppPathDAO();
					boolean isInsertPath = daoPath.insertPath(loginUser, comres, resID);
					if(!isInsertPath) { errorMsg = "Pathの登録に失敗しました"; }
				}
			}else { errorMsg = "Responseの登録に失敗しました"; }
		}else { errorMsg = "Commandの登録に失敗しました"; }
		return errorMsg;
	}
}
