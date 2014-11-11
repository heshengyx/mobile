package com.mongo.mobile.bo;

import com.mongo.mobile.entity.Manager;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.ManagerQueryParam;

public interface ManagerBo {

	Manager save(Manager entity);	
	Pagination<Manager> list(ManagerQueryParam param, int pageNo, int pageSize);
}
