package controller;

import java.io.File;

import utility.HostPathCompornent;

public class GetSlideManager {

	public GetSlideManager(){
		
	}
	
	public void checkDirectory(String user_id) {
		// TODO Auto-generated method stub
		//ホストによって異なるパス
		HostPathCompornent createHostPath = new HostPathCompornent();
		String hostPath = createHostPath.createHostPath();
		File file = new File(hostPath +"AwareTweet/slide/"+user_id);
		if(file.exists()){
			
		}
		else{
			file.mkdir();
		}
	}

	public File[] getSlideList(String user_id) {
		// TODO Auto-generated method stub
		HostPathCompornent createHostPath = new HostPathCompornent();
		String hostPath = createHostPath.createHostPath();
		
		//探索するパス
		String basePath = hostPath + "AwareTweet/slide/" + user_id;
		
		File dir = new File(basePath);
		File[] files = dir.listFiles();
		return files;
	}

}
