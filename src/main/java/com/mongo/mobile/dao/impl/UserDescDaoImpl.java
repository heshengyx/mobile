package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.dao.UserDescDao;
import com.mongo.mobile.entity.UserDesc;

@Repository
public class UserDescDaoImpl extends MongodbBaseDao<UserDesc> implements UserDescDao {

	public UserDesc save(UserDesc entity) {
		return saveEntity(entity);
	}

	@Override
	protected Class<UserDesc> getEntityClass() {
		return UserDesc.class;
	}

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

}
