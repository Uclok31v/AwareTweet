package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class PropertiesComponent{

	//ホームディレクトリにawaretweet.confを
	//ダウンロードしてもらってそこを参照する設定にする
	String home = System.getenv("HOME");
	Properties properties = new Properties();
	String propertiesFile = home + "/awaretweet.conf";

	public String appRootPath() {
		try {

            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

		String appRootPath = properties.getProperty("appRootPath");
		return appRootPath;
	}

	public String imgHostPath() {
		try {

            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

		String hostPath = properties.getProperty("hostPath");
		return hostPath;
	}

}
