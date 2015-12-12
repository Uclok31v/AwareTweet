package controller;

import dao.UserDAO;

public class AddUserManager {

	public AddUserManager(){

	}

	public void insertUser(String userId, String userName, String password) {
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(userId,userName,password);

	}

}
