package com.mongo.mobile.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
			user.setId(null);
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
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	@ResponseBody
	public ServiceMessage update(User user) {
		ServiceMessage message = null;
		try {
			userBo.update(user);
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
	
	@RequestMapping(value = "/user/edit")
	public String edit(Model model) {
		return "manage/user-edit";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		User user = userBo.getById(id);
		model.addAttribute("user", user);
		return "manage/user-edit";
	}
	
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, Model model) {
		userBo.delete(id);
		return "redirect:users";
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
