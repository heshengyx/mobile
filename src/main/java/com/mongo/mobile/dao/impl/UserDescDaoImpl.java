package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.dao.UserDescDao;
import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserDescQueryParam;

@Repository
public class UserDescDaoImpl extends MongodbBaseDao<UserDesc> implements UserDescDao {

	@Override
	protected Class<UserDesc> getEntityClass() {
		return UserDesc.class;
	}

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}
	
	public UserDesc save(UserDesc entity) {
		return saveEntity(entity);
	}

	public Pagination<UserDesc> list(UserDescQueryParam param, int pageNo,
			int pageSize) {
		Query query = new Query();
		String desc = param.getDesc();
		if (!StringUtils.isEmpty(desc)) {
			Criteria criteria = Criteria.where("desc").regex("^" + desc);
			query.addCriteria(criteria);
		}
		return getPage(pageNo, pageSize, query);
	}

}
