package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.TaskApplication;
import com.famsa.eventadmin.service.TaskApplicationService;

@RestController
@RequestMapping("/api/v1/taskapplication")
public class TaskApplicationController {

	@Autowired
	private TaskApplicationService service;

	@RequestMapping(method = RequestMethod.POST)
	public TaskApplication create(@RequestBody TaskApplication entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public TaskApplication update(@RequestBody TaskApplication entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TaskApplication> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TaskApplication findByIdFetch(@PathVariable("id") Integer id) {
		return service.findByIdFetch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "taskId" })
	public List<TaskApplication> findAllByTaskId(@RequestParam Integer taskId) {
		return service.findAllByTaskId(taskId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "applicationId" })
	public List<TaskApplication> findAllByApplicationId(@RequestParam Integer applicationId) {
		return service.findAllByApplicationId(applicationId);
	}
	
}
