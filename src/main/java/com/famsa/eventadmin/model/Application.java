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
@Table(name = "`application`")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "application", cascade = CascadeType.REMOVE)
	private List<TaskApplication> taskApplications;

	public Application() {
		super();
	}

	public Application(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public List<TaskApplication> getTaskApplications() {
		return taskApplications;
	}

	public void setTaskApplications(List<TaskApplication> taskApplications) {
		this.taskApplications = taskApplications;
	}
}