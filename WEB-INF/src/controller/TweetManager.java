package controller;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Calendar;

import beans.Tweet;
import dao.TweetDAO;

public class TweetManager{

	private Connection connection = null;

	public TweetManager(){
	}

	public void Tweet(String commenter,String presenter,String comment){

		DecimalFormat decimal =new DecimalFormat("00");
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));
		String hour = decimal.format(cal.get(Calendar.HOUR_OF_DAY));
		String minute = decimal.format(cal.get(Calendar.MINUTE));
		String second = decimal.format(cal.get(Calendar.SECOND));
		String date=year+"/"+month+"/"+day+"-"+hour+":"+minute+":"+second;

		Tweet tweet = new Tweet();
		tweet.setDate(date);
		tweet.setCommenter(commenter);
		tweet.setPresenter(presenter);
		tweet.setComment(comment);

		TweetDAO dao = new TweetDAO();
		this.connection = dao.createConnection();

		dao.Tweet(tweet, this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;
	}

}