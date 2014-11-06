package com.mongo.mobile.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.mobile.bo.UserBo;

public class UserTest extends BaseSpringTest {

	@Autowired
	private UserBo userBo;
	
	@Test
	public void testFind() {
		System.out.print("================");
	}
}
