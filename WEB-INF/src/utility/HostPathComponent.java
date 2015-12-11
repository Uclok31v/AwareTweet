package utility;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class HostPathComponent{

	public String createHomePath() {

		String home=System.getenv("HOME") + "/.awaretweet/";

		return home;
	}

	public String imgHostPath() throws UnknownHostException {

		//host名のないサーバへのデプロイを考慮してアドレスにする．
//		String hostAddress = InetAddress.getLocalHost().getHostAddress();
//		String hostPath = "http://" + hostAddress + "/";
		String hostPath = "http://localhost:8080/";

		return hostPath;
	}


}
