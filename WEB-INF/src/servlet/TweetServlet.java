package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import controller.TweetManager;

public class TweetServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		String presenter=request.getParameter("presenter");
		String comment=request.getParameter("comment");

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String commenter = user.getUser_name();

		TweetManager manager=new TweetManager();

		manager.insertTweet(commenter,presenter,comment);

     	response.sendRedirect(response.encodeRedirectURL("./top.jsp"));
		}
	}
