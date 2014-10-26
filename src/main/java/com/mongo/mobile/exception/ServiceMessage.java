package com.mongo.mobile.exception;

public class ServiceMessage {

	public static final String SUCCESS = "200";
	public static final String ERROR = "500";
	public static final String FAIL = "400";
	
	public String code;
	public String message;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
