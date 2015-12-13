package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class HostPathComponent{

	//ホームディレクトリにawaretweet.confを
	//ダウンロードしてもらってそこを参照する設定にする
	String home = System.getenv("HOME");
	Properties properties = new Properties();
	String propertiesFile = home + "/awaretweet.conf";

	public String createHomePath() {
		try {

            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

		String homeDir = properties.getProperty("appRootPath");
		return homeDir;
	}

	public String imgHostPath() {
		try {

            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

		String hostPath = properties.getProperty("homePath");
		return hostPath;
	}

}
