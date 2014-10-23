package com.mongo.mobile.exception;

import org.springframework.dao.DataAccessException;

public class ServiceException extends DataAccessException {

	private static final long serialVersionUID = -5238711790666838085L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
