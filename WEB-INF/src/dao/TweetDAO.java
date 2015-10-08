package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Tweet;

public class TweetDAO extends DriverAccessor{

	public void insertTweet(Tweet tweet,Connection connection){

		try{
			String sql = "insert into tweet(date,commenter,comment) values(?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,tweet.getDate());
			stmt.setString(2,tweet.getCommenter());
			stmt.setString(3,tweet.getComment());
			stmt.executeUpdate();

			stmt.close();

		}catch(SQLException e){

			e.printStackTrace();

		} finally {
	         }
    }
	
	public ArrayList GetTweetList(){
		Connection connection = null;
		connection = createConnection();
		try{
			String sql="select * from tweet order by date desc";

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();

			//登録されている日記の数だけ繰り返す
			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			list.add(tweet);
			}

			stmt.close();
			rs.close();
			connection = null;

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

	    }finally{
		    }
	}

	public ArrayList GetUserTweetList(String commenter, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql="select * from tweet where commenter = ? order by date desc";

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,commenter);
			
			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();

			//登録されている日記の数だけ繰り返す
			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
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

	public ArrayList getSlideTweetList(String userId, String slideName,Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql="select * from tweet where comment like '%@"+userId+"%' and comment like '%#"+slideName+"%' ";

//			PreparedStatement stmt = connection.prepareStatement(sql);
//			
//			stmt.setString(1, userId);
//			stmt.setString(2, slideName);
			
			Statement stmt=connection.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);

			ArrayList list = new ArrayList();

			//登録されている日記の数だけ繰り返す
			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			System.out.println(tweet.getComment());
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