package com.mongo.mobile.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	private String id;
	private String name;
	
	@DBRef
	private List<UserDesc> userDescs;

	public List<UserDesc> getUserDescs() {
		return userDescs;
	}

	public void setUserDescs(List<UserDesc> userDescs) {
		this.userDescs = userDescs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, name='%s']", id, name);
	}
}
