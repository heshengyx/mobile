package com.mongo.mobile.dao;

import java.util.List;

import com.mongo.mobile.entity.AuthorityRole;
import com.mongo.mobile.param.AuthorityRoleQueryParam;

public interface AuthorityRoleDao {

	AuthorityRole save(AuthorityRole entity);
	List<AuthorityRole> list(AuthorityRoleQueryParam param);
}
