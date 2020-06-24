package test;

import java.util.List;

import beans.User;
import model.GetFriendListBO;

public class GetFriendsTEST {

	public static void main(String[] args) {
		User loginUser = new User("000000", "test", "test", "test@mail", "testROBOT");
		GetFriendListBO getFriends = new GetFriendListBO();
		List<User> friendList = getFriends.execute(loginUser);
		for(User friend : friendList) {
			System.out.println(friend.getName());
		}
	}

}
