package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.StatusExecution;
import com.famsa.eventadmin.repository.StatusExecutionRepository;

@Service
public class StatusExecutionService {

	@Autowired
	private StatusExecutionRepository repository;

	private static final Logger LOGGER = Logger.getLogger(StatusExecution.class);

	@Transactional
	public StatusExecution create(StatusExecution entity) {
		LOGGER.debug("create -->");
		StatusExecution ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public StatusExecution update(StatusExecution entity) {
		LOGGER.debug("update -->");
		StatusExecution ent = repository.saveAndFlush(entity);
		LOGGER.debug("update //>");
		return ent;
	}
	
	@Transactional
	public void delete(Short id) {
		LOGGER.debug("delete -->");
		repository.delete(id);
		LOGGER.debug("delete //>");
	}

	@Transactional(readOnly = true)
	public StatusExecution findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		StatusExecution ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<StatusExecution> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<StatusExecution> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
