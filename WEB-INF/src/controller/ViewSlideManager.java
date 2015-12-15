package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import beans.Tweet;

import com.ibm.icu.text.Transliterator;

import dao.TweetDAO;

public class ViewSlideManager {

	public ViewSlideManager(){

	}

	public File[] getJpegList(String userId, String slideName) {

		//ここ直してください。
		//String appRootPath =  new PropertiesComponent().referProperties("appRootPath");
		String appRootPath = "C:/Users/tanese kenta/awaretweet/";

		//探索するパス
		String basePath = appRootPath + "slide/" + userId +"/"+ slideName + "/";

		File file = new File(basePath);
		File[] files = file.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].getName().startsWith(".")){
				files[i].delete();
				return null;
			}
			else{
				Path src = Paths.get(basePath + files[i].getName());
				Transliterator transliterator = Transliterator.getInstance("Katakana-Latin");
				String reName = transliterator.transliterate(files[i].getName());
				Path srcRename = Paths.get(basePath + reName);
				try {
					Files.move(src, srcRename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		File[] renameFiles = new File(basePath).listFiles();

		Arrays.sort(renameFiles, new FileSort());
		return renameFiles;
	}

	static class FileSort implements Comparator<File> {
		  public int compare(File src, File target) {
			  int diff = src.getName().compareTo(target.getName());
			  return diff;
		  }
	}

	//スライドのツイート
	public ArrayList<Tweet> getSlideTweetList(String userId, String slideName) {

		ArrayList<Tweet> list =  new TweetDAO().selectTweetbyUserIdandSlideName(userId, slideName);

		return list;
	}


}
