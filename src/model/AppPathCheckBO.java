package model;

public class AppPathCheckBO {
	public boolean execute(String appPath) {
		boolean isCheck = false;
		if(appPath.matches(".*[.][Ee][Xx][Ee]$")) {
			isCheck = true;
		}
		return isCheck;
	}
}
