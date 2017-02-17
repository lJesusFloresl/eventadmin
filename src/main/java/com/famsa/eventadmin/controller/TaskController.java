package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.Task;
import com.famsa.eventadmin.service.TaskService;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

	@Autowired
	private TaskService service;

	@RequestMapping(method = RequestMethod.POST)
	public Task create(@RequestBody Task entity) {
		return service.createTaskAndSchedule(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Task update(@RequestBody Task entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Task> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Task findByIdFetch(@PathVariable("id") Integer id) {
		return service.findByIdFetch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "frequencyTypeId" })
	public List<Task> findAllByFrequencyTypeId(@RequestParam Short frequencyTypeId) {
		return service.findAllByFrequencyTypeId(frequencyTypeId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "requestTypeId" })
	public List<Task> findAllByRequestTypeId(@RequestParam Short requestTypeId) {
		return service.findAllByRequestTypeId(requestTypeId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "serviceTypeId" })
	public List<Task> findAllByServiceTypeId(@RequestParam Short serviceTypeId) {
		return service.findAllByServiceTypeId(serviceTypeId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "statusTaskId" })
	public List<Task> findAllByStatusTaskId(@RequestParam Short statusTaskId) {
		return service.findAllByStatusTaskId(statusTaskId);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "taskTypeId" })
	public List<Task> findAllByTaskTypeId(@RequestParam Short taskTypeId) {
		return service.findAllByTaskTypeId(taskTypeId);
	}
	
	@RequestMapping(value = "/populatedummy", method = RequestMethod.GET)
	public Task populateDummyTask() {
		return service.populateDummyTask();
	}
}
