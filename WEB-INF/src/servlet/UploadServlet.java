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

import utility.HostPathComponent;
import beans.User;

public class UploadServlet extends HttpServlet{
	
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
		
		//hostによって異なるパス
		HostPathComponent createHostPath = new HostPathComponent();
		String hostPath = createHostPath.createHostPath();
		File path = new File(hostPath + "AwareTweet/avator/"+userId);
		
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
		      FileItem fileItem = (FileItem)iterator.next();
		      
		      if (!fileItem.isFormField()){
		          String fileName = fileItem.getName();

		          if ((fileName != null) && (!fileName.equals(""))){
		            fileItem.write(new File(path + "/avator.png"));
		          }
		      }
		    }

		  }catch (FileUploadException e) {
		    e.printStackTrace();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		session.setAttribute("user",user);
		getServletContext().getRequestDispatcher("/jsp/hazelab/setting.jsp").forward(request, response);
	}
}

