package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList GetList(Connection connection){

		try{
			String sql="select * from awaretweet";

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();

			//登録されている日記の数だけ繰り返す
			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setPresenter( rs.getString("presenter") );
			tweet.setComment( rs.getString("comment") );
			list.add(tweet);
			}

			stmt.close();
			rs.close();

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

	    }finally{
		    }
	}


}