package com.famsa.eventadmin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status_execution")
public class StatusExecution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private short id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "statusExecution", cascade = CascadeType.REMOVE)
	private List<LogTask> logTasks;
	
	@OneToMany(mappedBy = "statusExecution", cascade = CascadeType.REMOVE)
	private List<TaskSchedule> taskSchedules;

	public StatusExecution() {
		super();
	}

	public StatusExecution(short id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LogTask> getLogTasks() {
		return logTasks;
	}

	public void setLogTasks(List<LogTask> logTasks) {
		this.logTasks = logTasks;
	}

	public List<TaskSchedule> getTaskSchedules() {
		return taskSchedules;
	}

	public void setTaskSchedules(List<TaskSchedule> taskSchedules) {
		this.taskSchedules = taskSchedules;
	}
}