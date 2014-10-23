package com.mongo.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class IndexManageController extends BaseController {

	@RequestMapping("/index")
	public String list(Model model) {
		return "manage/index";
	}
}
