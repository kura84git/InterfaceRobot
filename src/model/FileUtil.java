package model;

import java.io.File;

public class FileUtil {

	public boolean checkFileExists( String fileName ) {
		File file = new File( fileName );
		Boolean fileExists = file.exists();
		return fileExists;
	}
}
