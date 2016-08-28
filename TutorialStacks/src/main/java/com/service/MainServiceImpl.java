package com.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

public class MainServiceImpl implements MainService {

	private SessionFactory sessionFactory;

	public MainServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public String getSearchedList(String term) {
		List<String> list = new ArrayList<String>();
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.title FROM TblTopics t WHERE t.topicUrl LIKE :term";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("term", "%" + term + "%");
		List<String> searchList = query.list();
		if (searchList != null && !searchList.isEmpty() && searchList.get(0) != null) {
			for (Object obj : searchList) {
				list.add(obj.toString());
			}
		}

		return new Gson().toJson(list);
	}

	@Override
	@Transactional
	public String getBlogHomeData(String url) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id FROM TblTopics t WHERE t.topicUrl LIKE :url";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("url", url);
		List<Long> blogObj = query.list();
		String blog = null;
		if (blogObj != null && !blogObj.isEmpty() && blogObj.get(0) != null) {
			blog = blogObj.get(0).toString();
		}
		return blog;
	}

	@Override
	@Transactional
	public String getBlogData(Long topicId) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.description FROM TblTopics t WHERE t.id = :topicId";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("topicId", topicId);
		List<String> blogObj = query.list();
		String blog = null;
		if (blogObj != null && !blogObj.isEmpty() && blogObj.get(0) != null) {
			blog = blogObj.get(0).toString();
		}
		return blog;
	}

	@Override
	@Transactional
	public List<Object[]> getMenuList(Long mainTopicId) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.topicUrl,t.title FROM TblTopics t WHERE t.tblMainTopics.id = :id";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("id", mainTopicId);
		List<Object[]> menuList = query.list();
		return menuList;
	}

}
