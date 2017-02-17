package com.famsa.eventadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.famsa.eventadmin.model.FrequencyType;
import com.famsa.eventadmin.service.FrequencyTypeService;

@RestController
@RequestMapping("/api/v1/frequencytype")
public class FrequencyTypeController {

	@Autowired
	private FrequencyTypeService service;

	@RequestMapping(method = RequestMethod.POST)
	public FrequencyType create(@RequestBody FrequencyType entity) {
		return service.create(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public FrequencyType update(@RequestBody FrequencyType entity) {
		return service.update(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Short id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FrequencyType> findAllFetch() {
		return service.findAllFetch();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FrequencyType findByIdFetch(@PathVariable("id") Short id) {
		return service.findByIdFetch(id);
	}
	
}
