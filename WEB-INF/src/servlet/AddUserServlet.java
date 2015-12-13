package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.HostPathComponent;
import utility.PasswordEncryption;
import beans.User;
import controller.AddUserManager;


public class AddUserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("user_id");
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");

		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);

		AddUserManager addUserManager = new AddUserManager();
		addUserManager.insertUser(userId, userName, password);

		getServletContext().getRequestDispatcher("/jsp/community/adduser.jsp").forward(request, response);




		}
	}
