package test;

import beans.User;
import model.CheckComBO;

public class CheckComTEST {

	public static void main(String[] args) {
		String command = "おはよう";
		String id = "testID";
		String pass = "testPass";
		User loginUser = new User(id, pass);
		CheckComBO checkCom = new CheckComBO();
		int resID = checkCom.execute(loginUser, command);
		System.out.println("結果IDは[" + resID + "]です！");
	}

}
