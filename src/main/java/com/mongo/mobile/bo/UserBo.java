package com.mongo.mobile.bo;

import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

public interface UserBo {

	User save(User entity);
	Pagination<User> list(UserQueryParam param, int pageNo, int pageSize);
}
