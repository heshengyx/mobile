package com.mongo.mobile.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongo.mobile.dao.AuthorityRoleDao;
import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.entity.AuthorityRole;
import com.mongo.mobile.param.AuthorityRoleQueryParam;

@Repository
public class AuthorityRoleDaoImpl extends MongodbBaseDao<AuthorityRole> implements AuthorityRoleDao {

	@Override
	protected Class<AuthorityRole> getEntityClass() {
		return AuthorityRole.class;
	}

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

	public AuthorityRole save(AuthorityRole entity) {
		return saveEntity(entity);
	}

	public List<AuthorityRole> list(AuthorityRoleQueryParam param) {
		Query query = new Query();
		return find(query);
	}

}
