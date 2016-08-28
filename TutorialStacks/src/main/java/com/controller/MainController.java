package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.AdminService;

@Controller
public class MainController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("home.htm")
	public String goToHome(Model m) {
		m.addAttribute("articleList", adminService.getArticleHomeData("1"));
		m.addAttribute("recentArticle", adminService.getRecentArticle());
		return "home";
	}

}
