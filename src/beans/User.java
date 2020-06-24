package beans;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String pass;
	private String ID;
	private String mail;
	private String botName;

	public User() {}

	public User(String ID, String pass){
		this.ID = ID;
		this.pass = pass;
	}//login

	public User(String ID, String pass, String name, String mail, String botName) {
		this.ID = ID;
		this.pass = pass;
		this.name = name;
		this.mail = mail;
		this.botName = botName;
	}//regidter login

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getID() {
		return ID;
	}

	public String getMail() {
		return mail;
	}

	public String getBotName() {
		return botName;
	}

}
