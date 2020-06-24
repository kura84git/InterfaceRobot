package beans;

public class ComResPath {
	private String com;
	private String res;
	private String path;

	public ComResPath(String newCom, String newRes, String string) {
		this.com = newCom;
		this.res = newRes;
		this.path = string;
	}

	public String getCom() {
		return com;
	}

	public String getRes() {
		return res;
	}

	public String getPath() {
		return path;
	}

}
