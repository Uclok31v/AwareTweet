package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DriverAccessor;
import beans.Tweet;

public class TweetDAO extends DriverAccessor{

	public void Tweet(Tweet tweet,Connection connection){

		try{
			String sql = "insert into awaretweet(date,commenter,presenter,comment) values(?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,tweet.getDate());
			stmt.setString(2,tweet.getCommenter());
			stmt.setString(3,tweet.getPresenter());
			stmt.setString(4,tweet.getComment());
			stmt.executeUpdate();

			stmt.close();

		}catch(SQLException e){

			e.printStackTrace();

		} finally {
	}
	}

}