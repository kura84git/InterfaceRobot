package model;

import java.io.IOException;

public class ExecExternalApp {

	public void exec(String appPath) {
	    try {
	        Runtime rt = Runtime.getRuntime();
	        rt.exec( appPath );
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

}
