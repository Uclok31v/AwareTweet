package servlet;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utility.PasswordEncryption;
import beans.User;
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
		int i=0;
		String userName=null;
		String password = null;
		String fileName=null;

		//ここ直してください。
		//String appRootPath =  new PropertiesComponent().referProperties("appRootPath");
		String appRootPath = "C:/Users/tanese kenta/awaretweet/";
		File path = new File(appRootPath + "avator/"+userId);

		DiskFileItemFactory factory   = new DiskFileItemFactory();
		factory.setRepository(path);
		factory.setSizeThreshold(1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(-1); //-1は無限
		upload.setHeaderEncoding("utf-8");

		try {
			List<FileItem> list = upload.parseRequest(request);
		    Iterator<FileItem> iterator = list.iterator();

		    while(iterator.hasNext()){
		      FileItem fileItem = iterator.next();

		     if(i==0){
		        	userName=fileItem.getString();
		        	byte[] bytes= userName.getBytes("iso-8859-1");
		    		userName = new String(bytes, "utf-8");
		        	i++;
		      }
		      else if(i==1){
		        	password=fileItem.getString();
		        	byte[] bytes= password.getBytes("iso-8859-1");
		    		password = new String(bytes, "utf-8");
		        	i++;
		      }
		      else if (!fileItem.isFormField()){
		          fileName = fileItem.getName();

		          if ((fileName != null) && (!fileName.equals(""))){
		            fileItem.write(new File(path + "/" + fileName));

		            i++;
		          }
		      }

		    }

		  }catch (FileUploadException e) {
		    e.printStackTrace();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }


		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);

		SettingManager settingManager = new SettingManager();
		settingManager.apdateUserNamePassById(userId, userName, password);


		session.setAttribute("user",user);

		getServletContext().getRequestDispatcher("/jsp/community/setting.jsp").forward(request, response);
	}
}
