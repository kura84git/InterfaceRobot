package test;

import beans.Remind;
import model.RemSelcBO;

public class ReminderSelectOneTEST {

	public static void main(String[] args) {
		int remindID = 1;
		String userID = "000000";
		//Remindインスタンスの生成
		Remind id = new Remind(remindID, userID);
		//Select処理
		RemSelcBO bo = new RemSelcBO();
		Remind remSelcOne = bo.execute(id);
		System.out.println(remSelcOne.getRemind() + " " + remSelcOne.getCategory());
	}

}
