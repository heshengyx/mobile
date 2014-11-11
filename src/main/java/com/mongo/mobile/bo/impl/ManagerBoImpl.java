package com.mongo.mobile.bo.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.mobile.bo.ManagerBo;
import com.mongo.mobile.dao.ManagerDao;
import com.mongo.mobile.entity.Manager;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.ManagerQueryParam;

@Service
public class ManagerBoImpl implements ManagerBo {

	@Autowired 
	private ManagerDao managerDao;
	
	public Manager save(Manager entity) {
		entity.setCreateTime(new Date());
		return managerDao.save(entity);
	}

	public Pagination<Manager> list(ManagerQueryParam param, int pageNo,
			int pageSize) {
		return managerDao.list(param, pageNo, pageSize);
	}

}
