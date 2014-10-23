package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired  
    private MongoTemplate mongoTemplate;
	
	public void insert(User entity) {
		mongoTemplate.insert(entity);
	}

}