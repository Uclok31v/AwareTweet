package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.User;
import utility.HostPathComponent;
import utility.PasswordEncryption;
import controller.SettingManager;

public class SettingServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			doPost(request, response);
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUser_id();

		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);

		SettingManager settingManager = new SettingManager();
		settingManager.apdateUserNamePassById(userId, userName, password);


		session.setAttribute("user",user);

		getServletContext().getRequestDispatcher("/jsp/community/setting.jsp").forward(request, response);
	}
}
