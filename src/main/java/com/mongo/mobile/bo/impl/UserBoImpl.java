package com.mongo.mobile.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

@Service
public class UserBoImpl implements UserBo {

	@Autowired 
	private UserDao userDao;

	public User save(User entity) {
		return userDao.save(entity);
	}

	public Pagination<User> list(UserQueryParam param, int pageNo, int pageSize) {
		return userDao.list(param, pageNo, pageSize);
	}
}
