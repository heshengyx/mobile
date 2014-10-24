package com.mongo.mobile.dao;

import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

public interface UserDao {

	void insert(User entity);
	Pagination<User> list(UserQueryParam param, int pageNo, int pageSize);
}
