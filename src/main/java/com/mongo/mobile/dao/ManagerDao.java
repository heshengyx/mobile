package com.mongo.mobile.dao;

import com.mongo.mobile.entity.Manager;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.ManagerQueryParam;

public interface ManagerDao {

	Manager save(Manager entity);	
	Pagination<Manager> list(ManagerQueryParam param, int pageNo, int pageSize);
}
