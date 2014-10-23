package com.mongo.mobile.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;

@Service
public class UserBoImpl implements UserBo {

	@Autowired
	private UserDao userDao;

	public void insert(User entity) {
		userDao.insert(entity);
	}
}
