package utility;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class HostPathComponent{

	String home = System.getenv("HOME");
	public String createHomePath() {

		String homeDir = home + "/.awaretweet/";

		return homeDir;
	}

	public String imgHostPath() throws UnknownHostException {

		//host名のないサーバへのデプロイを考慮してアドレスにする．
//		String hostAddress = InetAddress.getLocalHost().getHostAddress();
//		String hostPath = "http://" + hostAddress + "/";

		//TODO どうやって~/.awaretweet/slideみえるんだーー
		String imgPath = "file:/" + home + "/.awaretweet/";

		return imgPath;
	}


}
