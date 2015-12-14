package beans;

public class User {

	//  属性
	private String user_id = null;		           //利用者ID
	private String user_name = null;			//利用者名
	private String user_password = null;  //利用者パスワード
	private String avator_path = null;




	//初期値を持たないコンストラクタ
	public User(){
	}


	//初期値を持ったコンストラクタ
	public User(String user_id, String user_name, String user_password, String avator_path) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.avator_path = avator_path;
	}


	//getterメソッド
	public String getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_password() {
		return user_password;
	}


	// setterメソッド
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getAvator_path() {
		return avator_path;
	}


	public void setAvator_path(String avator_path) {
		this.avator_path = avator_path;
	}


}
