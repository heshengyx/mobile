package com.mongo.mobile.util;

public class StringUtil {

	public static String getMethodName(String field) {
        return "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }
	
	public static String setMethodName(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }
}
