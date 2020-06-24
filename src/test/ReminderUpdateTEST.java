package test;

import beans.Remind;
import model.RemUpdBO;

public class ReminderUpdateTEST {

	public static void main(String[] args) {
		int remindID = 1;
		String userID = "000000";
		String remind = "テスト";
		String category = "テスト";
		//Remindインスタンスの生成
		Remind reminder = new Remind(remindID, userID, remind, category);
		//Update処理
		RemUpdBO bo = new RemUpdBO();
		boolean result = bo.execute(reminder);
		System.out.println(result);
	}

}
