package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Statement;

import utility.DriverAccessor;
import beans.Tweet;

public class TweetDAO extends DriverAccessor{

	public void insertTweet(Tweet tweet){

		Connection con = null;
		con = createConnection();

		try{
			String sql = "insert into tweet(date,commenter,comment, avator_path) values(?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1,tweet.getDate());
			stmt.setString(2,tweet.getCommenter());
			stmt.setString(3,tweet.getComment());
			stmt.setString(4, tweet.getAvator_path());
			stmt.executeUpdate();

			stmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		} finally {

		}
    }

	public ArrayList<Tweet> selectTweet(){
		Connection con = null;
		con = createConnection();
		try{
			String sql="select * from tweet order by date desc";

			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs=stmt.executeQuery();

			ArrayList<Tweet> list = new ArrayList<Tweet>();

			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			tweet.setAvator_path(rs.getString("avator_path"));
			list.add(tweet);
			}

			stmt.close();
			rs.close();
			con = null;

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

	    }finally{
		    }
	}

	public ArrayList<Tweet> selectTweetbyCommenter(String commenter) {

		Connection con = null;
		con = createConnection();
		try{
			String sql="select * from tweet where commenter = ? order by date desc";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1,commenter);

			ResultSet rs=stmt.executeQuery();

			ArrayList<Tweet> list = new ArrayList<Tweet>();

			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			tweet.setAvator_path(rs.getString("avator_path"));
			list.add(tweet);
			}

			stmt.close();
			rs.close();
			con = null;

		    return list;

	    }catch(SQLException e){

		   e.printStackTrace();

		return null;

        }finally{
	        }
    }


	public ArrayList<Tweet> selectTweetbyUserIdandSlideName(String userId, String slideName) {

		Connection con = null;
		con = createConnection();
		try{
			String sql="select * from tweet where comment like '%@"+userId+"%' and comment like '%#"+slideName+"%' ";

			Statement stmt = con.createStatement();


			ResultSet rs=stmt.executeQuery(sql);

			ArrayList<Tweet> list = new ArrayList<Tweet>();

			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			tweet.setAvator_path(rs.getString("avator_path"));
			list.add(tweet);

			}

			stmt.close();
			rs.close();
			con = null;

		    return list;

	    }catch(SQLException e){

		   e.printStackTrace();

		return null;

        }finally{
	        }
	}

	public ArrayList<Tweet> selectTweetByComment(String searchWord){

		Connection con = null;
		con = createConnection();
		try{
			String sql ="select * from tweet where comment like '%"+searchWord+"%' ";

			Statement stmt = con.createStatement();

			ResultSet rs=stmt.executeQuery(sql);

			ArrayList<Tweet> list = new ArrayList<Tweet>();

			while(rs.next())
		    {
			Tweet tweet = new Tweet();
			tweet.setDate( rs.getString("date") );
			tweet.setCommenter( rs.getString("commenter") );
			tweet.setComment( rs.getString("comment") );
			tweet.setAvator_path(rs.getString("avator_path"));
			list.add(tweet);
			}

			stmt.close();
			rs.close();
			con = null;

		    return list;

	    }catch(SQLException e){

		   e.printStackTrace();

		return null;

        }finally{
	        }
	}


}
