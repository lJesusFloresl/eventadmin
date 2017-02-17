package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.Application;
import com.famsa.eventadmin.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository repository;

	private static final Logger LOGGER = Logger.getLogger(Application.class);

	@Transactional
	public Application create(Application entity) {
		LOGGER.debug("create -->");
		Application ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public Application update(Application entity) {
		LOGGER.debug("update -->");
		Application ent = repository.saveAndFlush(entity);
		LOGGER.debug("update //>");
		return ent;
	}
	
	@Transactional
	public void delete(Integer id) {
		LOGGER.debug("delete -->");
		repository.delete(id);
		LOGGER.debug("delete //>");
	}

	@Transactional(readOnly = true)
	public Application findByIdFetch(Integer id) {
		LOGGER.debug("findByIdFetch -->");
		Application ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<Application> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<Application> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
