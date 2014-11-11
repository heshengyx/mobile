package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mongo.mobile.dao.ManagerDao;
import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.entity.Manager;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.ManagerQueryParam;

@Repository
public class ManagerDaoImpl extends MongodbBaseDao<Manager> implements ManagerDao {

	@Override
	protected Class<Manager> getEntityClass() {
		return Manager.class;
	}

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

	public Manager save(Manager entity) {
		return saveEntity(entity);
	}

	public Pagination<Manager> list(ManagerQueryParam param, int pageNo,
			int pageSize) {
		Query query = new Query();
		String name = param.getName();
		if (!StringUtils.isEmpty(name)) {
			Criteria criteria = Criteria.where("name").regex("^" + name);
			query.addCriteria(criteria);
		}
		return getPage(pageNo, pageSize, query);
	}

}
