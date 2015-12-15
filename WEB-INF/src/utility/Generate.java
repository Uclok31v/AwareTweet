package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

//		String home = System.getenv("HOME");
    	String home = "C:/Users/tanese kenta";
    	File homeDir = new File(home + "/.awaretweet");


    	String appRootPath =  new PropertiesComponent().referProperties("appRootPath");

    	if(homeDir.exists()){
    		//nothing to do
    	}
    	else{
    		homeDir.mkdir();
    		//create symboliclink of avator and slide dir, and conf;
    		createConf(home,homeDir,appRootPath,"avator");
    		createConf(home, homeDir, appRootPath, "slide");
    		createConf(home, homeDir, appRootPath, "awaretweet.conf");

    	}
    }

	private void createConf(String home, File homeDir, String appRootPath,
			String kind) {

		if(kind.equals("avator") || kind.equals("slide")){
			File target = new File(appRootPath + kind);
			if(!(target.exists())){
				target.mkdir();
			}
		}else{
			try{
				Files.createSymbolicLink(Paths.get(homeDir + "/" + kind),Paths.get(home + "/" + kind));
			}catch (IOException e) {

				e.printStackTrace();
			}

		}


	}


}
