package model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.BotAction;
public class FuzzyCheckBO {
	public int execute(List<BotAction> actionList, String command) {
		int resID = 0;
		for(int i=0; i<actionList.size(); i++) {
	        Pattern p = Pattern.compile(actionList.get(i).getAction());
	        Matcher m = p.matcher(command);
	        if(m.find()) {
	        	resID = actionList.get(i).getResID();
	        	break;
	        }
		}
		return resID;
	}
}
