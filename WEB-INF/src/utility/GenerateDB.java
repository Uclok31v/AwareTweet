package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.UserDAO;


public class GenerateDB extends DriverAccessor{

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
}
