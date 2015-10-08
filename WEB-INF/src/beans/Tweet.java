package beans;

public class Tweet{
	

	private String date = null;
	private String commenter = null;
	private String comment = null;
	private String avator_path = null;
	
	public Tweet(){
		
	}

	public Tweet(String date, String commenter, String comment,
			String avator_path) {
		this.date = date;
		this.commenter = commenter;
		this.comment = comment;
		this.avator_path = avator_path;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAvator_path() {
		return avator_path;
	}

	public void setAvator_path(String avator_path) {
		this.avator_path = avator_path;
	}
	
	
}
