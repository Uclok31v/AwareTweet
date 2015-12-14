package controller;

import java.sql.Connection;
import java.util.ArrayList;

import beans.Tweet;
import dao.TweetDAO;

public class SearchTweetManager {

	private Connection connection = null;

	public SearchTweetManager() {

	}

	public ArrayList<Tweet> selectTweetByComment(String searchWord) {

		ArrayList<Tweet> list = new TweetDAO().selectTweetByComment(searchWord);

		return list;
	}


}
