package utility;

import java.io.File;
import java.util.ArrayList;

public class SlideListCompornent{
	
	public ArrayList<String> getSlideList(){
		//ユーザリストの参照
		UserListCompornent listCompornent = new UserListCompornent();
		ArrayList<String> userList = listCompornent.getUserList();
		
		//ホストによって異なるパス		
		HostPathCompornent createHostPath = new HostPathCompornent();
		String hostPath = createHostPath.createHostPath();
		
		//スライド名を格納する
		ArrayList<String> slideNameList = new ArrayList<String>();
		
		for(int i=0; i<userList.size();i++){
			File slideList = new File(hostPath +"AwareTweet/slide/"+ userList.get(i));
			if(slideList.exists()){
					File[] slides = slideList.listFiles();
					for(int j=0; j<slides.length; j++){
						if(!(slides[j].getName().startsWith("."))){
							slideNameList.add(slides[j].getName());
						}
				}
			}
		}
		return slideNameList;
	}

}