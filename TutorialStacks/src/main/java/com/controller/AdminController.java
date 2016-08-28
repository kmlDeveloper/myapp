package com.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.AdminService;
import com.table.TblMainTopics;
import com.table.TblSubTopics;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("login.htm")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userId") != null) {
			return "main.topics";
		} else {
			return "login";
		}

	}

	@RequestMapping("verifyAdmin.htm")
	public String verifyAdmin(HttpServletRequest request, HttpServletResponse response, Model m) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String result = "fail";
		List<Object[]> user = adminService.verifyAdmin(userName, password);
		if (user != null && !user.isEmpty() && user.get(0) != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.get(0)[0].toString());
			session.setAttribute("userName", user.get(0)[1].toString());
			result = "main.topics";
		}
		return result;
	}

	@RequestMapping("admin.logout.htm")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "home";
	}

	@RequestMapping("addMainTopics.htm")
	public String addMainTopics(HttpServletRequest request, HttpServletResponse response, Model m) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", request.getParameter("id"));
		map.put("mainTopics", request.getParameter("mainTopics"));
		String result = adminService.addMainTopics(map);
		return result;
	}

	@RequestMapping("main.topics.htm")
	public String showMainTopics(Model m) {
		m.addAttribute("mainTopicList", adminService.getMainTopicsGridData());
		return "main.topics";
	}

	@RequestMapping("sub.topics.htm")
	public String showSubTopics(Model m) {
		m.addAttribute("mainTopicMap", adminService.getMainTopicsList());
		return "sub.topics";
	}

	@RequestMapping("addSubTopics.htm")
	public String addSubTopics(HttpServletRequest request, HttpServletResponse response, Model m) {
		HttpSession session = request.getSession(true);
		String id = (String) session.getAttribute("userId");

		TblSubTopics tblSubTopics = new TblSubTopics();
		tblSubTopics.setSubTopics(request.getParameter("subTopics"));

		TblMainTopics tblMainTopics = new TblMainTopics();
		tblMainTopics.setId(Long.valueOf(request.getParameter("mainTopicId")));
		tblSubTopics.setTblMainTopics(tblMainTopics);

		tblSubTopics.setCreatedDate(new Date());
		String result = adminService.addSubTopics(tblSubTopics);
		return result;
	}

	@RequestMapping("topics.htm")
	public String showTopics(Model m) {
		m.addAttribute("mainTopicMap", adminService.getMainTopicsList());
		m.addAttribute("subTopicMap", adminService.getSubTopicsList());
		m.addAttribute("topicList", adminService.getTopicGridData());

		return "topics";
	}

	@RequestMapping("addTopics.htm")
	public String addTopics(HttpServletRequest request, HttpServletResponse response, Model m) {

		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", request.getParameter("id"));
		map.put("title", request.getParameter("title"));
		map.put("description", request.getParameter("description"));
		map.put("mainTopicId", request.getParameter("mainTopicId"));
		map.put("topicUrl", request.getParameter("topicUrl"));
		map.put("orderNo", request.getParameter("orderNo"));
		String result = adminService.addTopics(map);
		return result;
	}

	@RequestMapping("addArticle.htm")
	public String addNews(HttpServletRequest request, HttpServletResponse response, Model m) {

		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", request.getParameter("id"));
		map.put("title", request.getParameter("title"));
		map.put("article", request.getParameter("article"));
		map.put("orderNo", request.getParameter("orderNo"));
		String result = adminService.addArticle(map);
		return result;
	}

	@RequestMapping("article.htm")
	public String articleHome(HttpServletRequest request, HttpServletResponse response, Model m) {
		m.addAttribute("articleList", adminService.getArticleGridData());
		return "article";
	}

}
