package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.TweetDAO;

public class GetTweetManager {

	private Connection connection = null;

	public GetTweetManager() {
	}
	public ArrayList GetList() {

		TweetDAO dao = new TweetDAO();

		this.connection = dao.createConnection();

		ArrayList list = dao.GetList(this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return list;
	}

}
