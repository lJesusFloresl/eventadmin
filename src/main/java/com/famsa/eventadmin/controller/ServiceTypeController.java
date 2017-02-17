package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.ServiceType;
import com.famsa.eventadmin.service.ServiceTypeService;

@RestController
@RequestMapping("/api/v1/servicetype")
public class ServiceTypeController {

	@Autowired
	private ServiceTypeService service;

	@RequestMapping(method = RequestMethod.POST)
	public ServiceType create(@RequestBody ServiceType entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ServiceType update(@RequestBody ServiceType entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Short id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceType> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ServiceType findByIdFetch(@PathVariable("id") Short id) {
		return service.findByIdFetch(id);
	}
	
}
