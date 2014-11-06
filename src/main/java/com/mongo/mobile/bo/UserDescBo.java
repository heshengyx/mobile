package com.mongo.mobile.bo;

import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserDescQueryParam;

public interface UserDescBo {

	UserDesc save(UserDesc entity);
	Pagination<UserDesc> list(UserDescQueryParam param, int pageNo, int pageSize);
}
