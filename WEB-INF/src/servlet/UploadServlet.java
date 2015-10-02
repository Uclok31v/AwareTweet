package servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

public class UploadServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8");
		
		//保持されているユーザー情報を取得する
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUser_id();
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
		    List<FileItem> list = upload.parseRequest(request);
		    Iterator<FileItem> iterator = list.iterator();

		    while(iterator.hasNext()){
		      FileItem fileItem = (FileItem)iterator.next();
		      
		      if (!fileItem.isFormField()){
		          String fileName = fileItem.getName();

		          if ((fileName != null) && (!fileName.equals(""))){
		            System.out.println("ok");
		          }
		      }
		    }

		  }catch (FileUploadException e) {
		    e.printStackTrace();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
}
