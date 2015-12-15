package controller;

import java.io.File;

import utility.PropertiesComponent;

public class GetSlideManager {

	public GetSlideManager(){

	}

	public void checkDirectory(String user_id) {
		//ここ直してください
		//String appRootPath =  new PropertiesComponent().referProperties("appRootPath");
		String appRootPath = "C:/Users/tanese kenta/awaretweet/";
		File file = new File(appRootPath +"/slide/"+user_id);
		if(file.exists()){

		}
		else{
			file.mkdir();
		}
	}

	public File[] getSlideList(String user_id) {
		// TODO Auto-generated method stub
		String appRootPath =  new PropertiesComponent().referProperties("appRootPath");

		//探索するパス
		String basePath = appRootPath + "/slide/" + user_id;

		File dir = new File(basePath);
		File[] files = dir.listFiles();
		return files;
	}

}
