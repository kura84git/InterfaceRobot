package model;

import java.util.List;

import DAO.BotActionDAO;
import beans.BotAction;
import beans.User;

public class CheckComBO {

	public int execute(User loginUser, String command) {
		int resID = 0;
		BotActionDAO dao = new BotActionDAO();
		resID = dao.selectMyAction(loginUser, command);
		if(resID ==0) {
			resID = dao.selectAction(command);
			if(resID == 0) {
				List<BotAction>  actionList = dao.getAction(loginUser);
				SimilarCheckBO similarCheck = new SimilarCheckBO();
				resID = similarCheck.execute(actionList, command);
				if(resID == 0) {
					FuzzyCheckBO fuzzyCheck = new FuzzyCheckBO();
					resID = fuzzyCheck.execute(actionList, command);
				}
			}
		}
		return resID;
	}
}
