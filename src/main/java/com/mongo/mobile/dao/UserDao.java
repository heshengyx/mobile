package com.mongo.mobile.dao;

import java.util.List;

import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

public interface UserDao {

	User save(User entity);	
	User getById(String id);
	User delete(String id);
	void update(User entity);
	
	List<User> list(UserQueryParam param);
	Pagination<User> list(UserQueryParam param, int pageNo, int pageSize);
}
