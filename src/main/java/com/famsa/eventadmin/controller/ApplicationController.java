package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.Application;
import com.famsa.eventadmin.service.ApplicationService;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

	@Autowired
	private ApplicationService service;

	@RequestMapping(method = RequestMethod.POST)
	public Application create(@RequestBody Application entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Application update(@RequestBody Application entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Application> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Application findByIdFetch(@PathVariable("id") Integer id) {
		return service.findByIdFetch(id);
	}
	
}
