package utility;

import java.io.File;
import java.util.ArrayList;

public class SlideListComponent{

	public ArrayList<String> getSlideList(){
		//ユーザリストの参照
		UserListComponent listCompornent = new UserListComponent();
		ArrayList<String> userList = listCompornent.getUserList();

		//ホストによって異なるパス
		String appRootPath = "C:/Users/tanese kenta/awaretweet/";
		//String appRootPath =  new PropertiesComponent().referProperties("appRootPath");

		//スライド名を格納する
		ArrayList<String> slideNameList = new ArrayList<String>();

		for(int i=0; i<userList.size();i++){
			File slideList = new File(appRootPath +"slide/"+ userList.get(i));
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
