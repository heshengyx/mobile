package com.mongo.mobile.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.exception.ServiceException;
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

	public User getById(String id) {
		return userDao.getById(id);
	}

	public User delete(String id) {
		return userDao.delete(id);
	}

	public void update(User entity) {
		if (StringUtils.isEmpty(entity.getId())) {
			throw new ServiceException("主键不能为空");
		}
		userDao.update(entity);
	}

	public List<User> list(UserQueryParam param) {
		return userDao.list(param);
	}
}
