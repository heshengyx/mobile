package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

@Repository
public class UserDaoImpl extends MongodbBaseDao<User> implements UserDao {
	
	public void insert(User entity) {
		mongoTemplate.insert(entity);
	}

	public Pagination<User> list(UserQueryParam param, int pageNo, int pageSize) {
		Query query = new Query();
		return getPage(pageNo, pageSize, query);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

}