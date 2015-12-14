package controller;

import dao.IpHistoryDAO;
import dao.TweetDAO;
import dao.UserDAO;
import beans.Tweet;
import beans.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import utility.PropertiesComponent;

public class LoginManager {

	public LoginManager(){

	}

	public int checkOverlapCount(String ip) {

		int count = new IpHistoryDAO().selectIpHistoryCountByIp(ip);

		//ipアドレスの登録がなかった場合
		if(count ==0){
			insertIpHistoryIp(ip);
		}
		//登録があった場合は何もしない

		//最後に失敗回数を確認し，その値を返す．
		int failCount = selectIpHistoryFailCountByIp(ip);
		return failCount;
	}

	private int selectIpHistoryFailCountByIp(String ip) {

		int failCount = new IpHistoryDAO().selectIpHistoryFailCountByIp(ip);
		return failCount;
	}

	private void insertIpHistoryIp(String ip) {

		new IpHistoryDAO().insertIpHistoryIP(ip);
	}

	public User selectUserByIdPass(String userId, String password) {
		// TODO Auto-generated method stub

		User user = new UserDAO().selectUserByIdPass(userId,password);

		return user;
	}

	public void resetIpHistoryFailCountByIp(String ip) {
		// TODO Auto-generated method stub
		new IpHistoryDAO().resetIpHistoryFailCountByIp(ip);
	}

	public void incrementIpHistoryFailCountByIp(String ip) {

		new IpHistoryDAO().incrementIpHistoryFailCountByIp(ip);
	}

	public String createAvator(String user_id) throws IOException {
		String appRootPath =  new PropertiesComponent().referProperties("appRootPath");
		String imgPath =  new PropertiesComponent().referProperties("hostPath");
		//hostpath = ~/.awaretweet/
		File file = new File(appRootPath +"avator/"+user_id); //フルパス指定
		if(file.exists()){
			String image = imgPath + "avator/" + user_id + "/avator.jpeg";
			return image;
		}
		else{
			file.mkdir();

			String image = "http://identicon.relucks.org/" + user_id + "?size=126";
			return image;
	    }
	}


	public ArrayList<Tweet> selectTweet() {

		ArrayList<Tweet> tweetList = new TweetDAO().selectTweet();

		return tweetList;
	}


}
