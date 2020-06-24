package test;

import java.util.List;
import java.util.Set;

import beans.Remind;
import beans.User;
import model.RemSortBO;

public class ReminderSortTEST {

	public static void main(String[] args) {
		String ID = "000000";
		String pass = "test";
		//Userインスタンスの生成
		User user = new User(ID, pass);
		//findCategoryt処理
		RemSortBO bo = new RemSortBO();
		Set<Remind> categoryList = bo.findCategory(user);
		for (Remind category : categoryList) {
			System.out.println(category.getCategory());
		}
		System.out.println();
		String category = "test";
		//findCategoryt処理
		List<Remind> remSortList = bo.sort(user, category);
		for (Remind remind : remSortList) {
			System.out.println(remind.getRemind());
		}
	}
}
