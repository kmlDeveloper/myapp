package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.MainService;

@Controller
@RequestMapping(value = "/html*.htm")
public class HtmlBlogController {

	@Autowired
	private MainService mainService;

	@RequestMapping("html-home.htm")
	public ModelAndView htmlHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog", mainService
				.getBlogHomeData(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1)));
		mv.addObject("menuList", mainService.getMenuList(2L));
		mv.setViewName("html.home");
		return mv;
	}

	@RequestMapping("try-html.htm")
	public ModelAndView tryHtml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog", mainService
				.getBlogHomeData(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1)));
		mv.addObject("menuList", mainService.getMenuList(2L));
		mv.setViewName("try.html");
		return mv;
	}

}
