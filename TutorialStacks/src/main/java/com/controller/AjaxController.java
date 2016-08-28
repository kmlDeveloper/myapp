
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AdminService;
import com.service.MainService;

@Controller
public class AjaxController {

	@Autowired
	private MainService mainService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/get-searched-list", method = RequestMethod.GET)
	@ResponseBody
	public String getItem(HttpServletRequest request) {
		String result = mainService.getSearchedList(request.getParameter("term"));
		return result;
	}

	@RequestMapping(value = "/blog-data", method = RequestMethod.GET)
	@ResponseBody
	public String learnJava(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		if (request.getParameter("topicId") != null && !request.getParameter("topicId").equals("")) {
			result = mainService.getBlogData(Long.valueOf(request.getParameter("topicId")));
		}
		return result;
	}

	@RequestMapping(value = "/getMainTopicById", method = RequestMethod.GET)
	@ResponseBody
	public String getMainTopicById(HttpServletRequest request, HttpServletResponse response, Model m) {
		JSONObject json = new JSONObject();
		Object[] returnData = adminService.getMainTopicsDataById(Long.valueOf(request.getParameter("id")));
		if (returnData != null) {
			json.put("id", returnData[0].toString());
			json.put("mainTopic", returnData[1].toString());
		}
		return json.toString();
	}

	@RequestMapping(value = "/get-topic-data-by-id", method = RequestMethod.GET)
	@ResponseBody
	public String getTopicById(HttpServletRequest request, HttpServletResponse response, Model m) {
		JSONObject json = new JSONObject();
		Object[] returnData = adminService.getTopicsDataById(Long.valueOf(request.getParameter("id")));
		if (returnData != null) {
			json.put("id", returnData[0].toString());
			json.put("title", returnData[1].toString());
			json.put("mainTopicId", returnData[2].toString());
			json.put("url", returnData[3].toString());
			json.put("orderNo", returnData[4].toString());
			json.put("description", returnData[5].toString());
		}
		return json.toString();
	}

	@RequestMapping(value = "/get-article-by-id", method = RequestMethod.GET)
	@ResponseBody
	public String getArticaleById(HttpServletRequest request, HttpServletResponse response, Model m) {
		JSONObject json = new JSONObject();
		Object[] returnData = adminService.getArticleDataById(Long.valueOf(request.getParameter("id")));
		if (returnData != null) {
			json.put("id", returnData[0].toString());
			json.put("title", returnData[1].toString());
			json.put("orderNo", returnData[2].toString());
			json.put("article", returnData[3].toString());
		}
		return json.toString();
	}

}
