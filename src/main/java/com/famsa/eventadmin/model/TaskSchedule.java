package com.famsa.eventadmin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task_schedule")
public class TaskSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime_execution", nullable = true)
	private Date dateTimeExecution;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_execution_id", nullable = false)
	private StatusExecution statusExecution;

	public TaskSchedule() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTimeExecution() {
		return dateTimeExecution;
	}

	public void setDateTimeExecution(Date dateTimeExecution) {
		this.dateTimeExecution = dateTimeExecution;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public StatusExecution getStatusExecution() {
		return statusExecution;
	}

	public void setStatusExecution(StatusExecution statusExecution) {
		this.statusExecution = statusExecution;
	}

}