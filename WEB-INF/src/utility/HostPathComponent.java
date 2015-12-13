package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.ResourceBundle;



public class HostPathComponent{

	String propertiesFile = "user";
	Properties conf = new Properties();

	public String createHomePath() {

		String homeDir = ResourceBundle.getBundle(propertiesFile).getString("homeDir");
		return homeDir;
	}

	public String imgHostPath() throws UnknownHostException {

		String hostPath = ResourceBundle.getBundle(propertiesFile).getString("hostPath");
		return hostPath;
	}

}
