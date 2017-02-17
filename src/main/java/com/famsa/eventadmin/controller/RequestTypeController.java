package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.RequestType;
import com.famsa.eventadmin.service.RequestTypeService;

@RestController
@RequestMapping("/api/v1/requesttype")
public class RequestTypeController {

	@Autowired
	private RequestTypeService service;

	@RequestMapping(method = RequestMethod.POST)
	public RequestType create(@RequestBody RequestType entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public RequestType update(@RequestBody RequestType entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Short id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<RequestType> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RequestType findByIdFetch(@PathVariable("id") Short id) {
		return service.findByIdFetch(id);
	}
	
}
