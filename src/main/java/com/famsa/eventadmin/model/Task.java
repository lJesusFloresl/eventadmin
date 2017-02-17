package com.famsa.eventadmin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`task`")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "endpoint")
	private String endpoint;

	@Column(name = "sunday", nullable = true)
	private Boolean sunday;

	@Column(name = "monday", nullable = true)
	private Boolean monday;

	@Column(name = "tuesday", nullable = true)
	private Boolean tuesday;

	@Column(name = "wednesday", nullable = true)
	private Boolean wednesday;

	@Column(name = "thursday", nullable = true)
	private Boolean thursday;

	@Column(name = "friday", nullable = true)
	private Boolean friday;

	@Column(name = "saturday", nullable = true)
	private Boolean saturday;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_start", nullable = true)
	private Date dateStart;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_end", nullable = true)
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_hour_execution", nullable = true)
	private Date dateHourExecution;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = true)
	private Date dateCreated = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_last_change", nullable = true)
	private Date dateLastChange = new Date();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "frequency_type_id", nullable = false)
	private FrequencyType frequencyType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_type_id", nullable = false)
	private ServiceType serviceType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "request_type_id", nullable = false)
	private RequestType requestType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_task_id", nullable = false)
	private StatusTask statusTask;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_type_id", nullable = false)
	private TaskType taskType;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
	private List<LogTask> logTasks;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
	private List<TaskSchedule> taskSchedules;

	public Task() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateHourExecution() {
		return dateHourExecution;
	}

	public void setDateHourExecution(Date dateHourExecution) {
		this.dateHourExecution = dateHourExecution;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastChange() {
		return dateLastChange;
	}

	public void setDateLastChange(Date dateLastChange) {
		this.dateLastChange = dateLastChange;
	}

	public FrequencyType getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(FrequencyType frequencyType) {
		this.frequencyType = frequencyType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public StatusTask getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(StatusTask statusTask) {
		this.statusTask = statusTask;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
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