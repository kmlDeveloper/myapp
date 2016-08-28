package com.table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_topics")
public class TblTopics {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "main_topics_id")
	private TblMainTopics tblMainTopics;

	@ManyToOne
	@JoinColumn(name = "sub_topics_id")
	private TblSubTopics tblSubTopics;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "topic_url")
	private String topicUrl;

	@Column(name = "order_no")
	private Integer orderNo;

	@Column(name = "status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public TblMainTopics getTblMainTopics() {
		return tblMainTopics;
	}

	public void setTblMainTopics(TblMainTopics tblMainTopics) {
		this.tblMainTopics = tblMainTopics;
	}

	public TblSubTopics getTblSubTopics() {
		return tblSubTopics;
	}

	public void setTblSubTopics(TblSubTopics tblSubTopics) {
		this.tblSubTopics = tblSubTopics;
	}

	public String getTopicUrl() {
		return topicUrl;
	}

	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}
