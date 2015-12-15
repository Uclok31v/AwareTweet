package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class PropertiesComponent{

	//ホームディレクトリにawaretweet.confを
	//ダウンロードしてもらってそこを参照する設定にする

//	String home = System.getenv("HOME");
	String home = "C:/Users/tanese kenta";
	Properties properties = new Properties();
	String propertiesFile = home + "/awaretweet.conf";

	public String referProperties(String prop) {
		/*appRootPath
		 * hostPath
		 *
		 */
		try {

            InputStream inputStream = new FileInputStream(propertiesFile);
            properties.load(new FileInputStream(propertiesFile));
            inputStream.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

		String referProperties = properties.getProperty(prop);
		System.out.println(referProperties);
		return referProperties;
	}


}
