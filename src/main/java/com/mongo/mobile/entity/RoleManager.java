package com.mongo.mobile.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ��ɫ
 * @author 608279
 *
 */
@Document(collection = "role_manager")
public class RoleManager {

	@Id
	private String id;
}
