package com.mongo.mobile.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userDesc")
public class UserDesc {

	@Id
	private String id;
	private String desc;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return String.format("UserDesc[id=%s, desc='%s']", id, desc);
	}
}
