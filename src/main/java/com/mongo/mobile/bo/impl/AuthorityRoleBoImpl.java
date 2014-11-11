package com.mongo.mobile.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.mobile.bo.AuthorityRoleBo;
import com.mongo.mobile.dao.AuthorityRoleDao;
import com.mongo.mobile.entity.AuthorityRole;

@Service
public class AuthorityRoleBoImpl implements AuthorityRoleBo {

	@Autowired 
	private AuthorityRoleDao authorityRoleDao;
	
	public AuthorityRole save(AuthorityRole entity) {
		return authorityRoleDao.save(entity);
	}

}
