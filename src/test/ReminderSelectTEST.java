package test;

import java.util.List;

import beans.Remind;
import beans.User;
import model.RemindBO;

public class ReminderSelectTEST {
	public static void main(String[] args) {
		String ID = "000000";
		String pass = "test";
		//Userインスタンスの生成
		User user = new User(ID, pass);
		//Select処理
		RemindBO bo = new RemindBO();
		List<Remind> remindList = bo.select(user);
		for (Remind remind : remindList) {
			System.out.println(remind.getRemind());
		}
	}
}
