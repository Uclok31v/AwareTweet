package utility;

import java.io.File;


public class HostPathComponent{

	public String createHostPath() {

		File file = new File("webapps");
	    String hostPath = file.getAbsolutePath() + "/";

		return hostPath;
	}

	public String imgHostPath() {
		String hostPath = "http://localhost:8080/";

		return hostPath;
	}


}
