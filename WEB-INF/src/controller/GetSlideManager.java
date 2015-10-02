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
			System.out.println("ない");
			file.mkdir();
			System.out.println("つくった");
		}
	}

	

}
