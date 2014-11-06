package com.mongo.mobile.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.bo.UserDescBo;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

public class JunitTest {

	private ApplicationContext ac;
	private UserBo userBo;
	private UserDescBo userDescBo;
	
	@Before 
    public void setUp() throws Exception { 
        ac = new ClassPathXmlApplicationContext("application-mongo.xml");
        userBo = ac.getAutowireCapableBeanFactory().getBean(UserBo.class);
        userDescBo = ac.getAutowireCapableBeanFactory().getBean(UserDescBo.class);
    }
	
	@Test
	public void testSave() {
		System.out.println("save1================");
		try {
			User user = new User();
			user.setName("zhangsan");
			
			List<UserDesc> userDescs = new ArrayList<UserDesc>();
			UserDesc desc1 = new UserDesc();
			desc1.setDesc("desc1");
			userDescs.add(desc1);
			userDescBo.save(desc1);
			
			UserDesc desc2 = new UserDesc();
			desc2.setDesc("desc2");
			userDescs.add(desc2);
			userDescBo.save(desc2);
			
			user.setUserDescs(userDescs);
			userBo.save(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("save2================");
	}
	
	@Test
	public void testFind() {
		System.out.println("find1================");
		UserQueryParam param = new UserQueryParam();
		Pagination<User> user = userBo.list(param, 1, 2);
		List<User> users = user.getDatas();
		for (User u : users) {
			System.out.println("Id=" + u.getId() + ",Name=" + u.getName());
			List<UserDesc> userDescs = u.getUserDescs();
			for (UserDesc d : userDescs) {
				System.out.println("Id=" + d.getId() + ",Desc=" + d.getDesc());
			}
		}
		System.out.println("find2================");
	}
}
