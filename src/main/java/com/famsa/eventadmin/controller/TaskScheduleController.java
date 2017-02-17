package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.TaskSchedule;
import com.famsa.eventadmin.service.TaskScheduleService;

@RestController
@RequestMapping("/api/v1/taskschedule")
public class TaskScheduleController {

	@Autowired
	private TaskScheduleService service;

	@RequestMapping(method = RequestMethod.POST)
	public TaskSchedule create(@RequestBody TaskSchedule entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public TaskSchedule update(@RequestBody TaskSchedule entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TaskSchedule> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TaskSchedule findByIdFetch(@PathVariable("id") Long id) {
		return service.findByIdFetch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "taskId" })
	public List<TaskSchedule> findAllByTaskId(@RequestParam Integer taskId) {
		return service.findAllByTaskId(taskId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "statusExecutionId" })
	public List<TaskSchedule> findAllByTaskId(@RequestParam Short statusExecutionId) {
		return service.findAllByStatusExecutionId(statusExecutionId);
	}
	
}
