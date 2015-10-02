package controller;

import dao.IpHistoryDAO;
import dao.UserDAO;
import beans.User;

import java.io.File;
import java.io.IOException;

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
		String hostPath = "/Users/shu920921/Documents/workspace/";
		File file = new File(hostPath +"AwareTweet/avator/"+user_id+"/avator.png" ); //フルパス指定
		if(file.exists()){
			String avatorName = file.getName();
			return avatorName;
		}
		else{
			String avatorName = mkdirbyUserID(user_id, hostPath);
			return avatorName;
		}
	}

	private String mkdirbyUserID(String user_id, String hostPath) {
		// TODO Auto-generated method stub
		File file = new File(hostPath +"AwareTweet/avator/"+user_id);
		if(file.mkdir()){
			String avatorName = createAvatorFile(user_id, hostPath);
			return avatorName;
		}
		else{
			return null;
		}
	}

	private String createAvatorFile(String user_id, String hostPath) {
		// TODO Auto-generated method stub
		File file = new File(hostPath +"AwareTweet/avator/"+user_id+"/avator.png");
		try{
			file.createNewFile();
			return file.getName();
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		
	}

}
