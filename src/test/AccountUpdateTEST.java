package test;

import beans.User;
import model.UpdUserBO;

public class AccountUpdateTEST {

	public static void main(String[] args) {
		String oldID = "000000";
		String oldName = "testName";
		String oldPass = "test";
		String oldMail = "test@mail";
		String oldBotName = "testRobot";
		User oldUser = new User(oldID, oldName, oldPass, oldMail, oldBotName);
		String newID = "000001";
		String newName = "testName";
		String newPass = "test";
		String newMail = "test@mail";
		String newBotName = "testRobot";
		User newUser = new User(newID, newName, newPass, newMail, newBotName);
		UpdUserBO bo = new UpdUserBO();
		System.out.println(bo.execute(oldUser, newUser));
	}

}
