package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginManager;
import beans.User;


public class MoveTopServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
			//保持されているユーザー情報を取得する
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			String userId = user.getUser_id();
			
			LoginManager loginManager = new LoginManager();
			
			//tweetList
			ArrayList tweetList = loginManager.selectTweet();

			session.setAttribute("user",user);
	        request.setAttribute("tweetList",tweetList);
	        
	

			getServletContext().getRequestDispatcher("/jsp/hazelab/top.jsp").forward(request, response);
	}
	
	
}
