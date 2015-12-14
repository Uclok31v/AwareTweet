package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.PropertiesComponent;
import utility.PasswordEncryption;
import utility.Generate;
import beans.Tweet;
import beans.User;
import controller.LoginManager;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		//HOMEの確認
		Generate gen = new Generate();
		gen.createHomeDir();

		//db確認
		gen.createDB();


		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");


		//ipアドレスの取得
		String ip = request.getRemoteAddr();

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
				String avatorPath = loginManager.createAvator(user.getUser_id());

				//userオブジェクトにアバターのパスを追加
			    user.setAvator_path(avatorPath);

				session.setAttribute("user",user);

				//tweetList
				ArrayList<Tweet> tweetList = loginManager.selectTweet();

		        request.setAttribute("tweetList",tweetList);

				getServletContext().getRequestDispatcher("/jsp/community/top.jsp").forward(request, response);
				}

			//ログイン失敗
			else{
				//失敗してるからincrementする
				loginManager.incrementIpHistoryFailCountByIp(ip);
				request.setAttribute("error", "don't match id or pass");
				getServletContext().getRequestDispatcher("/jsp/common/login.jsp").forward(request, response);
			}

		}
	}
}
