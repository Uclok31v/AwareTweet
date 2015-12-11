package controller;

import dao.IpHistoryDAO;
import dao.TweetDAO;
import dao.UserDAO;
import beans.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import utility.HostPathComponent;

import org.apache.commons.io.FileUtils;

public class LoginManager {

	public LoginManager(){

	}

	public int checkOverlapCount(String ip) {
		// TODO Auto-generated method stub
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int count = ipHistoryDAO.selectIpHistoryCountByIp(ip);

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
		// TODO Auto-generated method stub
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int failCount = ipHistoryDAO.selectIpHistoryFailCountByIp(ip);
		return failCount;
	}

	private void insertIpHistoryIp(String ip) {
		// TODO Auto-generated method stub
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.insertIpHistoryIP(ip);
	}

	public User selectUserByIdPass(String userId, String password) {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();

		User user = userDAO.selectUserByIdPass(userId,password);

		return user;
	}

	public void resetIpHistoryFailCountByIp(String ip) {
		// TODO Auto-generated method stub
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.resetIpHistoryFailCountByIp(ip);
	}

	public void incrementIpHistoryFailCountByIp(String ip) {
		// TODO Auto-generated method stub
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.incrementIpHistoryFailCountByIp(ip);
	}

	public String createAvator(String user_id) {
		// TODO Auto-generated method stub
		// hostPathはホストによって異なるパス
		HostPathComponent createHostPath = new HostPathComponent();
		String homeDir = createHostPath.createHomePath();
		//hostpath = ~/.awaretweet/
		File file = new File(homeDir +"avator/"+user_id); //フルパス指定
		if(file.exists()){
			String image = homeDir + "avator/" + user_id + "avator.png";
			return image;
		}
		else{
			String url = "http://identicon.relucks.org/" + user_id;
			file.mkdir();
			return url;
	    }
	}


	public ArrayList selectTweet() {

		TweetDAO dao = new TweetDAO();

		ArrayList tweetList = dao.selectTweet();


		return tweetList;
	}
	//

}
