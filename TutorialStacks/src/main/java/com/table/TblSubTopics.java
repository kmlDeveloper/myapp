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
@Table(name = "tbl_sub_topics")
public class TblSubTopics {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "sub_topics")
	private String subTopics;

	@Column(name = "created_date")
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "main_topics")
	private TblMainTopics tblMainTopics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(String subTopics) {
		this.subTopics = subTopics;
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

}
