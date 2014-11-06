package com.mongo.mobile.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.mobile.bo.UserDescBo;
import com.mongo.mobile.dao.UserDescDao;
import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserDescQueryParam;

@Service
public class UserDescBoImpl implements UserDescBo {

	@Autowired
	private UserDescDao userDescDao;
	
	public UserDesc save(UserDesc entity) {
		return userDescDao.save(entity);
	}

	public Pagination<UserDesc> list(UserDescQueryParam param, int pageNo,
			int pageSize) {
		return userDescDao.list(param, pageNo, pageSize);
	}

}
