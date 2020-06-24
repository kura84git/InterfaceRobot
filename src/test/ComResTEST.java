package test;

import beans.ComResPath;

public class ComResTEST {

	public static void main(String[] args) {
		String execFile = "";
		String newCom = "command";
		String newRes = "response";
		if(execFile.equals("")) { //実行ファイルなしの場合、コマンドとレスポンスのみをテーブルに格納する
			ComResPath comres = new ComResPath(newCom, newRes, "path");
			System.out.println("command "+ comres.getCom());
			System.out.println("response "+ comres.getRes());
			System.out.println("path "+ comres.getPath());
		}else { //実行ファイルありの場合、指定された実行ファイルのパスを取得しにいく
			;
		}

	}

}
