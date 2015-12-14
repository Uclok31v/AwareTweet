package controller;

import java.sql.Connection;
import java.util.ArrayList;

import beans.Tweet;
import dao.TweetDAO;

public class GetUserTweetManager {
	
	private Connection connection = null;

	public GetUserTweetManager() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Tweet> selectTweetbyCommenter(String commenter) {
		// TODO Auto-generated method stub
		TweetDAO dao = new TweetDAO();

		this.connection = dao.createConnection();

		ArrayList<Tweet> list = dao.selectTweetbyCommenter(commenter, connection);

		dao.closeConnection(this.connection);

		this.connection = null;
		
		return list;
	}
		
	
}
