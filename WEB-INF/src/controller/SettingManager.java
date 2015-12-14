package controller;

import dao.UserDAO;

public class SettingManager {

	public SettingManager(){

	}

	public void apdateUserNamePassById(String userId, String userName,
			String password) {

		new UserDAO().updateUserNamePassById(userId, userName, password);
	}

}
