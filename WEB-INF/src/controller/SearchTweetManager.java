package controller;

import java.util.ArrayList;

import beans.Tweet;
import dao.TweetDAO;

public class SearchTweetManager {


	public SearchTweetManager() {

	}

	public ArrayList<Tweet> selectTweetByComment(String searchWord) {

		ArrayList<Tweet> list = new TweetDAO().selectTweetByComment(searchWord);

		return list;
	}


}
