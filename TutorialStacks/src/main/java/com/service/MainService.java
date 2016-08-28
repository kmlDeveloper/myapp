package com.service;

import java.util.List;

public interface MainService {

	public String getSearchedList(String term);

	public String getBlogData(Long topicId);

	public String getBlogHomeData(String url);

	public List<Object[]> getMenuList(Long mainTopicId);
}
