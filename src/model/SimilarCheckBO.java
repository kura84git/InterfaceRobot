package model;

import java.util.List;

import beans.BotAction;

public class SimilarCheckBO {

	public int execute(List<BotAction> actionList, String command) {
		int resID = 0;
		for(int i=0; i<actionList.size(); i++) {
			String action = actionList.get(i).getAction();
			if(command.equals(action)){
				resID = actionList.get(i).getResID();
				break;
			}
		}
		return resID;
	}

}
