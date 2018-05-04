package com.ctgu.qmx.service;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.daoimpl.UserDaoImpl;

public class UserService {
	UserDaoImpl userDaoImpl;

	public UserService() {
		userDaoImpl = new UserDaoImpl();
	}
	public boolean userLogin(String username, String password) {
		User user = userDaoImpl.findByName(username);
		if (null != user && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public boolean userRegister(User user) {
		if (userDaoImpl.doInsert(user)) {
			return true;
		}
		return false;
	}
	public User findUser(String username){
		return userDaoImpl.findByName(username);
	}
	public boolean userUpdate(User user){
		if(userDaoImpl.doUpdate(user)){
			return true;
		}
		return false;
		
	}
}
