package test;

import model.FileUtil;

public class CheckExistsFileTest {

	public static void main (String[] args) {
		String fileName = "C:\\Program Files\\Microsoft Office\\Office16\\WINWORD.EXE";
		//String fileName = "C:\\Program Files\\Microsoft Office\\Office\\WINWORD.EXE";

		FileUtil objFile = new FileUtil();
		boolean fileFlag = objFile.checkFileExists(fileName);
		//File file = new File(fileName);
		//boolean fileFlag = file.exists();
		System.out.println("ファイル名 : " + fileName);
		System.out.println("checkFileExists結果は[" + fileFlag + "]です！");

		String fileName2 = "C:\\Program Files\\Microsoft Office\\Office\\WINWORD.EXE";

		FileUtil objFile2 = new FileUtil();
		boolean fileFlag2 = objFile2.checkFileExists(fileName2);

		System.out.println("ファイル名 : " + fileName2);
		System.out.println("checkFileExists結果は[" + fileFlag2 + "]です！");


	}

}
