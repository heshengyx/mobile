package com.mongo.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongo.mobile.bo.UserBo;
import com.mongo.mobile.entity.User;
import com.mongo.mobile.exception.ServiceException;
import com.mongo.mobile.page.Pagination;
import com.mongo.mobile.param.UserQueryParam;

@Controller
@RequestMapping("/manage")
public class UserManageController extends BaseController {

	private static Logger logger = Logger.getLogger(UserManageController.class);

	@Autowired
	private UserBo userBo;

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(User user) {
		boolean flag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userBo.insert(user);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}

	@RequestMapping("/user/edit")
	public String edit(Model model) {
		return "manage/user-edit";
	}

	@RequestMapping("/users")
	public String list(UserQueryParam param,
			@RequestParam(required = false, defaultValue = "1") int page,
			Model model) {
		Pagination<User> users = userBo.list(param, page, 15);
		System.out.println(users);
		return "manage/user-list";
	}
}
