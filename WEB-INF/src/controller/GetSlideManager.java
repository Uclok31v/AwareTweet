package controller;

import java.io.File;

public class GetSlideManager {

	public GetSlideManager(){
		
	}
	
	public void checkDirectory(String user_id) {
		// TODO Auto-generated method stub
		//ホストによって異なるパス
		String hostPath = "/Users/shu920921/Documents/workspace/";
		File file = new File(hostPath +"AwareTweet/slide/"+user_id);
		if(file.exists()){
			
		}
		else{
			file.mkdir();
		}
	}

	public File[] getSlideList(String user_id) {
		// TODO Auto-generated method stub
		String hostPath = "/Users/shu920921/Documents/workspace/";
		
		//探索するパス
		String basePath = hostPath + "AwareTweet/slide/" + user_id;
		
		File dir = new File(basePath);
		File[] files = dir.listFiles();
		return files;
	}

}
