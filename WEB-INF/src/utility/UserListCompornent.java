package utility;

import java.io.File;

public class UserListCompornent{

	public File[] getUserList() {
		// TODO Auto-generated method stub
		String hostFullPath = "/Users/KentaroUdonishi/Documents/workspace/";
	    String userListPath = hostFullPath + "AwareTweet/avator";
	    
	    File userList = new File(userListPath);
	    File[] users = userList.listFiles();
		return users;
	}
	
	
}