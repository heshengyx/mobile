package com.mongo.mobile.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	public static String getDate(Date date) {
		return DATE_FORMAT.format(date);
	}
	
	public static String getDateTime(Date date) {
		return DATE_TIME_FORMAT.format(date);
	}
}
