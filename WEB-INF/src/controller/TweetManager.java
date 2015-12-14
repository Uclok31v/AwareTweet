package controller;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Calendar;

import beans.Tweet;
import dao.TweetDAO;

public class TweetManager{


	public TweetManager(){
	}

	public void insertTweet(String commenter,String comment, String avatorPath){

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
		tweet.setComment(comment);
		tweet.setAvator_path(avatorPath);

		new TweetDAO().insertTweet(tweet);

	}

}
