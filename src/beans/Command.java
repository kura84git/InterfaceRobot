package beans;

import java.io.Serializable;

public class Command implements Serializable{
	private int id;
	private String name;
	private String command;
	public Command(String name, String command) {
		this.name = name;
		this.command = command;
	}//Main
	public Command(int id, String name, String command) {
		this.id = id;
		this.name = name;
		this.command = command;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCommand() {
		return command;
	}
}
