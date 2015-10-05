package utility;

import java.io.File;

public class UserListCompornent{

	public File[] getUserList() {
		// TODO Auto-generated method stub
		
		HostPathCompornent createHostPath = new HostPathCompornent();
		String hostPath = createHostPath.createHostPath();
	    String userListPath = hostPath + "AwareTweet/avator";
	    
	    File userList = new File(userListPath);
	    File[] users = userList.listFiles();
		return users;
	}
	
	
}