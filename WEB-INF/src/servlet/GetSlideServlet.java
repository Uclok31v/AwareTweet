package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.GetUserListCompornent;
import beans.User;
import controller.GetSlideManager;
import controller.LoginManager;

public class GetSlideServlet extends HttpServlet{
	
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
			
				
			//ログインユーザがスライドディレクトリを保持しているかチェック
			//なければつくってくる
			GetSlideManager getSlideManager = new GetSlideManager();
			getSlideManager.checkDirectory(user.getUser_id());
			
			//スライドのリストを取得する
			File[] slideList = getSlideManager.getSlideList(user.getUser_id());
			
			request.setAttribute("slide-list",slideList);
			session.setAttribute("user",user);
			getServletContext().getRequestDispatcher("/jsp/hazelab/slideselect.jsp").forward(request, response);
				
	}
}