package utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import dao.UserDAO;


public class Generate extends DriverAccessor{

	public void createDB(){

		createUser();
		createIp_history();
		createTweet();

		String userId = "root";
        String userName = "root";
        String password = "root";

        PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);


		UserDAO userDAO = new UserDAO();
		//rootユーザがいるかチェック(有:1,無:0)
		int flag = userDAO.selectUserCountById(userId);

		if(flag == 0){
			userDAO.insertUser(userId, userName, password);
		}else{
			//何もしない(将来的に何か処理があるかもしれないから一応書いておく)
		}

	}

    private void createUser(){


        Connection con = null;
        con = createConnection();

        try {
            String sql = "create table if not exists user("
            		+ "id varchar(16) PRIMARY KEY NOT NULL,"
            		+ "name varchar(64) NOT NULL,"
            		+ "password text NOT NULL)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();
            con = null;
        }catch(SQLException e){


        }finally{

        }
    }

    private void createIp_history(){

        Connection con = null;
        con = createConnection();

        try {
            String sql = "create table  if not exists ip_history("
            		+ "ip varchar(40) PRIMARY KEY NOT NULL,"
            		+ "fail_count int(11) NOT NULL DEFAULT 0)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();
            con = null;
        }catch(SQLException e){


        }finally{

        }

    }

    private void createTweet(){

    	Connection con = null;
        con = createConnection();

        try {
            String sql = "create table  if not exists tweet("
            		+ "date varchar(40) AS CURRENT_TIMESTAMP,"
            		+ "commenter varchar(64) NOT NULL,"
            		+ "comment text NOT NULL,"
            		+ "avator_path varchar(255) DEFAULT NULL)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();
            con = null;
        }catch(SQLException e){


        }finally{

        }
    }

    public void createHomeDir(){

    	String home = System.getenv("HOME");
    	File baseHomeDir = new File(home + "/.awaretweet");

    	HostPathComponent hostPathComponent = new HostPathComponent();
    	String homeDir =  hostPathComponent.createHomePath();

    	if(baseHomeDir.exists()){
    		//nothing to do
    	}
    	else{
    		baseHomeDir.mkdir();
    		File avatorDir = new File(home + "/.awaretweet/avator");
    		File slideDir = new File(home + "/.awaretweet/slide");
    		if(!(avatorDir.exists())){
    			avatorDir.mkdir();
    			try {
					Path path = Files.createSymbolicLink(Paths.get(homeDir + "avator"), Paths.get(baseHomeDir +"/avator"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		if(!(slideDir.exists())){
    			slideDir.mkdir();
    			avatorDir.mkdir();
    			try {
					Path path = Files.createSymbolicLink(Paths.get(homeDir + "slide"), Paths.get(baseHomeDir +"/slide"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}


    	}
    }


}
