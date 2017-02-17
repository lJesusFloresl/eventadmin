package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.StatusTask;
import com.famsa.eventadmin.service.StatusTaskService;

@RestController
@RequestMapping("/api/v1/statustask")
public class StatusTaskController {

	@Autowired
	private StatusTaskService service;

	@RequestMapping(method = RequestMethod.POST)
	public StatusTask create(@RequestBody StatusTask entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public StatusTask update(@RequestBody StatusTask entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Short id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<StatusTask> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StatusTask findByIdFetch(@PathVariable("id") Short id) {
		return service.findByIdFetch(id);
	}
	
}
