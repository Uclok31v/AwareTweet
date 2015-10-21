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
import utility.WindowsUnzipComponent;
import beans.User;

public class RegistWindowsSlideServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		String comment=request.getParameter("os");
		System.out.println(comment);
		//保持されているユーザー情報を取得する
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUser_id();

		//iterator用のintとos判別用のos
		int i=0;
		String os=null;

		//hostによって異なるパス
		HostPathComponent createHostPath = new HostPathComponent();
		String hostPath = createHostPath.createHostPath();
		File path = new File(hostPath + "AwareTweet/slide/"+userId);

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
		            fileItem.write(new File(path + "/" + fileName));
		            WindowsUnzipComponent unzip = new WindowsUnzipComponent();
		            unzip.unzip(userId, path + "/" + fileName, hostPath + "AwareTweet/slide/"+userId);
		            i++;
		          }
		      }
		      else if(i==1){
		        	os=fileItem.getString();
		        	byte[] bytes= os.getBytes("iso-8859-1");
		    		os = new String(bytes, "utf-8");
		        	i++;
		        }
		    }

		  }catch (FileUploadException e) {
		    e.printStackTrace();
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		session.setAttribute("user",user);
		System.out.println(os);
		getServletContext().getRequestDispatcher("/jsp/hazelab/MoveTopServlet").forward(request, response);
	}

}
