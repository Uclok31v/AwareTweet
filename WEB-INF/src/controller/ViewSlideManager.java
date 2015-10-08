package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;

import utility.HostPathCompornent;

import com.ibm.icu.text.Transliterator;

import dao.TweetDAO;

public class ViewSlideManager {
	
	//
	private Connection connection = null;
	//

	public ViewSlideManager(){
		
	}
	
	public File[] getJpegList(String userId, String slideName) {
		// TODO Auto-generated method stub
		HostPathCompornent createHostPath = new HostPathCompornent();
		String hostPath = createHostPath.createHostPath();
		
		//探索するパス
		String basePath = hostPath + "AwareTweet/slide/" + userId +"/"+ slideName + "/";
		
		File file = new File(basePath);
		File[] files = file.listFiles();
		for(int i=1;i<files.length;i++){
			Path src = Paths.get(basePath + files[i].getName());
			Transliterator transliterator = Transliterator.getInstance("Katakana-Latin");
			String reName = transliterator.transliterate(files[i].getName());
			System.out.println(reName);
			Path srcRename = Paths.get(basePath + reName);
			try {
				System.out.println("変更前"+ files[i].getName());
				Files.move(src, srcRename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("変更後"+files[1].getName());
		return files;
	}

	//スライドのツイート
	public ArrayList getSlideTweetList(String userId, String slideName) {
		// TODO Auto-generated method stub
		TweetDAO dao = new TweetDAO();

		this.connection = dao.createConnection();

		ArrayList list = dao.GetSlideTweetList(userId,slideName,this.connection);


		dao.closeConnection(this.connection);

		this.connection = null;
		
		return list;
	}
	//

}
