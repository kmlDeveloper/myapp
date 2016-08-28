package com.service;

import java.util.List;
import java.util.Map;

import com.table.TblSubTopics;

public interface AdminService {

	public List<Object[]> verifyAdmin(String email, String password);

	public String addMainTopics(Map<String, String> map);

	public Map<String, String> getMainTopicsList();

	public String addSubTopics(TblSubTopics tblSubTopics);

	public Map<String, String> getSubTopicsList();

	public String addTopics(Map<String, String> map);

	public List<Object[]> getMainTopicsGridData();

	public Object[] getMainTopicsDataById(Long id);

	public List<Object[]> getTopicGridData();

	public Object[] getTopicsDataById(Long id);

	public List<Object[]> getArticleGridData();

	public Object[] getArticleDataById(Long id);

	public String addArticle(Map<String, String> map);

	public List<Object[]> getArticleHomeData(String var);

	public List<Object[]> getRecentArticle();

}
