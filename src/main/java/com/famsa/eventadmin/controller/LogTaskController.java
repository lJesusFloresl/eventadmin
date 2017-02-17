package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.LogTask;
import com.famsa.eventadmin.service.LogTaskService;

@RestController
@RequestMapping("/api/v1/logtask")
public class LogTaskController {

	@Autowired
	private LogTaskService service;

	@RequestMapping(method = RequestMethod.POST)
	public LogTask create(@RequestBody LogTask entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public LogTask update(@RequestBody LogTask entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<LogTask> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public LogTask findByIdFetch(@PathVariable("id") Long id) {
		return service.findByIdFetch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "taskId" })
	public List<LogTask> findAllByTaskId(@RequestParam Integer taskId) {
		return service.findAllByTaskId(taskId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "statusExecutionId" })
	public List<LogTask> findAllByTaskId(@RequestParam Short statusExecutionId) {
		return service.findAllByStatusExecutionId(statusExecutionId);
	}
	
}
