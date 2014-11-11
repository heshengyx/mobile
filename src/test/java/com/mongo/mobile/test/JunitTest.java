package com.mongo.mobile.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongo.mobile.bo.ManagerBo;
import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.bo.UserDescBo;
import com.mongo.mobile.entity.Manager;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.entity.UserDesc;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.ManagerQueryParam;
import com.mongo.mobile.param.UserDescQueryParam;
import com.mongo.mobile.param.UserQueryParam;
import com.mongo.mobile.util.DateUtil;

public class JunitTest {

	private ApplicationContext ac;
	private UserBo userBo;
	private UserDescBo userDescBo;
	private ManagerBo managerBo;
	
	@Before 
    public void setUp() throws Exception { 
        ac = new ClassPathXmlApplicationContext("application-mongo.xml");
        userBo = ac.getAutowireCapableBeanFactory().getBean(UserBo.class);
        userDescBo = ac.getAutowireCapableBeanFactory().getBean(UserDescBo.class);
        managerBo = ac.getAutowireCapableBeanFactory().getBean(ManagerBo.class);
    }
	
	@Test
	public void testSaveManager() {
		try {
			Manager manager = new Manager();
			manager.setName("admin");
			manager.setStatus("1");
			managerBo.save(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfindManager() {
		try {
			ManagerQueryParam param = new ManagerQueryParam();
			Pagination<Manager> managerPage = managerBo.list(param, 1, 100);
			List<Manager> managers = managerPage.getDatas();
			for (Manager manager : managers) {
				System.out.println("Name=" + manager.getName() + ",Date=" + DateUtil.getDate(manager.getCreateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSave() {
		System.out.println("save1================");
		try {
			User user = new User();
			user.setName("zhangsan");
			user = userBo.save(user);
			System.out.println("user================" + user.getId());
			UserDesc desc1 = new UserDesc();
			desc1.setDesc("desc1");
			desc1.setUserId(user.getId());
			userDescBo.save(desc1);
			System.out.println("desc1================" + desc1.getId());
			
			UserDesc desc2 = new UserDesc();
			desc2.setDesc("desc2");
			desc2.setUserId(user.getId());
			userDescBo.save(desc2);
			System.out.println("desc2================" + desc2.getId());
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
			
			UserDescQueryParam _param = new UserDescQueryParam();
			_param.setUserId(u.getId());
			Pagination<UserDesc> userDesc = userDescBo.list(_param, 1, 100);
			List<UserDesc> userDescs = userDesc.getDatas();
			
			for (UserDesc desc : userDescs) {
				System.out.println("Id=" + desc.getId() + ",Desc=" + desc.getDesc());
			}
		}
		System.out.println("find2================");
	}
}
