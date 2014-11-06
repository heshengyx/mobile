package com.mongo.mobile.dao;

import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserDescQueryParam;

public interface UserDescDao {

	UserDesc save(UserDesc entity);
	Pagination<UserDesc> list(UserDescQueryParam param, int pageNo, int pageSize);
}
