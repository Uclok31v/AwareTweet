package utility;

import java.io.File;
import java.util.ArrayList;

public class UserListComponent{

	public ArrayList<String> getUserList() {
		// TODO Auto-generated method stub
		
		HostPathComponent createHostPath = new HostPathComponent();
		String hostPath = createHostPath.createHostPath();
	    String userListPath = hostPath + "AwareTweet/avator";
	    
	    File userList = new File(userListPath);
	    File[] users = userList.listFiles();
	    ArrayList<String> userNameList = getUserNameList(users);
		return userNameList;
	}

	private ArrayList<String> getUserNameList(File[] users) {
		// TODO Auto-generated method stub
		ArrayList<String> userNameList = new ArrayList<String>();
		
		for(int i=0; i< users.length; i++){
			if(!(users[i].getName().startsWith("."))){
				if(!(users[i].getName().equals("default"))) {
					userNameList.add(users[i].getName());
				}
			}
		}
		return userNameList;
	}
	
	
	
}