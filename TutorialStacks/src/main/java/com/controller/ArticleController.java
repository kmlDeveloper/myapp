package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.AdminService;
import com.service.MainService;

@Controller
@RequestMapping(value = "/article*.htm")
public class ArticleController {

	@Autowired
	private MainService mainService;

	@Autowired
	private AdminService adminService;

	@RequestMapping("read-more.htm")
	public ModelAndView viewArticale(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog", mainService
				.getBlogHomeData(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1)));
		mv.addObject("menuList", mainService.getMenuList(1L));
		mv.setViewName("read.more");
		return mv;
	}

	@RequestMapping("article-home.htm")
	public String articleHome(HttpServletRequest request, HttpServletResponse response, Model m) {
		m.addAttribute("articleList", adminService.getArticleHomeData("0"));
		m.addAttribute("recentArticle", adminService.getRecentArticle());
		return "article.home";
	}

}
