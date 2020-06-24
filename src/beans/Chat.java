package beans;

import java.io.Serializable;

public class Chat implements Serializable {
	private int id;
	private int friendID;
	private String name;
	private String userID;
	private String chat;

	public Chat(int id, int friendID, String name, String chat) {
		this.id = id;
		this.friendID = friendID;
		this.name = name;
		this.chat =chat;
	}
	public Chat(String userID, int friendID, String chat) {
		this.friendID = friendID;
		this.userID = userID;
		this.chat =chat;
	}

	public int getId() {
		return id;
	}

	public int getFriendID() {
		return friendID;
	}

	public String getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getChat() {
		return chat;
	}
}
