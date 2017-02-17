package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.StatusExecution;
import com.famsa.eventadmin.service.StatusExecutionService;

@RestController
@RequestMapping("/api/v1/statusexecution")
public class StatusExecutionController {

	@Autowired
	private StatusExecutionService service;

	@RequestMapping(method = RequestMethod.POST)
	public StatusExecution create(@RequestBody StatusExecution entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public StatusExecution update(@RequestBody StatusExecution entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Short id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<StatusExecution> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StatusExecution findByIdFetch(@PathVariable("id") Short id) {
		return service.findByIdFetch(id);
	}
	
}
