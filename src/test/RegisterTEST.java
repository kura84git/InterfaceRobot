package test;

import beans.User;
import model.RegisterBO;

public class RegisterTEST {

	public static void main(String[] args) {
		String ID = "000000";
		String pass = "test";
		String name = "testName";
		String mail = "test@mail";
		String botName = "testRobot";
		User user = new User(ID, pass, name, mail, botName);
		RegisterBO registerBO = new RegisterBO();
		boolean isRegister = registerBO.execute(user);
		System.out.println("結果は" + isRegister + "です！");
	}

}
