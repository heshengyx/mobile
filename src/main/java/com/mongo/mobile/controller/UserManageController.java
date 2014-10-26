package com.mongo.mobile.controller;

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
import com.mongo.mobile.exception.ServiceMessage;
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
	public ServiceMessage save(User user) {
		ServiceMessage message = null;
		try {
			user = userBo.save(user);
			message = new ServiceMessage(ServiceMessage.SUCCESS, "保存成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			message = new ServiceMessage(ServiceMessage.ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			message = new ServiceMessage(ServiceMessage.ERROR, "系统异常");
		}
		return message;
	}

	@RequestMapping("/user/edit")
	public String edit(Model model) {
		return "manage/user-edit";
	}

	@RequestMapping("/users")
	public String list(UserQueryParam param,
			@RequestParam(required = false, defaultValue = "1") int page,
			Model model) {
		Pagination<User> users = userBo.list(param, page, 2);
		model.addAttribute("users", users);
		model.addAttribute("param", param);
		return "manage/user-list";
	}
}
