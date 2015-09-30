package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DriverAccessor_Hazelab;
import beans.User;

public class UserDAO extends DriverAccessor_Hazelab{

	public User selectUserByIdPass(String userId, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{
			
			String sql="select * from user where user_id = (?) and password = (?) ";
			
			//PreparedStatementの利用
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,userId);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();
			
			rs.first();
			
			User user = new User();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
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

}
