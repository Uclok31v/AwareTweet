package controller;

import java.io.File;

import utility.HostPathComponent;

public class GetSlideManager {

	public GetSlideManager(){

	}

	public void checkDirectory(String user_id) {

		HostPathComponent createHostPath = new HostPathComponent();
		String homeDir = createHostPath.createHomePath();
		File file = new File(homeDir +"/slide/"+user_id);
		if(file.exists()){

		}
		else{
			file.mkdir();
		}
	}

	public File[] getSlideList(String user_id) {
		// TODO Auto-generated method stub
		HostPathComponent createHostPath = new HostPathComponent();
		String homeDir = createHostPath.createHomePath();

		//探索するパス
		String basePath = homeDir + "/slide/" + user_id;

		File dir = new File(basePath);
		File[] files = dir.listFiles();
		return files;
	}

}
