package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DriverAccessor;
import utility.PasswordEncryption;
import beans.User;

public class UserDAO extends DriverAccessor{


	public void insertUserRoot(){

		Connection con = null;
		con = createConnection();
		try{
			String sql="insert into profile values (?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1,"root");
			stmt.setString(2, "root");
			PasswordEncryption passenc = new PasswordEncryption();
    		String password = passenc.getPassword_encryption("root");
    		stmt.setString(3, password);

			stmt.executeUpdate();

			stmt.close();
			con = null;

		}catch(SQLException e){

		}finally{

		}
	}

	public User selectUserByIdPass(String userId, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{

			String sql="select * from profile where id = (?) and password = (?) ";

			//PreparedStatementの利用
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,userId);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();

			rs.first();

			User user = new User();
			user.setUser_id(rs.getString("id"));
			user.setUser_name(rs.getString("name"));
			user.setUser_password(rs.getString("password"));

			stmt.close();
			rs.close();
			con = null;

			return user;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{

		}
	}

	public void insertUser(String userId, String userName, String password) {
		Connection con = null;
		con = createConnection();
		try{
			String sql="insert into profile values (?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1,userId);
			stmt.setString(2,userName);
			stmt.setString(3,password);
			stmt.executeUpdate();

			stmt.close();
			con = null;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{

		}

	}

	public int selectCountByRoot(String root) {

		Connection con = null;
		con = createConnection();

		try{
			String sql = "select count(1) from profile where id = ?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, root);

			ResultSet rs=stmt.executeQuery();
			rs.first();

			int count = rs.getInt("count(1)");

			stmt.close();
			rs.close();
			con = null;
			return count;
		}catch(SQLException e){
			e.printStackTrace();
			//0だとcount(1)とかぶる
			return 2;
		}finally{

		}

	}


}
