package com.test.service;

import com.test.dao.userDao;
import com.test.entity.userEntity;

public class userService {
	public userEntity findByuserName(String userName,String passWord) {
		userDao userdao = new userDao();
		return userdao.findByuserName(userName, passWord);
	}
	
	
	public void Zhuce(userEntity users ){
		userDao userdao=new userDao();
		userdao.Zhuce(users);
		
	}
}
