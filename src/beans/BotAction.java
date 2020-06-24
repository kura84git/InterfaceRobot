package beans;

public class BotAction {
	private int resID;
	private String action;
	public BotAction(int resID, String action) {
		this.resID = resID;
		this.action = action;
	}
	public int getResID() {
		return resID;
	}
	public String getAction() {
		return action;
	}

}
