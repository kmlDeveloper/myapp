package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.MainService;

@Controller
@RequestMapping(value = "/java*.htm")
public class JavaBlogController {

	@Autowired
	private MainService mainService;

	@RequestMapping("java-*.htm")
	public ModelAndView learnJava(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String blogId = mainService
				.getBlogHomeData(request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/') + 1));
		if (blogId != null && !blogId.equals("")) {
			mv.addObject("blog", blogId);
			mv.addObject("menuList", mainService.getMenuList(1L));
			mv.setViewName("java.home");
		} else {
			mv.setViewName("error");
		}

		return mv;
	}

}
