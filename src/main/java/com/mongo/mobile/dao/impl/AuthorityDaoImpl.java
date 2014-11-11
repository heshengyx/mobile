package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongo.mobile.dao.AuthorityDao;
import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.entity.Authority;

@Repository
public class AuthorityDaoImpl extends MongodbBaseDao<Authority> implements AuthorityDao {

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

	@Override
	protected Class<Authority> getEntityClass() {
		return Authority.class;
	}

	public Authority save(Authority entity) {
		return saveEntity(entity);
	}
}
