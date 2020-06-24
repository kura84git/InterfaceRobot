package test;

import beans.User;
import model.LoginBO;

public class LoginTEST {

	public static void main(String[] args) {
		String ID = "000000";
		String pass = "test";
		//Userインスタンスの生成
		User user = new User(ID, pass);
		//Login処理
		LoginBO loginBO = new LoginBO();
		User account = loginBO.execute(user);
		System.out.println("ようこそ" + account.getName() + "さん");
	}
}
