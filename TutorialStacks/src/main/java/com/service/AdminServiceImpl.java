package com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.table.TblArticles;
import com.table.TblMainTopics;
import com.table.TblSubTopics;
import com.table.TblTopics;

public class AdminServiceImpl implements AdminService {

	private SessionFactory sessionFactory;

	public AdminServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Object[]> verifyAdmin(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.name FROM TblLogin t WHERE t.password= :password AND t.username= :username";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("password", password);
		query.setParameter("username", username);
		List<Object[]> user = query.list();
		return user;
	}

	@Override
	@Transactional
	public Map<String, String> getMainTopicsList() {
		Map<String, String> returnMap = new HashMap<String, String>();
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.mainTopic FROM TblMainTopics t";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> topics = query.list();
		if (topics != null && !topics.isEmpty()) {
			for (Object[] obj : topics) {
				returnMap.put(obj[0].toString(), obj[1].toString());
			}
		}
		return returnMap;
	}

	@Override
	@Transactional
	public String addSubTopics(TblSubTopics tblSubTopics) {
		String result = "error";
		try {
			sessionFactory.getCurrentSession().save(tblSubTopics);
			result = "sub.topics";
		} catch (Exception e) {
			result = "error";
		}
		return result;
	}

	@Override
	@Transactional
	public Map<String, String> getSubTopicsList() {
		Map<String, String> returnMap = new HashMap<String, String>();
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.subTopics FROM TblSubTopics t";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> topics = query.list();
		if (topics != null && !topics.isEmpty()) {
			for (Object[] obj : topics) {
				returnMap.put(obj[0].toString(), obj[1].toString());
			}
		}
		return returnMap;
	}

	@Override
	@Transactional
	public List<Object[]> getMainTopicsGridData() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.mainTopic,t.status FROM TblMainTopics t";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> topics = query.list();
		return topics;
	}

	@Override
	@Transactional
	public Object[] getMainTopicsDataById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.mainTopic,t.status FROM TblMainTopics t WHERE t.id= :id";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("id", id);
		List<Object[]> topics = query.list();
		return topics != null ? topics.get(0) : null;
	}

	@Override
	@Transactional
	public String addMainTopics(Map<String, String> map) {
		String result = "error";
		try {
			TblMainTopics tblMainTopics = new TblMainTopics();
			if (map.get("id") != null && !map.get("id").equals("")) {
				sessionFactory.getCurrentSession().load(tblMainTopics, Long.valueOf(map.get("id")));
			}
			tblMainTopics.setMainTopic(map.get("mainTopics"));
			tblMainTopics.setCreatedDate(new Date());
			sessionFactory.getCurrentSession().save(tblMainTopics);
			result = "main.topics";
		} catch (Exception e) {
			result = "error";
		}
		return result;
	}

	@Override
	@Transactional
	public List<Object[]> getTopicGridData() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,tm.mainTopic,t.topicUrl,t.orderNo,t.status FROM TblTopics t LEFT JOIN t.tblMainTopics tm";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> topics = query.list();
		return topics;
	}

	@Override
	@Transactional
	public Object[] getTopicsDataById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,t.tblMainTopics.id,t.topicUrl,t.orderNo,t.description FROM TblTopics t Where t.id= :id";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("id", id);
		List<Object[]> topics = query.list();
		return topics != null ? topics.get(0) : null;
	}

	@Override
	@Transactional
	public String addTopics(Map<String, String> map) {
		String result = "error";
		try {
			TblTopics tblTopics = new TblTopics();
			if (map.get("id") != null && !map.get("id").equals("")) {
				sessionFactory.getCurrentSession().load(tblTopics, Long.valueOf(map.get("id")));
			}

			tblTopics.setTitle(map.get("title"));
			tblTopics.setDescription(map.get("description"));

			TblMainTopics tblMainTopics = new TblMainTopics();
			tblMainTopics.setId(Long.valueOf(map.get("mainTopicId")));
			tblTopics.setTblMainTopics(tblMainTopics);

			tblTopics.setTopicUrl(map.get("topicUrl"));
			tblTopics.setOrderNo(Integer.valueOf(map.get("orderNo")));

			tblTopics.setCreatedDate(new Date());
			sessionFactory.getCurrentSession().save(tblTopics);
			result = "topics";
		} catch (Exception e) {
			result = "error";
		}
		return result;
	}

	@Override
	@Transactional
	public List<Object[]> getArticleGridData() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,t.orderNo,t.status,t.createdDate FROM TblArticles t";
		Query query = session.createQuery(sqlQuery);
		List<Object[]> objectList = query.list();
		return objectList;
	}

	@Override
	@Transactional
	public Object[] getArticleDataById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,t.orderNo,t.article FROM TblArticles t Where t.id= :id";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("id", id);
		List<Object[]> objectList = query.list();
		return objectList != null && !objectList.isEmpty() ? objectList.get(0) : null;
	}

	@Override
	@Transactional
	public String addArticle(Map<String, String> map) {
		String result = "error";
		try {
			TblArticles tblArticles = new TblArticles();
			if (map.get("id") != null && !map.get("id").equals("")) {
				sessionFactory.getCurrentSession().load(tblArticles, Long.valueOf(map.get("id")));
			}
			tblArticles.setTitle(map.get("title"));
			tblArticles.setArticle(map.get("article"));
			tblArticles.setStatus(1);
			tblArticles.setOrderNo(Integer.valueOf(map.get("orderNo")));
			tblArticles.setCreatedDate(new Date());
			sessionFactory.getCurrentSession().save(tblArticles);
			result = "topics";
		} catch (Exception e) {
			result = "error";
		}
		return result;
	}

	@Override
	@Transactional
	public List<Object[]> getArticleHomeData(String var) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,t.article,t.created_date FROM tbl_articles t";
		if (var.equals("1")) {
			sqlQuery += " limit 5";
		}

		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> objectList = query.list();
		return objectList;
	}

	@Override
	@Transactional
	public List<Object[]> getRecentArticle() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT t.id,t.title,t.created_date FROM tbl_articles t  order by t.created_date desc limit 4";
		Query query = session.createSQLQuery(sqlQuery);
		List<Object[]> objectList = query.list();
		return objectList;
	}
}
