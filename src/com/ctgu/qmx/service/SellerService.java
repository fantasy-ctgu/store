package com.ctgu.qmx.service;

import com.ctgu.qmx.bean.User;
import com.ctgu.qmx.daoimpl.SellerDaoImpl;

public class SellerService {
	SellerDaoImpl sellerDaoImpl;

	public SellerService() {
		sellerDaoImpl = new SellerDaoImpl();
	}
	public boolean sellerLogin(String username, String password) {
		User user = sellerDaoImpl.findByName(username);
		if (null != user && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public boolean sellerRegister(User user) {
		if (sellerDaoImpl.doInsert(user)) {
			return true;
		}
		return false;
	}
	public User findSeller(String username){
		return sellerDaoImpl.findByName(username);
	}
	public boolean sellerUpdate(User user){
		if(sellerDaoImpl.doUpdate(user)){
			return true;
		}
		return false;
		
	}
}
