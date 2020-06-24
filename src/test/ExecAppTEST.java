package test;

import model.ExecExternalApp;

public class ExecAppTEST {

	public static void main(String[] args) {
		String appPath = "notepad.exe";
		//String appPath = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE";
		//String appPath = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE";
		//String appPath = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.EXE";
		//String appPath = "C:\\Windows\\System32\\calc.exe";

		ExecExternalApp app = new ExecExternalApp();
		app.exec( appPath );
	}

}
