package model;

import java.io.File;

public class SearchPathBO {

	public String execute(String execFile) {
		String path = null;
		File file = new File(execFile);
		path = file.getAbsolutePath();
		return path;
	}

}
