package beans;

import model.CheckComBO;
import model.GetResBO;
import model.PostComBO;

public class Robot {
	private int resID;
	private String botName;
	private String response;
	private String path;

	public Robot(String response, String path) {
		this.response = response;
		this.path = path;
	}

	public Robot(String response) {
		this.response = response;
	}

	public Robot() {
	}

	public Robot(int resID, String path) {
		this.resID = resID;
		this.path = path;
	}

	public String getBotName() {
		return botName;
	}

	public String getResponse() {
		return response;
	}

	public String getPath() {
		return path;
	}

	public int getResID() {
		return resID;
	}

	public Robot execute(User loginUser, String command) {
		this.botName = loginUser.getBotName();
		CheckComBO checkCom = new CheckComBO();
		int resID = checkCom.execute(loginUser, command);
		String appPath = null;
		if(resID != 0) {
			GetResBO getRes = new GetResBO();
			Robot robot = getRes.execute(resID);
			Command com = new Command(this.botName, robot.getResponse());
			PostComBO postComBO = new PostComBO();
			postComBO.execute(com);
			if(robot.getPath() != null) {
				appPath = robot.getPath();
			}
		}
		Robot robot = new Robot(resID, appPath);
		return robot;
	}
}
