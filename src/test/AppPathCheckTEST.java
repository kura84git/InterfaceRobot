package test;

import model.AppPathCheckBO;

public class AppPathCheckTEST {

	public static void main(String[] args) {
		//String appPath = "notepad.exe";
		//String appPath = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE";
		String appPath = "/Reminder";
		AppPathCheckBO check = new AppPathCheckBO();
		boolean  isCheck = check.execute(appPath);
		System.out.println(isCheck);
	}

}
