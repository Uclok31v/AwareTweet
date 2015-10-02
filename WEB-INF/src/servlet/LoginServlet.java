package servlet;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.PasswordEncryption;
import beans.User;
import controller.LoginManager;

public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		//ipアドレスの取得
		InetAddress addr = InetAddress.getLocalHost();
		String ip = String.valueOf(addr.getHostAddress());
			
		//ipアドレスの重複チェック
			
		LoginManager loginManager = new LoginManager();
		//チェックしたら失敗回数をもってくる
		int failCount = loginManager.checkOverlapCount(ip);
	
		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);
			
			
			
		User user = loginManager.selectUserByIdPass(userId, password);
			
			
			
		//もし10回以上パスワード間違った場合はシステムにはアクセスできなくなる
		if(failCount >= 10){
			request.setAttribute("error", "You don't access to this system.");
			getServletContext().getRequestDispatcher("/jsp/common/login.jsp").forward(request, response);
		}
			
		else{
			//userがもってこれている．
			if(user!=null){
				//一回でもログインに成功したら失敗回数のリセット
				loginManager.resetIpHistoryFailCountByIp(ip);
				HttpSession session = request.getSession();
				
				//avatorディレクトリの作成
				String avatorName = loginManager.createAvator(user.getUser_id());
				
				String hostPath = "http://localhost:8080/";
				
				//avatorのパス
				String avatorPath = hostPath + "AwareTweet/avator/" + user.getUser_id() + "/"+ avatorName;
				
				//userオブジェクトにアバターのパスを追加
			    user.setAvator_path(avatorPath);
			    
			    String hostFullPath = "/Users/shu920921/Documents/workspace/";
			    String userListPath = hostFullPath + "AwareTweet/avator";
			    
			    //ユーザリストの追加
			    File[] userList = loginManager.getUserList(userListPath);
			    
			    request.setAttribute("user-list", userList);
				session.setAttribute("user",user);
	
				getServletContext().getRequestDispatcher("/jsp/hazelab/top.jsp").forward(request, response);
				}
					
			//ログイン失敗
			else{
				//失敗してるからincrementする
				loginManager.incrementIpHistoryFailCountByIp(ip);
				getServletContext().getRequestDispatcher("/jsp/common/login.jsp").forward(request, response);
			}
					
		}
	}
}