package com.famsa.eventadmin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`log`")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_log", nullable = true)
	private Date dateLog = new Date();

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "log", cascade = CascadeType.REMOVE)
	private List<LogTask> logTasks;

	public Log() {
		super();
	}

	public Log(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateLog() {
		return dateLog;
	}

	public void setDateLog(Date dateLog) {
		this.dateLog = dateLog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LogTask> getLogTasks() {
		return logTasks;
	}

	public void setLogTasks(List<LogTask> logTasks) {
		this.logTasks = logTasks;
	}

}