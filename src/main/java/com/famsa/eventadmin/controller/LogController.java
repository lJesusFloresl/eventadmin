package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.Log;
import com.famsa.eventadmin.service.LogService;

@RestController
@RequestMapping("/api/v1/log")
public class LogController {

	@Autowired
	private LogService service;

	@RequestMapping(method = RequestMethod.POST)
	public Log create(@RequestBody Log entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Log update(@RequestBody Log entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Log> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Log findByIdFetch(@PathVariable("id") Long id) {
		return service.findByIdFetch(id);
	}
	
}
