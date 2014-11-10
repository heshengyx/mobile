package com.mongo.mobile.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * π‹¿Ì‘±
 * @author 608279
 *
 */
@Document(collection = "manager")
public class Manager {

	@Id
	private String id;
}
