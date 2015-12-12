package utility;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class HostPathComponent{

	String home = System.getenv("HOME");
	public String createHomePath() {

		String homeDir = home + "/.awaretweet/";
		 String path = System.getProperty("user.dir");
	      System.out.println(path);

		return homeDir;
	}

	public String imgHostPath() throws UnknownHostException {

		//host名のないサーバへのデプロイを考慮してアドレスにする．
//		String hostAddress = InetAddress.getLocalHost().getHostAddress();
//		String hostPath = "http://" + hostAddress + "/";

		//TODO どうやって~/.awaretweet/slideみえるんだーー
		String imgPath = "http://localhost:8080/.awaretweet/";

		return imgPath;
	}


}
