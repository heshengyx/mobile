package com.mongo.mobile.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.mongo.mobile.dao.MongodbBaseDao;
import com.mongo.mobile.dao.UserDao;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

@Repository
public class UserDaoImpl extends MongodbBaseDao<User> implements UserDao {

	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

	public User save(User entity) {
		return saveEntity(entity);
	}

	public Pagination<User> list(UserQueryParam param, int pageNo, int pageSize) {
		Query query = new Query();
		String name = param.getName();
		if (!StringUtils.isEmpty(name)) {
			Criteria criteria = Criteria.where("name").regex("^" + name);
			query.addCriteria(criteria);
		}
		return getPage(pageNo, pageSize, query);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public User getById(String id) {
		return findById(id);
	}

	public User delete(String id) {
		return findAndRemove(new Query(Criteria.where("id").is(id)));
	}

	public void update(User entity) {
		Update update = new Update();
		if (!StringUtils.isEmpty(entity.getName())) {
			update.set("name", entity.getName());
		}
		updateFirst(new Query(Criteria.where("id").is(entity.getId())), update);
	}
}