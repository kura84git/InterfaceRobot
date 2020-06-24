package test;

import beans.Remind;
import model.RemindBO;

public class ReminderInsertTEST {

	public static void main(String[] args) {
		String userID = "000000";
		String remind = "test";
		String category = "test";
		//Remindインスタンスの生成
		Remind remindLatest = new Remind(userID, remind, category);
		//Insert処理
		RemindBO bo = new RemindBO();
		boolean result = bo.insert(remindLatest);
		System.out.println(result);

	}

}
