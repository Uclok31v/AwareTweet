package controller;

import dao.UserDAO;

public class SettingManager {

	public SettingManager(){

	}

	public void apdateUserNamePassById(String userId, String userName,
			String password) {

		UserDAO userDAO = new UserDAO();
		userDAO.updateUserNamePassById(userId, userName, password);
	}

}
