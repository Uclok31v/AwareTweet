package controller;

import java.sql.Connection;
import java.util.ArrayList;

import beans.Tweet;
import dao.TweetDAO;

public class GetUserTweetManager {


	public GetUserTweetManager() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Tweet> selectTweetbyCommenter(String commenter) {

		ArrayList<Tweet> list = new TweetDAO().selectTweetbyCommenter(commenter);

		return list;
	}


}
