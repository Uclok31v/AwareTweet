package controller;

import dao.UserDAO;

public class AddUserManager {

	public AddUserManager(){

	}

	public void insertUser(String userId, String userName, String password) {

		new UserDAO().insertUser(userId,userName,password);

	}

}
