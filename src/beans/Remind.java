package beans;

import java.io.Serializable;

public class Remind implements Serializable{

	private int ID;
	private String userID;
	private String remind;
	private String category;
	public Remind() {}
	public Remind(int ID, String userID, String remind, String category) {
		this.ID = ID;
		this.userID = userID;
		this.remind = remind;
		this.category = category;
	}
	public Remind(String userID, String remind, String category) {
		this.userID = userID;
		this.remind = remind;
		this.category = category;
	}
	public Remind(String category) {
		this.category = category;
	}
	public Remind(int ID, String userID) {
		this.ID = ID;
		this.userID = userID;
	}
	public int getID() {
		return ID;
	}
	public String getUserID() {
		return userID;
	}
	public String getRemind() {
		return remind;
	}
	public String getCategory() {
		return category;
	}
}
